package com.qdu.controller;

import com.qdu.pojo.Log_comment;
import com.qdu.pojo.Travel_log;
import com.qdu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/log")
public class logController {

    @Autowired
    private UserService userService;


    @RequestMapping("/to_detail/{logId}")
    public String log(@PathVariable int logId , Model model){
        System.out.println(logId+"+++++++++++++++++++++");
        List<Log_comment> CommentList =null;
        CommentList = userService.getCommentByLogId(logId);
        userService.getLogById(logId);
        model.addAttribute("log",userService.getLogById(logId));
        model.addAttribute("comment",CommentList);
        return "/log/logdetail";
    }
}
