package com.zhoulin.demo.service;

import com.zhoulin.demo.bean.UserInfo;

import java.util.List;

public interface PushService {

    public long pushInformation(long id) throws Exception;

    public List<UserInfo> pushInfoForRecessiveGroup(Integer typeId) throws Exception;

}
