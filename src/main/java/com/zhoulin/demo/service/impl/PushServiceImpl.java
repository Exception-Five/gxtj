package com.zhoulin.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.textrank.TextRankKeyword;
import com.zhoulin.demo.bean.*;
import com.zhoulin.demo.bean.form.InfoSearch;
import com.zhoulin.demo.bean.form.ServiceMultiResult;
import com.zhoulin.demo.mapper.InfoImageMapper;
import com.zhoulin.demo.mapper.RecessiveGroupMapper;
import com.zhoulin.demo.mapper.TypeMapper;
import com.zhoulin.demo.mapper.TypeRelationMapper;
import com.zhoulin.demo.service.*;
import com.zhoulin.demo.utils.CheckType;
import com.zhoulin.demo.utils.Relation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 推送功能模块
 */
@Component
public class PushServiceImpl implements PushService {

    private static final Logger logger = LoggerFactory.getLogger(PushServiceImpl.class) ;

    @Autowired
    private ModService modService;

    @Autowired
    private RecessiveGroupMapper recessiveGroupMapper;

    @Autowired
    private InformationService informationService;

    @Autowired
    private LogInfoService logInfoService;

    @Autowired
    private TypeRelationMapper typeRelationMapper;

    @Autowired
    private InfoService infoService;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private CheckType checkType;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private InfoImageMapper infoImageMapper;

    @Override
    public List<Info> pushInformation(long id) {

        InfoSearch infoSearch = new InfoSearch();

        String keywords = "";

        List<Info> informationList = new ArrayList<>();

        try {

            Information information = informationService.getInfoByInfoId(id);

            keywords = information.getKeyword();

            infoSearch.setMutiContent(keywords);

            ServiceMultiResult<Long> multiResult = modService.queryMuti(infoSearch);

            for (Long infoId:multiResult.getResult()) {
//                Info infor = objectMapper.readValue(rs, Info.class);
//                logger.info("最终关键词为 :  " + information.toString());
                Info infor = infoService.getInfoByInfoIdForImage(infoId);
                informationList.add(infor);
            }

//            for (Info info : informationList) {
//                InfoImage image = infoImageMapper.getInfoImageByInfoId(info.getInfoId());
//                info.setInfoImage(image);
//            }

            return informationList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<UserInfo> pushInfoForRecessiveGroup(Integer typeId){

        List<RecessiveGroup> recessiveGroups = new ArrayList<>();
        try {
            //获得用户群
            recessiveGroups = recessiveGroupMapper.getUserRecessiveGroup(typeId);
            Integer userId = 0;

            for (RecessiveGroup recessiveGroup: recessiveGroups) {
                userId = recessiveGroup.getUserId();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * 根据 浏览日志 分析 用户兴趣点 进行推送
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<Info> logAnalyzForPush(Integer userId){
        List<Long> kwInfoIds = new ArrayList<>();
        List<Long> mergeInfoIds = new ArrayList<>();
        List<Long> tyInfoIds = new ArrayList<>();
//        List<Info> typeInformationList = new ArrayList<>();
//        List<Info> kwInformationList = new ArrayList<>();
//        List<Info> mergeInforList = new ArrayList<>();
        List<LogInfo> logInfos = new ArrayList<>();
        List<TypeRelation> typeRelations = new ArrayList<>();
        TypeRelation typeRelation = new TypeRelation();
        InfoSearch infoSearch = new InfoSearch();
        List<Long> infoIds = new ArrayList<>();
        List<Integer> types = new ArrayList<>();
        List<Integer> typeIds = new ArrayList<>();
        String keywords = "";
        String keywordsString = "";

        try {
            logInfos = logInfoService.getLogInfoByUserId(userId);
            for (LogInfo logInfo: logInfos) {
                //查找对应新闻的详细信息
                typeRelation = typeRelationMapper.getInfoByTRId(logInfo.getInfoId());
                Info info = infoService.getInfoByInfoId(logInfo.getInfoId());
                keywords = keywords + info.getKeyword();
//                Type type = typeMapper.getTypeByTypeId(typeRelation.getTypeId());
                types.add(typeRelation.getTypeId());
                infoIds.add(logInfo.getInfoId());
            }

            List<String> finalKeywords = new TextRankKeyword().getKeyword("", keywords);
            for (String kw : finalKeywords) {
                keywordsString = keywordsString + kw + ",";
            }
            logger.info("最终关键词为 :  " + keywordsString);
            //取出三个看得较多的类型的新闻
            List<Relation> rl = checkType.findMostType(types);

            for (Relation relation : rl) {
                typeIds.add(relation.getId());
            }

            List<TypeRelation> typeRelations1 = typeRelationMapper.getInfoByTypeId(rl.get(0).getId());
            List<TypeRelation> typeRelations2 = typeRelationMapper.getInfoByTypeId(rl.get(1).getId());
            List<TypeRelation> typeRelations3 = typeRelationMapper.getInfoByTypeId(rl.get(2).getId());


            for (TypeRelation type : typeRelations1) {
                typeRelations.add(type);
            }
            for (TypeRelation type : typeRelations2) {
                typeRelations.add(type);
            }
            for (TypeRelation type : typeRelations3) {
                typeRelations.add(type);
            }

            for (TypeRelation type : typeRelations) {
                //通过类型找到的新闻列表
                tyInfoIds.add(infoService.getInfoByInfoId(type.getInfoId()).getInfoId());
            }

            //根据关键词
            infoSearch.setMutiContent(keywordsString);
            //全局抓取
            ServiceMultiResult<Long> multiResult = modService.queryMuti(infoSearch);

//            for (String rs:multiResult.getResult()) {
//                Information information = objectMapper.readValue(rs, Information.class);
////                logger.info("最终关键词为 :  " + information.toString());
//                //通过关键词找到的新闻列表
//                Info info = new Info();
//
//                info.setInfoId(information.getId());
//                info.setTitle(information.getTitle());
//                info.setDescription(information.getDescription());
//                info.setKeyword(information.getKeyword());
//                info.setAuthor(information.getAuthor());
//                info.setReads(information.getReads());
//                info.setPublishDate(information.getPublishDate());
//                info.setLikes(information.getLikes());
//                info.setSourceSite(information.getSourceSite());
//                info.setScore(information.getScore());
//                info.setSourceUrl(information.getSourceUrl());
//
//                kwInformationList.add(info);
//            }

//            List<Long> kwInfoIds = new ArrayList<>();
            kwInfoIds = multiResult.getResult();
//            List<Long> mergeInfoIds = new ArrayList<>();
//            List<Long> tyInfoIds = new ArrayList<>();

//            System.out.println(l3 + "><" +l3.size());

            //获取交叉内容
//            for (int i=0;i<kwInformationList.size();i++) {
//                for (int j=0;j<typeInformationList.size();j++) {
//                    if (typeInformationList.get(j).getInfoId() == kwInformationList.get(i).getInfoId()){
//                        logger.info("匹配到交叉内容 ！！！ " );
//                        mergeInforList.add(kwInformationList.get(i));
//                        mergeInfoIds.add(kwInformationList.get(i).getInfoId());
//                    }
//                }
//            }

            for (int i=0;i<kwInfoIds.size();i++){
                for (int j=0;j<tyInfoIds.size();j++){
                    if (tyInfoIds.get(j).equals(kwInfoIds.get(i))){
                        logger.info("匹配到交叉内容 ！！！ " );
//                        mergeInforList.add(kwInformationList.get(i));
                        mergeInfoIds.add(kwInfoIds.get(i));
                    }
                }
            }


            Set set = new HashSet();
//            for (Info info:kwInformationList) {
//                kwInfoIds.add(info.getInfoId());
//            }
//            for (Info info:typeInformationList) {
//                tyInfoIds.add(info.getInfoId());
//            }

            for (Long z : kwInfoIds){
                set.add(z);
            }

            for(Long z : tyInfoIds){
                set.add(z);
            }
            ArrayList<Long> l3 = new ArrayList<Long>(set);
            System.out.println("<>" + l3.size());

            l3.removeAll(mergeInfoIds);
            System.out.println("<>" + mergeInfoIds.size());
            System.out.println("<>" + l3.size());

            mergeInfoIds.addAll(l3);
            System.out.println("<>" + mergeInfoIds);
            System.out.println("<>" + mergeInfoIds.size());
            mergeInfoIds.removeAll(infoIds);
            System.out.println("<>" + infoIds);
            System.out.println("<>" + infoIds.size());

            System.out.println("<>" + mergeInfoIds.size());

            List<Info> afterMergeInfoList = new ArrayList<>();

            for (Long infoId:mergeInfoIds) {
                Info info = infoService.getInfoByInfoIdForImage(infoId);

                afterMergeInfoList.add(info);
            }

            //最终新闻列表
//            mergeInforList.addAll(afterMergeInfoList);
//            mergeInforList.addAll(onlyTypeInformationList);

            //日志去重
//            for (int i=0;i<infoIds.size();i++) {
//                for (int j=0;j<mergeInforList.size();j++) {
//                    if (mergeInforList.get(i).getInfoId() != infoIds.get(j)){
//                        mergeInforList.remove(i);
//                    }
//                }
//            }
//
//            for (Info info : mergeInforList) {
//                InfoImage image = infoImageMapper.getInfoImageByInfoId(info.getInfoId());
//                info.setInfoImage(image);
//            }

            return afterMergeInfoList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Info> pushInfoByTypeId(Integer typeId) throws Exception {
        return null;
    }

    /**
     * 获取当前最新发布的 该类型 的新闻
     * @param typId
     * @return
     */
    public List<Info> InfoAnalyz(Integer typId) {

        List<TypeRelation> wantTypeList =  new ArrayList<>();
        List<Info> wantInfoList = new ArrayList<>();
        Info info = new Info();
        try {
            //获得新闻群
//            wantTypeList = typeRelationMapper.getInfoBytTypeId(typId);

            for (TypeRelation typeRelation:wantTypeList) {
                info = infoService.getInfoByInfoIdForImage(typeRelation.getInfoId());
                wantInfoList.add(info);
            }
            return wantInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
