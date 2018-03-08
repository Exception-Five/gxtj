package com.zhoulin.demo.service.impl;

import com.google.common.primitives.Longs;
import com.textrank.TextRankKeyword;
import com.textrank.TextRankSummary;
import com.zhoulin.demo.bean.InfoSort;
import com.zhoulin.demo.bean.Information;
import com.zhoulin.demo.bean.form.InfoSearch;
import com.zhoulin.demo.bean.form.ServiceMultiResult;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.ModService;
import com.zhoulin.demo.service.search.InformationIndexKey;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 模型分析
 */
@Component
public class ModServiceImpl implements ModService{

    private static final Logger logger = LoggerFactory.getLogger(ModServiceImpl.class);

    private static final String INDEX_NAME = "information";

    private static final String INDEX_TYPE = "information";

    //kafka监听的主题
    private static final String INDEX_TOPIC = "information";

    @Autowired
    private TransportClient esClient;

    @Autowired
    private InformationService informationService;

    @Override
    public boolean modAnalyse(long id){

        String content = "";

        List<String> summary = new ArrayList<>();

        String keyword = "";

        Integer status = 0;

        Information information = new Information();

        try {

            information = informationService.getInfoByInfoId(id);

            content = information.getContent() + information.getDescription() + information.getTitle();

            summary = TextRankSummary.getTopSentenceList(content, 50);

            //提取关键字
            List<String> keywords = new TextRankKeyword().getKeyword("", String.valueOf(summary));

            keyword = keywords.get(0) + "," + keywords.get(1) + "," + keywords.get(2) + "," + keywords.get(3) + "," + keywords.get(4)+ "," + keywords.get(2);

            logger.info("获取的关键词为 >>>>> " + keyword);

            information.setKeyword(keyword);

            status = informationService.updateInformation(information);

            if (status == 1){
                return true;
            }

            return false;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }

    }

    @Override
    public ServiceMultiResult<Long> queryMuti(InfoSearch infoSearch) {

        SearchRequestBuilder requestBuilder = this.esClient.prepareSearch(INDEX_NAME)
                .setTypes(INDEX_TYPE)
                .setQuery(QueryBuilders.multiMatchQuery(infoSearch.getMutiContent(), "description","title","content"))
                .setExplain(true)
                .setFetchSource(InformationIndexKey.ID, null);

        logger.debug(requestBuilder.toString());

        List<Long> infoIds = new ArrayList<>();

        SearchResponse searchResponse = requestBuilder.get();

        if(searchResponse.status() != RestStatus.OK){
            logger.warn("Search status is no ok for " + requestBuilder);
            return new ServiceMultiResult<>(0, infoIds);
        }

        for (SearchHit hit : searchResponse.getHits()) {
            logger.debug(String.valueOf(hit.getSource()));
            infoIds.add(Longs.tryParse(String.valueOf(hit.getSource().get(InformationIndexKey.ID))));
        }

        return new ServiceMultiResult<>(searchResponse.getHits().totalHits, infoIds);

    }

}
