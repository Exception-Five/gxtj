package com.zhoulin.demo.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻类型划分
 */
public class TypeRelation implements Serializable{

    private Integer relateId;

    private long infoId;

    private int typeId;

    private String onlyText;

    private Date publishDate;

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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
