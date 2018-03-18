package com.zhoulin.demo.controller;

import com.zhoulin.demo.bean.*;
import com.zhoulin.demo.config.security.JwtTokenUtil;
import com.zhoulin.demo.mapper.InfoContentMapper;
import com.zhoulin.demo.mapper.InfoImageMapper;
import com.zhoulin.demo.mapper.TypeRelationMapper;
import com.zhoulin.demo.service.InfoService;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.LogInfoService;
import com.zhoulin.demo.service.UserModService;
import com.zhoulin.demo.utils.CheckType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/public/information")
public class InformationController {

    private final static Logger logger = LoggerFactory.getLogger(InformationController.class);

    @Autowired
    private InformationService informationService;

    @Autowired
    private InfoService infoService;

    @Autowired
    private UserModService userModService;

    @Autowired
    private TypeRelationMapper typeRelationMapper;

    @Autowired
    private InfoImageMapper infoImageMapper;

    @Autowired
    private InfoContentMapper infoContentMapper;

    @Autowired
    private LogInfoService logInfoService;

    @Autowired
    private CheckType checkType;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 根据【资讯编号】获取对应资讯信息
     * @param infoId 资讯编号
     * @return
     */
    @RequestMapping(value = "/getInfoByInfoId/{infoId}", method = RequestMethod.POST)
    @ResponseBody
    public Message getUserInfoById(@PathVariable(value = "infoId") Integer infoId, HttpServletRequest request){

//        Information information = new Information();

        Integer addLStatus = 0;

        Integer upLStatus = 0;

        Info info = new Info();

        TypeRelation typeRelation = new TypeRelation();

        UserMod userMod = new UserMod();

        List<LogInfo> logInfos = new ArrayList<>();

        LogInfo logInfo = new LogInfo();

        try {
            info = infoService.getInfoByInfoId(infoId);

            //如果用户登录后查看新闻信息
            if (request.getHeader("token") != null){
                logger.info("用户已经登录！");
                UserInfo userInfo = jwtTokenUtil.parse(request.getHeader("token"));

                Integer userId = userInfo.getUserId();

                userMod = userModService.getUserModByUserId(userId);

                typeRelation = typeRelationMapper.getInfoByTRId(infoId);


                logInfos = logInfoService.getLogInfoByUserId(userId);

                if(logInfos.size()>0){
                    logInfo.setLookTime(new Date());
                    upLStatus = logInfoService.updateLogInfo(logInfo);
                    if (upLStatus==1){
                        logger.info("浏览日志>>>>>修改成功");
                    }
                }else {
                    logInfo.setUserId(userId);
                    logInfo.setInfoId(infoId);
                    logInfo.setLookTime(new Date());

                    //日志插入
                    addLStatus = logInfoService.addLogInfo(logInfo);
                    if (addLStatus==1){
                        logger.info("浏览日志>>>>>插入成功");
                    }
                }

                userMod = checkType.checkInfoType(userMod, typeRelation.getTypeId());

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
    /**
     * 更新资讯信息
     * @return
     */
    @RequestMapping(value = "/updateInfoById",method = RequestMethod.PUT)
    @ResponseBody
    public Message updateInfoById(@RequestBody Information information){

        try {
            int status = informationService.updateInformation(information);
            if (status == 1){

                return new Message(Message.SUCCESS,"修改资讯--成功",status);
            }else {
                return new Message(Message.FAILURE,"修改资讯--失败","检查数据源");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"修改资讯异常！",e);
        }
    }
}
