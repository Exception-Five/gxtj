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

import java.util.ArrayList;
import java.util.List;

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

            ServiceMultiResult<String> multiResult = modService.queryMuti(infoSearch);

            for (String rs:multiResult.getResult()) {
                Info infor = objectMapper.readValue(rs, Info.class);
                logger.info("最终关键词为 :  " + information.toString());
                informationList.add(infor);
            }

            for (Info info : informationList) {
                InfoImage image = infoImageMapper.getInfoImageByInfoId(info.getInfoId());
                info.setInfoImage(image);
            }

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
        List<Info> typeInformationList = new ArrayList<>();
        List<Info> kwInformationList = new ArrayList<>();
        List<Info> mergeInforList = new ArrayList<>();
        List<LogInfo> logInfos = new ArrayList<>();
        List<TypeRelation> typeRelations = new ArrayList<>();
        TypeRelation typeRelation = new TypeRelation();
        InfoSearch infoSearch = new InfoSearch();
        List<Integer> infoIds = new ArrayList<>();
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
                typeInformationList.add(infoService.getInfoByInfoId(type.getInfoId()));
            }

            //根据关键词
            infoSearch.setMutiContent(keywordsString);
            //全局抓取
            ServiceMultiResult<String> multiResult = modService.queryMuti(infoSearch);

            for (String rs:multiResult.getResult()) {
                Info information = objectMapper.readValue(rs, Info.class);
//                logger.info("最终关键词为 :  " + information.toString());
                //通过关键词找到的新闻列表
                kwInformationList.add(information);
            }

            //获取交叉内容
            for (int i=0;i<typeInformationList.size();i++) {
                for (int j=0;j<kwInformationList.size();j++) {
                    if (typeInformationList.get(i).getId().equals(kwInformationList.get(j).getId())){
                        logger.info("匹配到交叉内容 ！！！ " );
                        mergeInforList.add(typeInformationList.get(i));
                        //去掉重复内容
                        typeInformationList.remove(i);
                        kwInformationList.remove(j);
                    }
                }
//                if (kwInformationList.contains(typeInformationList.get(i))){
//                    logger.info("匹配到交叉内容 ！！！ " );
//                    mergeInforList.add(typeInformationList.get(i));
//                    typeInformationList.remove(i);
//                }
            }

            //去掉重复内容
//            for (int i=0;i<kwInformationList.size();i++) {
//                if (mergeInforList.contains(kwInformationList.get(i))){
//                    logger.info("匹配到交叉内容 ！！！ " );
//                    kwInformationList.remove(i);
//                }
//            }

            //最终新闻列表
            mergeInforList.addAll(kwInformationList);
            mergeInforList.addAll(typeInformationList);

            for (int i=0;i<mergeInforList.size();i++) {
                for (int j=0;j<infoIds.size();j++) {
                    if (mergeInforList.get(i).getId().equals(infoIds.get(j))){
                        mergeInforList.remove(i);
                    }
                }
            }

            for (Info info : mergeInforList) {
                InfoImage image = infoImageMapper.getInfoImageByInfoId(info.getInfoId());
                info.setInfoImage(image);
            }

            return mergeInforList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

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
