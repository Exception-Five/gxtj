package com.zhoulin.demo.bean;

import java.io.Serializable;

/**
 * 新闻类型划分
 */
public class TypeRelation implements Serializable{

    private Integer relateId;

    private long infoId;

    private String type;

    private String onlyText;

    public String getOnlyText() {
        return onlyText;
    }

    public void setOnlyText(String onlyText) {
        this.onlyText = onlyText;
    }

    public Integer getRelateId() {
        return relateId;
    }

    public void setRelateId(Integer relateId) {
        this.relateId = relateId;
    }

    public long getInfoId() {
        return infoId;
    }

    public void setInfoId(long infoId) {
        this.infoId = infoId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
