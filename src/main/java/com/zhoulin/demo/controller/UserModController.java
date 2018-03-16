package com.zhoulin.demo.controller;

import com.zhoulin.demo.bean.Message;
import com.zhoulin.demo.bean.UserInfo;
import com.zhoulin.demo.bean.UserMod;
import com.zhoulin.demo.service.UserModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userMod")
public class UserModController {

    @Autowired
    private UserModService userModService;

    @RequestMapping(value = "/getUserMod", method = RequestMethod.GET)
    @ResponseBody
    public Message getUserModById(){
        //token中取出userInfo
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getDetails();

        UserMod userMod = new UserMod();

        try {
            userMod = userModService.getUserModByUserId(userInfo.getUserId());
            if (userMod != null){
                return new Message(Message.SUCCESS, "获取对应用户模型>>>成功", userMod);
            }
            return new Message(Message.FAILURE, "获取对应用户模型>>>失败", "请核对数据源");
        } catch (Exception e) {
            return new Message(Message.ERROR, "获取对应用户模型>>>异常", e);
        }
    }

    @RequestMapping(value = "/updateUserMod", method = RequestMethod.POST)
    @ResponseBody
    public Message updateUserMod(@RequestBody UserMod userMod){
        //token中取出userInfo
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getDetails();

        Integer upStatus = 0;
        userMod.setUserId(userInfo.getUserId());
        try {
            upStatus = userModService.updateUserMod(userMod);
            if (upStatus == 1){
                return new Message(Message.SUCCESS, "更新对应用户模型>>>成功", upStatus);
            }else if(upStatus == 0){
                return new Message(Message.FAILURE, "修改对应用户模型>>>失败", "请核对数据源");
            }
            return new Message(Message.ERROR, "获取对应用户模型>>>异常", upStatus);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR, "获取对应用户模型>>>异常", e);
        }
    }

    @RequestMapping(value = "/addUserMod", method = RequestMethod.POST)
    @ResponseBody
    public Message addUserMod(@RequestBody UserMod userMod){
        //token中取出userInfo
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getDetails();

        Integer addStatus = 0;
        userMod.setUserId(userInfo.getUserId());
        try {
            addStatus = userModService.addUserModForRegister(userMod);
            if (addStatus == 1){
                return new Message(Message.SUCCESS, "新建对应用户模型>>>成功", addStatus);
            }else if(addStatus == 0){
                return new Message(Message.FAILURE, "新建对应用户模型>>>失败", "请核对数据源");
            }
            return new Message(Message.ERROR, "新建对应用户模型>>>异常", addStatus);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR, "新建对应用户模型>>>异常", e);
        }
    }

}
