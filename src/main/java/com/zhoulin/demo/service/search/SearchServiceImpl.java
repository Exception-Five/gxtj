package com.zhoulin.demo.service.search;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.index.reindex.DeleteByQueryRequestBuilder;
import org.elasticsearch.rest.RestStatus;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import com.zhoulin.demo.bean.Information;
import com.zhoulin.demo.service.InformationService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SearchServiceImpl implements SearchService{

    private static final Logger logger = LoggerFactory.getLogger(SearchService.class);

    private static final String INDEX_NAME = "information";

    private static final String INDEX_TYPE = "information";

    //kafka监听的主题
    private static final String INDEX_TOPIC = "information";

    @Autowired
    private InformationService informationService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TransportClient esClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = INDEX_TOPIC)
    private void handleMessage(String content){
        try {
            //ObjectMapper: 将java对象转化成json格式
            InformationIndexMessage message = objectMapper.readValue(content, InformationIndexMessage.class);

            switch (message.getOperation()){
                case InformationIndexMessage.INDEX:
                    this.createOrUpdateIndex(message);
                    break;
                case InformationIndexMessage.REMOVE:
                    this.removeIndex(message);
                    break;
                default:
                    logger.warn("不支持处理该信息操作", content);
                    break;
            }

        } catch (IOException e) {
            logger.error("转化json格式失败", content, e);
        }
    }

    private void createOrUpdateIndex(InformationIndexMessage message){

        Long id = message.getInfoId();

        Information information = new Information();

        try {
            information = informationService.getInfoByInfoId(id);

            if(information==null){
                logger.error("无对应id的资讯", id);
                this.index(id, message.getRetry() + 1);
                return;
            }

            InformationIndexTemplate indexTemplate = new InformationIndexTemplate();
            modelMapper.map(information, indexTemplate);

            SearchRequestBuilder requestBuilder = this.esClient
                    .prepareSearch(INDEX_NAME)
                    .setTypes(INDEX_TYPE)
                    .setQuery(QueryBuilders.termQuery(InformationIndexKey.ID, id));

            logger.debug(requestBuilder.toString());

            SearchResponse searchResponse = requestBuilder.get();

            boolean isSuccess;

            long totalHit = searchResponse.getHits().getTotalHits();

            if(totalHit == 0){
                isSuccess = create(indexTemplate);
            }else if(totalHit == 1){
                String esId = searchResponse.getHits().getAt(0).getId();
                isSuccess = update(esId, indexTemplate);
            }else {
                isSuccess = deleteAndCreate(totalHit, indexTemplate);
            }

            if (isSuccess) {
                logger.debug("执行成功的资讯" + id);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removeIndex(InformationIndexMessage message){

        long id = message.getInfoId();

        DeleteByQueryRequestBuilder builder = DeleteByQueryAction.INSTANCE
                .newRequestBuilder(esClient)
                .filter(QueryBuilders.termQuery(InformationIndexKey.ID, id))
                .source(INDEX_NAME);

        logger.debug("Delete by query for info:" + builder);

        BulkByScrollResponse response = builder.get();
        long deleted = response.getDeleted();
        logger.debug("Delete total: " + deleted);

        if(deleted<=0){
            this.remove(id, message.getRetry() + 1);
        }

    }

    @Override
    public void index(long id) {
        this.index(id, 0);
    }

    private void index(long id, Integer retry){
        if(retry > InformationIndexMessage.MAX_RETRY){
            logger.error("超过最大请求索引次数" + id );
            return;
        }

        InformationIndexMessage message = new InformationIndexMessage(id, InformationIndexMessage.INDEX, retry);

        try {
            kafkaTemplate.send(INDEX_TOPIC, objectMapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            logger.error("json转换错误 " + message, e);
        }

    }

    private boolean create(InformationIndexTemplate indexTemplate){

        try {
            IndexResponse response = this.esClient
                    .prepareIndex(INDEX_NAME, INDEX_TYPE)
                    .setSource(objectMapper.writeValueAsBytes(indexTemplate), XContentType.JSON)
                    .get();

            logger.debug("添加资讯索引" + indexTemplate.getId());

            if (response.status() == RestStatus.CREATED){
                return true;
            } else {
                return false;
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.debug("添加资讯索引异常！" + indexTemplate.getId(), e);
            return false;
        }

    }

    private boolean update(String esId, InformationIndexTemplate indexTemplate){

        try {
            UpdateResponse response = this.esClient
                    .prepareUpdate(INDEX_NAME, INDEX_TYPE, esId)
                    .setDoc(objectMapper.writeValueAsBytes(indexTemplate), XContentType.JSON)
                    .get();

            logger.debug("更新资讯索引" + indexTemplate.getId());

            if (response.status() == RestStatus.OK){
                return true;
            } else {
                return false;
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.debug("更新资讯索引异常！" + indexTemplate.getId(), e);
            return false;
        }

    }

    private boolean deleteAndCreate(long totalHit, InformationIndexTemplate indexTemplate){
        DeleteByQueryRequestBuilder builder = DeleteByQueryAction.INSTANCE
                .newRequestBuilder(esClient)
                .filter(QueryBuilders.termQuery(InformationIndexKey.ID, indexTemplate.getId()))
                .source(INDEX_NAME);

        logger.debug("Delete by query for info:" + builder);

        BulkByScrollResponse response = builder.get();
        long deleted = response.getDeleted();
        if(deleted != totalHit){
            logger.warn("需要删除 {}, 但是实际删除 {}", totalHit, deleted);
            return false;
        }else {
            return create(indexTemplate);
        }

    }

    @Override
    public void remove(long id) {
        //retry 传递给kafka
        this.remove(id, 0);
    }

    private void remove(long id, Integer retry){
        if(retry > InformationIndexMessage.MAX_RETRY){
            logger.error("超过最大请求索引次数" + id );
            return;
        }

        InformationIndexMessage message = new InformationIndexMessage(id, InformationIndexMessage.REMOVE, retry);

        try {
            //传递给kafka 使得kafka消费掉
            kafkaTemplate.send(INDEX_TOPIC, objectMapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            logger.error("json转换错误 " + message, e);
        }
    }
}
