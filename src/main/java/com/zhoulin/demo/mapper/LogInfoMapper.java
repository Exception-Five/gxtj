package com.zhoulin.demo.mapper;

import com.zhoulin.demo.bean.LogInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogInfoMapper {

    public List<LogInfo> getLogInfoByUserId(Integer userId) throws Exception;

    public LogInfo getLogInfoByLogId(Integer logId) throws Exception;

    public Integer updateLogInfo(LogInfo logInfo) throws Exception;

    public Integer deleteLogInfoById(Integer logId) throws Exception;

    public Integer addLogInfo(LogInfo logInfo) throws Exception;

}
