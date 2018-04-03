package com.zhoulin.demo.bean;

import java.io.Serializable;

/**
 * 用户模型
 */
public class UserMod implements Serializable{

    //模型id
    private Integer modId;

    //用户id
    private Integer userId;

    //娱乐
    private int entertainment;

    //法律
    private int law;

    //经济
    private int business;

    //科技
    private int technology;

    //互联网
    private int internet;

    //政治
    private int politics;

    //生活
    private int life;

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(int entertainment) {
        this.entertainment = entertainment;
    }

    public int getPolitics() {
        return politics;
    }

    public void setPolitics(int politics) {
        this.politics = politics;
    }

    public int getBusiness() {
        return business;
    }

    public void setBusiness(int business) {
        this.business = business;
    }

    public int getTechnology() {
        return technology;
    }

    public void setTechnology(int technology) {
        this.technology = technology;
    }

    public int getLaw() {
        return law;
    }

    public void setLaw(int law) {
        this.law = law;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

}
