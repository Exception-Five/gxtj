package com.zhoulin.demo.service;

import com.zhoulin.demo.bean.LogInfo;

import java.util.List;

public interface LogInfoService {

    public List<LogInfo> getLogInfoByUserId(Integer userId) throws Exception;

    public LogInfo getLogInfoByLogId(Integer logId) throws Exception;

    public LogInfo getLogInfoByInfoId(Integer infoId) throws Exception;

    public Integer updateLogInfo(LogInfo logInfo) throws Exception;

    public Integer deleteLogInfoById(Integer logId) throws Exception;

    public Integer addLogInfo(LogInfo logInfo) throws Exception;

}
