package com.zhoulin.demo.controller;

import com.zhoulin.demo.bean.Message;
import com.zhoulin.demo.bean.UserInfo;
import com.zhoulin.demo.service.LoginService;
import com.zhoulin.demo.service.UserInfoService;
import com.zhoulin.demo.utils.IpUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/public")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Message login(@RequestBody UserInfo user, HttpSession session, HttpServletResponse response){

        Message message = loginService.login(user,response);
        if(message != null){
            if(message.getStatus() == Message.SUCCESS){
                session.setAttribute("user",message.getResult());
            }
        }
        return message;
    }

    /**
     * 获取用户IP地址直接注册/登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/getIp", method = RequestMethod.POST)
    @ResponseBody
    public Message getIp(HttpServletRequest request) {

        //获取用户IP
        String userIp = IpUtil.getIpAddr(request);

        //通过用户IP直接注册
        UserInfo userInfo = new UserInfo(userIp, userIp, userIp, 1, 1, new Date(), new Date());

        try {
            //判断是否之前注册过
            UserInfo isExistUser = userInfoService.getUserByUsername(userIp);
            if (isExistUser != null){
                return new Message(Message.SUCCESS, "IP已存在 >>>> IP :" + userIp , isExistUser);
            }
            else {
                int addStatus = userInfoService.addUserInfo(userInfo);

                if (addStatus == 1){
                    return new Message(Message.SUCCESS, "IP注册 >>>> 成功 >>>> IP :" + userIp , userInfo);
                }
                return new Message(Message.SUCCESS, "IP注册 >>>> 失败 >>>> IP :" + userIp , addStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR, "IP注册 >>>> 异常 >>>> IP :" + userIp , e.getMessage());
        }


    }




}
