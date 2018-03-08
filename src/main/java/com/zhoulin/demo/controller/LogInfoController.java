package com.zhoulin.demo.controller;

import com.zhoulin.demo.bean.LogInfo;
import com.zhoulin.demo.bean.Message;
import com.zhoulin.demo.bean.UserInfo;
import com.zhoulin.demo.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/logInfo")
public class LogInfoController {

    @Autowired
    private LogInfoService logInfoService;

    /**
     * 获取用户对应浏览信息
     * @return
     */
    @RequestMapping(value = "/getLogInfos", method = RequestMethod.GET)
    @ResponseBody
    public Message getLogInfos(){

        List<LogInfo> infoList = new ArrayList<>();

        //token中取出用户id
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getDetails();

        int userId = userInfo.getUserId();

        try {
            infoList = logInfoService.getLogInfoByUserId(userId);

            return new Message(Message.SUCCESS, "获取用户浏览记录>>>>>成功", infoList);

        } catch (Exception e) {
            return new Message(Message.ERROR, "获取用户浏览记录>>>>>失败", e);
        }

    }

    /**
     * 添加浏览记录
     * @param logInfo
     * @return
     */
    @RequestMapping(value = "/addLogInfo", method = RequestMethod.POST)
    @ResponseBody
    public Message addLogInfo(@RequestBody LogInfo logInfo){

        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getDetails();

        int userId = userInfo.getUserId();

        //创建浏览时间
        Date lookTime = new Date();

        logInfo.setUserId(userId);
        logInfo.setLookTime(lookTime);

        Integer addStatus = 0;
        try {
            addStatus = logInfoService.addLogInfo(logInfo);
            if (addStatus == 1){
                return new Message(Message.SUCCESS,"添加用户浏览记录>>>>>成功",addStatus);
            } else if(addStatus == 0){
                return new Message(Message.FAILURE,"添加用户浏览记录>>>>>失败",addStatus);
            } else {
                return new Message(Message.ERROR,"添加用户浏览记录>>>>>异常",addStatus);
            }
        } catch (Exception e) {
            return new Message(Message.ERROR,"添加用户浏览记录>>>>>异常",e);
        }

    }


}