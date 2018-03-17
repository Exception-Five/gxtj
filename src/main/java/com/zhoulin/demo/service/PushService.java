package com.zhoulin.demo.service;

import com.zhoulin.demo.bean.Information;
import com.zhoulin.demo.bean.UserInfo;

import java.util.List;

public interface PushService {

    public List<Information> pushInformation(long id) throws Exception;

    public List<UserInfo> pushInfoForRecessiveGroup(Integer typeId) throws Exception;

    public List<Information> logAnalyzForPush(Integer userId) throws Exception;

}
