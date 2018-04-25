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

    @Autowired
    private UserReadService userReadService;

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
     * 根据 仔细阅读 && 历史阅读 分析 用户兴趣点 进行推送
     * 若是 用户仔细阅读记录 为空 则
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<Info> logAnalyzForPush(Integer userId){
        List<Long> kwInfoIds = new ArrayList<>();
        List<Long> mergeInfoIds = new ArrayList<>();
        List<Long> tyInfoIds = new ArrayList<>();

        //历史阅读记录
        List<LogInfo> logInfos = new ArrayList<>();

        //仔细阅读记录
        List<UserRead> userReadList = new ArrayList<>();
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
            userReadList = userReadService.getUserReadByUserId(userId);

            if(userReadList.size()>0){
                for (UserRead userRead: userReadList) {
                    //查找对应新闻的详细信息
                    typeRelation = typeRelationMapper.getInfoByTRId(userRead.getInfoId());
                    Info info = infoService.getInfoByInfoId(userRead.getInfoId());
                    keywords = keywords + info.getKeyword();
                    types.add(typeRelation.getTypeId());
                    infoIds.add(userRead.getInfoId());
                    logger.info("调用 >>>> 仔细阅读记录");
                }
            }else {
                for (LogInfo logInfo: logInfos) {
                    //查找对应新闻的详细信息
                    typeRelation = typeRelationMapper.getInfoByTRId(logInfo.getInfoId());
                    Info info = infoService.getInfoByInfoId(logInfo.getInfoId());
                    keywords = keywords + info.getKeyword();
                    types.add(typeRelation.getTypeId());
                    infoIds.add(logInfo.getInfoId());
                    logger.info("调用 >>>> 历史阅读记录");
                }
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

            kwInfoIds = multiResult.getResult();

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

            for (Long z : kwInfoIds){
                set.add(z);
            }

            for(Long z : tyInfoIds){
                set.add(z);
            }
            ArrayList<Long> l3 = new ArrayList<Long>(set);

            l3.removeAll(mergeInfoIds);

            mergeInfoIds.addAll(l3);

            mergeInfoIds.removeAll(infoIds);

            List<Info> afterMergeInfoList = new ArrayList<>();

            for (Long infoId:mergeInfoIds) {
                Info info = infoService.getInfoByInfoIdForImage(infoId);

                afterMergeInfoList.add(info);
            }

            return afterMergeInfoList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据类型推送
     * @param typeId
     * @return
     * @throws Exception
     */
    @Override
    public List<Info> pushInfoByTypeId(Integer typeId) {

        List<TypeRelation> typeRelations = new ArrayList<>();

        List<Info> infoList = new ArrayList<>();

        try {
            typeRelations = typeRelationMapper.getInfoByTypeId(typeId);

            for (TypeRelation typeRelation : typeRelations) {
                Info info = infoService.getInfoByInfoId(typeRelation.getInfoId());
                infoList.add(info);
            }
            return infoList;
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
