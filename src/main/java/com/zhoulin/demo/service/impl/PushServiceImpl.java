package com.zhoulin.demo.service.impl;

import com.zhoulin.demo.bean.*;
import com.zhoulin.demo.bean.form.InfoSearch;
import com.zhoulin.demo.bean.form.ServiceMultiResult;
import com.zhoulin.demo.mapper.RecessiveGroupMapper;
import com.zhoulin.demo.mapper.TypeRelationMapper;
import com.zhoulin.demo.service.InfoService;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.ModService;
import com.zhoulin.demo.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 推送功能模块
 */
@Component
public class PushServiceImpl implements PushService {

    @Autowired
    private ModService modService;

    @Autowired
    private RecessiveGroupMapper recessiveGroupMapper;

    @Autowired
    private InformationService informationService;

    @Autowired
    private TypeRelationMapper typeRelationMapper;

    @Autowired
    private InfoService infoService;

    @Override
    public long pushInformation(long id) {

        boolean isSuccess = false;

        InfoSearch infoSearch = new InfoSearch();

        String keywords = "";

        List<Information> informationList = new ArrayList<>();

        try {
            isSuccess = modService.modAnalyse(id);
            if (isSuccess == true){
                Information information = informationService.getInfoByInfoId(id);

                keywords = information.getKeyword();

                infoSearch.setMutiContent(keywords);

                ServiceMultiResult<Long> multiResult = modService.queryMuti(infoSearch);

                return multiResult.getResult().get(1);
            }
            return -1L;
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
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
//        return null;
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
            wantTypeList = typeRelationMapper.getInfoBytTypeId(typId);

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
