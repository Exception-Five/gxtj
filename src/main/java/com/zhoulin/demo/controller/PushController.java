package com.zhoulin.demo.controller;

import com.zhoulin.demo.bean.Information;
import com.zhoulin.demo.bean.Message;
import com.zhoulin.demo.bean.UserInfo;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.PushService;
import com.zhoulin.demo.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/push")
public class PushController {

    @Autowired
    private PushService pushService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private InformationService informationService;

    /**
     * 推送功能
     * @param id 资讯id
     * @return
     */
    @RequestMapping(value = "/api/push/", method = RequestMethod.POST)
    @ResponseBody
    public Message pushInfo(@RequestParam(value = "id") long id){

        List<Information> informationList = new ArrayList<>();

        long pushId = 0;

        try {

            //获得用户感兴趣信息（优质）
            informationList = pushService.pushInformation(id);

            if (informationList.size() > 0) {
                return new Message(Message.SUCCESS, "推送用户感兴趣资讯>>>>>成功", informationList);
            }

            return new Message(Message.FAILURE, "推送用户感兴趣资讯>>>>>失败", "未找到感兴趣信息");

        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR, "推送用户感兴趣资讯>>>>>异常", "未知错误！");
        }

    }

    /**
     * 根据浏览日志抓取
     * 登录即可推送
     * @return
     */
    @RequestMapping(value = "/pushUserByLogInfo", method = RequestMethod.POST)
    @ResponseBody
    public Message pushUserByLogInfo(){

        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getDetails();
        List<Information> informationList = new ArrayList<>();
        try {
            informationList = pushService.logAnalyzForPush(userInfo.getUserId());

            return new Message(Message.SUCCESS, "日志兴趣点抓取成功>>>>>推送>>>>>成功", informationList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR, "日志兴趣点抓取成功>>>>>推送>>>>>失败", e);
        }
    }

}
