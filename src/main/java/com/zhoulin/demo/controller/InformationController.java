package com.zhoulin.demo.controller;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 14:02 2018/3/7
 */

import com.zhoulin.demo.bean.*;
import com.zhoulin.demo.mapper.TypeRelationMapper;
import com.zhoulin.demo.mapper.UserModMapper;
import com.zhoulin.demo.service.InfoService;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.impl.UserModService;
import com.zhoulin.demo.utils.CheckType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/public/information")
public class InformationController {
    @Autowired
    private InformationService informationService;

    @Autowired
    private InfoService infoService;

    @Autowired
    private UserModService userModService;

    @Autowired
    private TypeRelationMapper typeRelationMapper;

    @Autowired
    private CheckType checkType;

    /**
     * 根据【资讯编号】获取对应资讯信息
     * @param infoId 资讯编号
     * @return
     */
    @RequestMapping(value = "/getInfoByInfoId/{infoId}", method = RequestMethod.GET)
    @ResponseBody
    public Message getUserInfoById(@PathVariable(value = "infoId") Integer infoId){

//        Information information = new Information();

        Info info = new Info();

        TypeRelation typeRelation = new TypeRelation();

        UserMod userMod = new UserMod();

        try {
            info = infoService.getInfoByInfoId(infoId);

            //如果用户登录后查看新闻信息
            if (SecurityContextHolder.getContext().getAuthentication() != null){

                UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getDetails();

                Integer userId = userInfo.getUserId();

                userMod = userModService.getUserModByUserId(userId);

                typeRelation = typeRelationMapper.getInfoByTRId(infoId);

//                userMod = checkType.checkInfoType(userMod, typeRelation.getType());

                //用户模型修改
                userModService.updateUserMod(userMod);

            }

            if (info != null){
                return new Message(Message.SUCCESS,"获取资讯--成功",info);
            } else {
                return new Message(Message.FAILURE,"获取资讯--失败",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取资讯异常！",e);
        }
    }

    /**
     * 根据资讯发布时间获取资讯（ 20 条）
     * @return
     */
    @RequestMapping(value = "/findInfoByDate/{page}",method = RequestMethod.GET)
    @ResponseBody
    public Message findInfoByDate(@PathVariable(value = "page") int page){
//        List<Information> dateInfoList = new ArrayList<>();
        List<Info> dateInfoList = new ArrayList<>();
        try {
            dateInfoList = infoService.findInfoByDate(page);
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
