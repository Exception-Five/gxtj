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
            userMod.setPolitics(userMod.getPolitics() + 1);
        }else if (typeId == 3){
            userMod.setSports(userMod.getSports() + 1);
        }else if (typeId == 4){
            userMod.setBusiness(userMod.getBusiness() + 1);
        }else if (typeId == 5){
            userMod.setTechnology(userMod.getTechnology() + 1);
        }else if (typeId == 6){
            userMod.setCar(userMod.getCar() + 1);
        }else if (typeId == 7){
            userMod.setMilitary(userMod.getMilitary() + 1);
        }else if (typeId == 8){
            userMod.setTravel(userMod.getTravel() + 1);
        }else if (typeId == 9){
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
        for (int i=1;i<10;i++) {
            if (hashMap.get(i)==null){
                hashMap.put(i, 0);
            }
            list.add(hashMap.get(i));
        }
        maxNum = Collections.max(list);
        System.out.println(maxNum);
        for (int i=0;i<9;i++) {
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
        for (int i=0;i<9;i++) {
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
        for (int i=0;i<9;i++) {
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

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(7);
        list.add(9);

        CheckType checkType = new CheckType();
        checkType.findMostType(list);
    }

}
