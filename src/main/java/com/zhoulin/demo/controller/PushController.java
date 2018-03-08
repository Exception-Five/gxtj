package com.zhoulin.demo.controller;

import com.zhoulin.demo.bean.Information;
import com.zhoulin.demo.bean.Message;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PushController {

    @Autowired
    private PushService pushService;

    @Autowired
    private InformationService informationService;

    /**
     * 推送功能
     * @param id 资讯id
     * @return
     */
    @RequestMapping(value = "/pushInfo", method = RequestMethod.POST)
    @ResponseBody
    public Message pushInfo(@RequestParam(value = "id") long id){

        Information information = new Information();

        long pushId = 0;

        try {
            //获得推送的新闻id
            pushId = pushService.pushInformation(id);

            //获得用户感兴趣信息（优质）
            information = informationService.getInfoByInfoId(pushId);

            if (information != null) {
                return new Message(Message.SUCCESS, "推送用户感兴趣资讯>>>>>成功", information);
            }

            return new Message(Message.SUCCESS, "推送用户感兴趣资讯>>>>>失败", "未找到感兴趣信息");

        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.SUCCESS, "推送用户感兴趣资讯>>>>>异常", "未知错误！");
        }

    }

}
