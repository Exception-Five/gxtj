package com.zhoulin.demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.zhoulin.demo.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 设置RedisToken有效时间
 * 用作邮箱激活码
 */
@Component
public class RedisTokenManager {

    @Autowired
    private RedisTemplate redisTemplate;

//    private  final static String signUpPrefix = "UserInfoSignUp";

    public String getTokenOfSignUp(UserInfo userInfo){
        String token = UUID.randomUUID().toString();
        String value = JSONObject.toJSONString(userInfo);
        ValueOperations<String, UserInfo> operations = redisTemplate.opsForValue();
        operations.set(token, userInfo, 12, TimeUnit.HOURS);
//        redisTemplate.opsForValue().set(token, value);
//        redisTemplate.expire(token, 12, TimeUnit.HOURS);
//        redisTemplate.opsForValue().set(token, value, 24, TimeUnit.HOURS);
        return token;
    }
}
