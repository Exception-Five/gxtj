package com.zhoulin.demo.controller;

import com.zhoulin.demo.bean.Message;
import com.zhoulin.demo.bean.UserInfo;
import com.zhoulin.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/public")
public class LoginController {

    @Autowired
    private LoginService loginService;

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

//    @RequestMapping(value = "/api/user/loginOut",method = RequestMethod.POST)
//    public Message loginOut(HttpServletResponse response){
//
//        Message message = loginService.loginOut(response);
//
//        return message;
//    }


}
