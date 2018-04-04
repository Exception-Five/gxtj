package com.zhoulin.demo.service.impl;

import com.zhoulin.demo.bean.LogInfo;
import com.zhoulin.demo.bean.TypeRelation;
import com.zhoulin.demo.mapper.TypeRelationMapper;
import com.zhoulin.demo.service.HumanListenerService;
import com.zhoulin.demo.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HumanListenerServiceImpl implements HumanListenerService {

    @Autowired
    private TypeRelationMapper typeRelationMapper;

    @Autowired
    private LogInfoService logInfoService;

    @Override
    @Scheduled(fixedRate = 30000)
    public List<Integer> userReadTime(int userId) {

        List<Integer> typeList = new ArrayList<>();

//        List<Integer>

        try {
            List<LogInfo> logInfos = logInfoService.getLogInfoByUserId(userId);
            for (LogInfo logInfo:logInfos) {
                TypeRelation typeRelation = typeRelationMapper.getInfoByTRId(logInfo.getInfoId());
                typeList.add(typeRelation.getTypeId());
            }

            //去重
            HashSet h = new HashSet(typeList);
            typeList.clear();
            typeList.addAll(h);

//            foreahc

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
