package com.zhoulin.demo.service.impl;

import com.zhoulin.demo.bean.Message;
import com.zhoulin.demo.bean.UserGroup;
import com.zhoulin.demo.bean.UserInfo;
import com.zhoulin.demo.config.security.JwtTokenUtil;
import com.zhoulin.demo.mapper.UserGroupMapper;
import com.zhoulin.demo.mapper.UserInfoMapper;
import com.zhoulin.demo.service.LoginService;
import com.zhoulin.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public Message login(UserInfo userInfo, HttpServletResponse response) {

        UserInfo user = userInfoMapper.getUserByUsername(userInfo.getUsername());

        if(user != null){
            if(userInfo.getPassword().equals(user.getPassword())&&userInfo.getUsername().equals(user.getUsername())){

                UserGroup userGroup = userGroupMapper.getByUserId(user.getUserId());

                user.setUserGroup(userGroup);

                List<String> roles = new ArrayList<>();

                roles.add(userGroup.getPermission());

                user.setRoles(roles);

                response.addHeader("refresh",jwtTokenUtil.create(user));

                //定义登录时间
                Date loginTime = new Date();

                String loginTimeMsg = null;

                user.setLastLoginTime(loginTime);

                try {
                    Integer loginStatus = userInfoService.updateUserInfo(user);
                    if (loginStatus == 1){
                        loginTimeMsg = "登录时间已经更新：" + loginTime;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    loginTimeMsg = "登录时间更新异常";
                }

                return new Message(Message.SUCCESS,"登陆成功" + loginTimeMsg, user);
            }else {
                return new Message(Message.ERROR,"密码错误",null);
            }
        }else {
            return new Message(Message.ERROR,"用户名不存在",null);
        }

    }

    @Override
    public Message loginOut(HttpServletResponse response) {

        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getDetails();

        response.setHeader("refresh",jwtTokenUtil.create(userInfo));

        return new Message(Message.SUCCESS,"退出成功" , null);
    }

}
