package com.zhoulin.demo.controller;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 14:02 2018/3/7
 */

import com.zhoulin.demo.bean.Information;
import com.zhoulin.demo.bean.Message;
import com.zhoulin.demo.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/public/information")
public class InformationController {
    @Autowired
    private InformationService informationService;

    /**
     * 根据【资讯编号】获取对应资讯信息
     * @param infoId 资讯编号
     * @return
     */
    @RequestMapping(value = "/getInfoByInfoId/{infoId}", method = RequestMethod.GET)
    @ResponseBody
    public Message getUserInfoById(@PathVariable(value = "infoId") Integer infoId){
        Information information = new Information();
        try {
            information = informationService.getInfoByInfoId(infoId);
            if (information != null){
                return new Message(Message.SUCCESS,"获取资讯--成功",information);
            } else {
                return new Message(Message.FAILURE,"获取资讯--失败",null);
            }
        } catch (Exception e) {
//            e.printStackTrace();
            return new Message(Message.ERROR,"获取资讯异常！",e);
        }
    }

    /**
     * 根据资讯发布时间获取资讯（ 20 条）
     * @return
     */
    @RequestMapping(value = "/findInfoByDate",method = RequestMethod.GET)
    @ResponseBody
    public Message findInfoByDate(){
        List<Information> dateInfoList = new ArrayList<>();
        try {
            dateInfoList = informationService.findInfoByDate();
            if (dateInfoList.size() < 1){
                return new Message(Message.FAILURE,"获取资讯--失败","检查数据源");
            }else {
                return new Message(Message.SUCCESS,"获取资讯--成功",dateInfoList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取资讯异常！",e);
        }
    }

    /**
     * 获取所有资讯信息
     * @return
     */
    @RequestMapping(value = "/findAllInfo",method = RequestMethod.GET)
    @ResponseBody
    public Message findAll(){
        List<Information> infoAllList = new ArrayList<>();
        try {
            infoAllList = informationService.findAll();
            if (infoAllList.size() < 1){
                return new Message(Message.FAILURE,"获取资讯--失败","检查数据源");
            }else {
                return new Message(Message.SUCCESS,"获取资讯--成功",infoAllList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取资讯异常！",e);
        }
    }

}
