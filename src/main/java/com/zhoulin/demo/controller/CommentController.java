package com.zhoulin.demo.controller;

import com.zhoulin.demo.bean.InfoComment;
import com.zhoulin.demo.bean.Message;
import com.zhoulin.demo.bean.UserInfo;
import com.zhoulin.demo.service.CommentService;
import com.zhoulin.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/public")
public class CommentController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private CommentService commentService;

    /**
     * 查询一篇资讯的所有评论
     * @param id
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping(value = "/information/{id}/comment", method = RequestMethod.GET)
    @ResponseBody
    public Message commentList(@PathVariable(value = "id") Integer id,
                               @RequestParam("limit") int limit,
                               @RequestParam("page") int page){
        List<InfoComment> commentList = new ArrayList<>();
        try {
            commentList = commentService.getListByInfoId(id,page,limit);
            return new Message(Message.SUCCESS,"获取资讯评论成功！",commentList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(Message.ERROR,"获取资讯评论失败！",null);
        }
    }
}
