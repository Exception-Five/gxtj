package com.zhoulin.demo.service.impl;

import com.ansj.vec.Word2VEC;
import com.google.common.primitives.Longs;
import com.textrank.TextRankKeyword;
import com.textrank.TextRankSummary;
import com.zhoulin.demo.bean.InfoSort;
import com.zhoulin.demo.bean.Information;
import com.zhoulin.demo.bean.TypeRelation;
import com.zhoulin.demo.bean.form.InfoSearch;
import com.zhoulin.demo.bean.form.ServiceMultiResult;
import com.zhoulin.demo.mapper.TypeRelationMapper;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.ModService;
import com.zhoulin.demo.service.search.InformationIndexKey;
import com.zhoulin.demo.utils.TokenizerAnalyzerUtils;
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

    @Autowired
    private TypeRelationMapper relationMapper;

    /**
     * 分析并提取关键词
     * @param id
     * @return
     */
    @Override
    public boolean modAnalyse(long id){

        String content = "";

//        List<String> summary = new ArrayList<>();

        String keyword = "";

        Integer status = 0;

        Information information = new Information();

        TypeRelation typeRelation = new TypeRelation();

        try {

            information = informationService.getInfoByInfoId(id);

            typeRelation = relationMapper.getInfoByTRId(id);

            content = typeRelation.getOnlyText() +  information.getDescription() + information.getTitle();

//            summary = TextRankSummary.getTopSentenceList(content, 100);

            System.out.println("content>>>" + content);

            //提取关键字
            List<String> keywords = new TextRankKeyword().getKeyword("", content);

            for (String kw : keywords) {
                keyword = keyword + kw + ",";
            }

            String tokenizerResult = TokenizerAnalyzerUtils.getAnalyzerResult(keyword);

            logger.info("获取的关键词为 >>>>> " + tokenizerResult);

            information.setKeyword(tokenizerResult);

            //关键词存储到mysql
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

    /**
     * 兴趣分析
     * @param infoSearch
     * @return
     */
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

    /**
     * 新闻类型划分
     * @param id
     * @param type
     * @return
     * @throws Exception
     */
    @Override
    public String modForInfoType(long id, String type) throws Exception {

        String content = "";

        String w2vS = "";

        Integer status = 0;

        Integer infoStatus = 0;

        Integer matchNum = 0;

        boolean sentence = false;

        List<String> kws = new ArrayList<>();

        Information information = new Information();

        TypeRelation typeRelation = new TypeRelation();

        try {

            information = informationService.getInfoByInfoId(id);

            typeRelation = relationMapper.getInfoByTRId(id);

            content = typeRelation.getOnlyText() + information.getDescription() + information.getTitle();

            System.out.println("!!!!" + typeRelation.getOnlyText());

            //提取关键字
//            List<String> keywords = new TextRankKeyword().getKeyword("", typeRelation.getOnlyText());

//            List<String> keywords = new Split().getKwList(information.getKeyword());

            Word2VEC vec = new Word2VEC();
            //加载训练模型
            vec.loadJavaModel("D:\\Java\\generator\\gxtj\\src\\main\\resources\\library\\comment\\vector030806.mod");

            //得到类型 关键词范围
            kws = vec.distance(type);

            for (String kwT:kws) {
                if (content.contains(kwT)){
                    logger.info("!!! 匹配成功 " + kwT);
                    matchNum  = matchNum + 1;
                }
            }

            //向量词匹配的次数到达5次 ！！！
            if (matchNum >= 5){
                sentence = true;
            }
//            for (String kw : keywords) {
//                if (kws.contains(kw)){
//                    logger.info("匹配成功！已归类！" + type + ">>>" + kw);
//                    //如果匹配成功 返回判断成功
//                    sentence = true;
//                }
//                w2vS = w2vS + kw + " ";
//            }
//
//            logger.info("获取的关键词为 >>>>> " + w2vS);

            if (sentence == true){
                //判断成功执行keyword字段更新
//                information.setKeyword(w2vS);

                //插入
                typeRelation.setInfoId(id);
                typeRelation.setType(type);

//                infoStatus = informationService.updateInformation(information);

                status = relationMapper.updateTypeRelationByInfoId(typeRelation);
            }

            if (status == 1){
                return type;
            }
            return null;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }

    }

}
