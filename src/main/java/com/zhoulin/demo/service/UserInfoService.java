package com.zhoulin.demo.service;

import com.zhoulin.demo.bean.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> getAllUserInfo() throws Exception;

    UserInfo getUserInfoById(Integer userId) throws Exception;

    Integer addUserInfo(UserInfo userInfo) throws Exception;

    Integer updateUserInfo(UserInfo userInfo) throws Exception;

    Integer deleteUserInfoById(Integer userId) throws Exception;

//    Integer UserInfoSignUp(UserInfo userInfo) throws Exception;


}
