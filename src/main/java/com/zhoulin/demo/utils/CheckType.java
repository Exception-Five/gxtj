package com.zhoulin.demo.utils;

import com.zhoulin.demo.bean.UserMod;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 用户模型---资讯 建立
 */
@Component
public class CheckType {

    public UserMod checkInfoType(UserMod userMod, Integer typeId){

        if (typeId == 1){
            userMod.setEntertainment(userMod.getEntertainment() + 1);
        }else if (typeId == 2){
            userMod.setLaw(userMod.getLaw() + 1);
        }else if (typeId == 3){
            userMod.setBusiness(userMod.getBusiness() + 1);
        }else if (typeId == 4){
            userMod.setTechnology(userMod.getTechnology() + 1);
        }else if (typeId == 5){
            userMod.setInternet(userMod.getInternet() + 1);
        }else if (typeId == 6){
            userMod.setPolitics(userMod.getPolitics() + 1);
        }else if (typeId == 7){
            userMod.setLife(userMod.getLife() + 1);
        }

        return userMod;
    }

    public List<Relation> findMostType(List<Integer> typeList){

        Integer maxNum = 0;

        List<Integer> list = new ArrayList();

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        List<Relation> relationList = new ArrayList<>();

        for (Integer typeId : typeList) {
            if (hashMap.get(typeId) != null) {
                Integer value = hashMap.get(typeId);
                hashMap.put(typeId, value+1);
                System.out.println("the element:  "+typeId+"  is repeat");
            } else {
                hashMap.put(typeId, 1);
            }
        }
        for (int i=1;i<8;i++) {
            if (hashMap.get(i)==null){
                hashMap.put(i, 0);
            }
            list.add(hashMap.get(i));
        }
        maxNum = Collections.max(list);
        System.out.println(maxNum);
        for (int i=0;i<7;i++) {
            if (list.get(i).equals(maxNum)){
                Relation relation = new Relation();
                relation.setId(i+1);
                relation.setContent(maxNum);
                relationList.add(relation);
                list.set(i,-1);
            }
        }
        maxNum = Collections.max(list);
        System.out.println(maxNum);
        for (int i=0;i<7;i++) {
            if (list.get(i).equals(maxNum)){
                Relation relation = new Relation();
                relation.setId(i+1);
                relation.setContent(maxNum);
                relationList.add(relation);
                list.set(i,-2);
            }
        }
        maxNum = Collections.max(list);
        System.out.println(maxNum);
        for (int i=0;i<7;i++) {
            if (list.get(i).equals(maxNum)){
                Relation relation = new Relation();
                relation.setId(i+1);
                relation.setContent(maxNum);
                relationList.add(relation);
                list.set(i,-3);
            }
        }

        return relationList;
    }


    public int getTypeIdByTypeName(String typeName){

        int typeId = 0;

        if (typeName.equals("互联网")){
            typeId = 1;
        } else if (typeName.equals("体育")){
            typeId = 2;
        } else if (typeName.equals("健康")){
            typeId = 3;
        } else if (typeName.equals("军事")){
            typeId = 4;
        } else if (typeName.equals("教育")){
            typeId = 5;
        } else if (typeName.equals("文化")){
            typeId = 6;
        } else if (typeName.equals("旅游")){
            typeId = 7;
        } else if (typeName.equals("汽车")){
            typeId = 8;
        } else if (typeName.equals("生活")){
            typeId = 9;
        } else if (typeName.equals("财经")){
            typeId = 10;
        }
        return typeId;
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        list.add(2);
//        list.add(4);
//        list.add(7);
//        list.add(9);
//
        CheckType checkType = new CheckType();
//        checkType.findMostType(list);
        System.out.println(checkType.getTypeIdByTypeName("生活"));
    }

}
