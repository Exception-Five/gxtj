package com.zhoulin.demo.utils;

import com.zhoulin.demo.bean.UserMod;
import com.zhoulin.demo.service.PushUserGroupService;
import com.zhoulin.demo.service.UserModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * 用户隐性分组模型
 */
@Component
public class ReckonUserGroup {

    @Autowired
    private UserModService userModService;

    @Autowired
    private PushUserGroupService pushUserGroupService;

    /**
     * 用户兴趣面积分析
     * @param userId
     * @return
     */
    public List<Integer> reckonTypeArea(Integer userId){

        UserMod userMod = new UserMod();
        List<Integer> mods = new ArrayList<>();
        List<Integer> throwList = new ArrayList<>();
        List<Integer> groups = new ArrayList<>();
        Integer sumNum = 0;
        try {
            userMod = userModService.getUserModByUserId(userId);
            mods.add(userMod.getEntertainment());
            mods.add(userMod.getPolitics());
            mods.add(userMod.getSports());
            mods.add(userMod.getBusiness());
            mods.add(userMod.getTechnology());
            mods.add(userMod.getCar());
            mods.add(userMod.getMilitary());
            mods.add(userMod.getTravel());
            mods.add(userMod.getLife());

            for (Integer mod : mods){
                sumNum = sumNum + mod;
            }

            float rate = 0;

            for (int i=0;i<mods.size();i++) {
                if ((float)(mods.get(i)/sumNum) >= 0.15){
                    groups.add(i+1);
                }
            }
            //用户组 即新闻类型
            return groups;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据变化的typeId 来查找符合的用户组
     * typeList 用户组 即新闻类型
     */
    public List<Integer> findUserGroupByUpTypeList(List<Integer> groups, List<Integer> typeList){

        List<Integer> mergeList = new ArrayList<>();

        for (Integer group : groups){
            if (typeList.contains(group)){
                mergeList.add(group);
            }
        }

        return mergeList;

    }

}
