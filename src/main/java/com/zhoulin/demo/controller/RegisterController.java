package com.zhoulin.demo.controller;

import com.zhoulin.demo.bean.Message;
import com.zhoulin.demo.bean.UserInfo;
import com.zhoulin.demo.service.RegisterService;
import com.zhoulin.demo.service.UserInfoService;
import com.zhoulin.demo.utils.RedisTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * RegisterController 注册控制类
 */
@RestController
@RequestMapping(value = "/public")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RedisTokenManager tokenManager;

//    @Value("${server.link}")
//    private String link;

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    public Message UserRegister(@RequestBody UserInfo userInfo){

        String code = tokenManager.getTokenOfSignUp(userInfo);

        try {

            registerService.registerUserInfo(userInfo, code);
            return new Message(Message.SUCCESS,"注册用户信息--成功>>>>激活邮件发送中",code);

        } catch (Exception e) {

            e.printStackTrace();
            return new Message(Message.ERROR,"注册用户信息--异常",null);

        }

    }

    @RequestMapping(value = "/user/activate/{code}",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Message activate(@PathVariable(value = "code") String code){

        UserInfo userInfo = new UserInfo();

        int actStatus = 0;

        try {
            userInfo = registerService.activationUserInfo(code);

            actStatus = userInfoService.addUserInfo(userInfo);

            if (actStatus == 1){
                return new Message(Message.SUCCESS,"用户激活成功",actStatus);
            } else if(actStatus == 0){
                return new Message(Message.FAILURE,"用户激活失败",actStatus);
            } else {
                return new Message(Message.ERROR,"用户激活异常",actStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"用户激活异常",null);
        }

    }





}
