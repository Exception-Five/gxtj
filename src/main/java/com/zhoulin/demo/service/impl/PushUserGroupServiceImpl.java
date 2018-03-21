package com.zhoulin.demo.service.impl;

import com.zhoulin.demo.bean.Info;
import com.zhoulin.demo.bean.TypeRelation;
import com.zhoulin.demo.bean.UserInfo;
import com.zhoulin.demo.mapper.TypeRelationMapper;
import com.zhoulin.demo.service.InfoService;
import com.zhoulin.demo.service.PushUserGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class PushUserGroupServiceImpl implements PushUserGroupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private TypeRelationMapper typeRelationMapper;

    @Autowired
    private InfoService infoService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 检测各个类型新闻是否有增加
     * @return 检测到更新的新闻
     */
    @Override
    public List<Integer> pushUserGroupByInfoCreate() {

        List<Integer> typeList = new ArrayList<>();

        List<TypeRelation> typeRelations = new ArrayList<>();

        Integer size[] = new Integer[10];

        try {
            ValueOperations<String, Integer> operations = redisTemplate.opsForValue();
            for (int i=1;i<10;i++){
                String key = "size_" + i;
                boolean hasKey = redisTemplate.hasKey(key);
                size[i] = typeRelationMapper.getCountByTypeId(i);
                if (hasKey) {
                    if (size[i].equals(redisTemplate.opsForValue())){
                        LOGGER.info("该类型新闻没有更新");
                    }else {
                        redisTemplate.delete(key);
                        operations.set(key, size[i], 6, TimeUnit.HOURS);
                        typeList.add(i);
                    }
                }
                operations.set(key, size[i], 6, TimeUnit.HOURS);
                typeList.add(i);
            }
            return typeList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
