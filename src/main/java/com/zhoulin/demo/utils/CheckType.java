package com.zhoulin.demo.utils;

import com.zhoulin.demo.bean.UserMod;
import org.springframework.stereotype.Component;

/**
 * 用户模型---资讯 建立
 */
@Component
public class CheckType {

    public UserMod  checkInfoType(UserMod userMod, String type){

        if (type == "娱乐"){
            userMod.setEntertainment(userMod.getEntertainment() + 1);
        }else if (type == "法律"){
            userMod.setPolitics(userMod.getPolitics() + 1);
        }else if (type == "体育"){
            userMod.setSports(userMod.getSports() + 1);
        }else if (type == "财经"){
            userMod.setBusiness(userMod.getBusiness() + 1);
        }else if (type == "科技"){
            userMod.setTechnology(userMod.getTechnology() + 1);
        }else if (type == "互联网"){
            userMod.setCar(userMod.getCar() + 1);
        }else if (type == "美食"){
            userMod.setMilitary(userMod.getMilitary() + 1);
        }else if (type == "国际"){
            userMod.setTravel(userMod.getTravel() + 1);
        }else if (type == "生活"){
            userMod.setLife(userMod.getLife() + 1);
        }else if (type == "其他") {
            userMod.setOther(userMod.getOther() + 1);
        }

        return userMod;
    }

}
