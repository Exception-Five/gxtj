package com.zhoulin.demo.bean;

import java.io.Serializable;

public class LogInfoDTO implements Serializable{

    private LogInfo logInfo;

    private TypeRelation typeRelation;

    private long timeDifference;

    public LogInfoDTO() {
    }

    public LogInfoDTO(LogInfo logInfo, TypeRelation typeRelation) {
        this.logInfo = logInfo;
        this.typeRelation = typeRelation;
    }

    public LogInfoDTO(LogInfo logInfo, TypeRelation typeRelation, long timeDifference) {
        this.logInfo = logInfo;
        this.typeRelation = typeRelation;
        this.timeDifference = timeDifference;
    }

    public long getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(long timeDifference) {
        this.timeDifference = timeDifference;
    }

    public LogInfo getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(LogInfo logInfo) {
        this.logInfo = logInfo;
    }

    public TypeRelation getTypeRelation() {
        return typeRelation;
    }

    public void setTypeRelation(TypeRelation typeRelation) {
        this.typeRelation = typeRelation;
    }
}
