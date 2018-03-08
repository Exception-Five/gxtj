package com.zhoulin.demo.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户浏览日志
 */
public class LogInfo implements Serializable{

    private Integer logId;

    private Integer userId;

    private Integer infoId;

    private Date lookTime;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Date getLookTime() {
        return lookTime;
    }

    public void setLookTime(Date lookTime) {
        this.lookTime = lookTime;
    }

    @Override
    public String toString() {
        return "LogInfo{" +
                "logId=" + logId +
                ", userId=" + userId +
                ", infoId=" + infoId +
                ", lookTime='" + lookTime + '\'' +
                '}';
    }
}
