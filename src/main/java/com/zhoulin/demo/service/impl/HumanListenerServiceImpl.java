package com.zhoulin.demo.service.impl;

import com.zhoulin.demo.bean.LogInfo;
import com.zhoulin.demo.bean.LogInfoDTO;
import com.zhoulin.demo.bean.TypeDTO;
import com.zhoulin.demo.bean.TypeRelation;
import com.zhoulin.demo.mapper.TypeRelationMapper;
import com.zhoulin.demo.service.HumanListenerService;
import com.zhoulin.demo.service.LogInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HumanListenerServiceImpl implements HumanListenerService {

    private static final Logger logger = LoggerFactory.getLogger(HumanListenerServiceImpl.class);

    @Autowired
    private TypeRelationMapper typeRelationMapper;

    @Autowired
    private LogInfoService logInfoService;

    @Override
    public List<LogInfoDTO> userReadTime(int userId) {
        List<LogInfoDTO> logInfoDTOS = new ArrayList<>();
        List<TypeDTO> typeDTOS = new ArrayList<>();
        List<Integer> typeList = new ArrayList<>();
        List<Integer> allList = new ArrayList<>();
        Map<Integer,List> map = new HashMap<Integer,List>();
//        List<Integer>

        // 从缓存中获取列表
//        String key = "" + userId;
//        ValueOperations<String, List<LogInfoDTO>> operations = redisTemplate.opsForValue();

        try {
            List<LogInfo> logInfos = logInfoService.getLogInfoByUserId(userId);
            for (LogInfo logInfo:logInfos) {
                //得到阅读时间
                long timeDiff = logInfo.getLookTime().getTime() - logInfo.getEndTime().getTime();

                TypeRelation typeRelation = typeRelationMapper.getInfoByTRId(logInfo.getInfoId());

                //DTO封装
                LogInfoDTO logInfoDTO = new LogInfoDTO(logInfo, typeRelation, timeDiff);
                logInfoDTOS.add(logInfoDTO);
            }
//            //清空
//            redisTemplate.delete(key);
//            //重新填充
//            operations.set(key, logInfoDTOS, 1, TimeUnit.HOURS);
            //去重
            HashSet h = new HashSet(typeList);
            typeList.clear();
            typeList.addAll(h);

            //动态生成list
//            for (Integer typeId:typeList) {
//                List list = new ArrayList();
//                TypeDTO typeDTO = new TypeDTO();
//                typeDTO.setTypeId(typeId);
//                //阅读时间列表
//                List<Integer> integerList = new ArrayList<>();
//                for (Integer allTypeId:allList){
//                    if (typeId.equals(allTypeId)){
//                        integerList.add(logInfoDTO.ge)
//                    }
//                }
//                map.put(typeId, list);
//            }
//            for (LogInfoDTO logInfoDTO:logInfoDTOS) {
//                for (:
//                     ) {
//
//                }
//            }

            return logInfoDTOS;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
