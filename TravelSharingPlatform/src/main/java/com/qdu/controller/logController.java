package com.qdu.controller;

import com.qdu.pojo.Log_comment;
import com.qdu.pojo.Travel_log;
import com.qdu.pojo.User;
import com.qdu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
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

    @RequestMapping("/submit")
    public String handleLogSubmit(@RequestParam("logTitle") String logTitle,
                                  @RequestParam("logContent") String logContent,
                                  @RequestParam("userName1") String userName1,
                                  HttpSession session) {

        System.out.println(userName1);

        Travel_log log = new Travel_log();
        User user1 = userService.getUserByUsername(userName1);
        log.setLogTitle(logTitle);
        log.setLogContent(logContent);
        log.setUserId(user1.getUserId());

        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        log.setPublishTime(date);

        userService.addLog(log);

        return "redirect:/user/publish";
    }

}
