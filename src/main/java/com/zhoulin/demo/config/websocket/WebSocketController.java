package com.zhoulin.demo.config.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/public")
public class WebSocketController {

    @Autowired
    private SocketServer socketServer;

    @RequestMapping(value = "/index")
    public String idnex() {

        return "index";
    }

    @RequestMapping(value = "/admin")
    public String admin(Model model) {
        int num = SocketServer.getOnlineNum();
        String str = SocketServer.getOnlineUsers();
        model.addAttribute("num", num);
        model.addAttribute("users", str);
        return "admin";
    }

    /**
     * 个人信息推送
     *
     * @return
     */
    @RequestMapping("/sendmsg")
    @ResponseBody
    public String sendmsg(String msg, Integer userId) {
        //第一个参数 :msg 发送的信息内容
        //第二个参数为用户长连接传的username
        SocketServer.sendMessage(msg, userId);
        return "success";
    }

    /**
     * 推送给所有在线用户
     *
     * @return
     */
    @RequestMapping("/sendAll")
    @ResponseBody
    public String sendAll(String msg) {
        SocketServer.sendAll(msg);
        return "success";
    }

    /**
     * 获取当前在线用户
     *
     * @return
     */
    @RequestMapping("/webstatus")
    public String webstatus() {
        //当前用户个数
        int count = SocketServer.getOnlineNum();
        //当年用户的username
        SocketServer.getOnlineUsers();
        return "tongji";
    }
}