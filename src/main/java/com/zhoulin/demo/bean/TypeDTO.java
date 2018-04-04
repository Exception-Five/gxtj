package com.zhoulin.demo.bean;

import java.io.Serializable;
import java.util.List;

public class TypeDTO implements Serializable {

    private int typeId;

    private List<Integer> typeTime;

    public TypeDTO() {
    }

    public TypeDTO(int typeId, List<Integer> typeTime) {
        this.typeId = typeId;
        this.typeTime = typeTime;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public List<Integer> getTypeTime() {
        return typeTime;
    }

    public void setTypeTime(List<Integer> typeTime) {
        this.typeTime = typeTime;
    }

    @Override
    public String toString() {
        return "TypeDTO{" +
                "typeId=" + typeId +
                ", typeTime=" + typeTime +
                '}';
    }
}
