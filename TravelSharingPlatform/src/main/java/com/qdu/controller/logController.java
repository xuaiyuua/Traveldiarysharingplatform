package com.qdu.controller;

import com.qdu.pojo.Log_comment;
import com.qdu.pojo.Travel_log;
import com.qdu.pojo.User;
import com.qdu.service.AdminService;
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

    @Autowired
    private AdminService adminService;

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

    @RequestMapping("/log")
    public String loglist(Model model){
        //查询日志列表
        List<Travel_log> logList = adminService.getAllLog();
        model.addAttribute("logList",logList);
        //跳转到员工列表页面
        return "/log/logsearch";
    }

    @RequestMapping ("/searchLog")
    public String searchLog(@RequestParam(name = "logtitle", required = false) String logtitle, Model model){
        System.out.println("++++++++++++++++++++");
        System.out.println(logtitle);
        List<Travel_log> logList =null;
         if (logtitle!= null &&!logtitle.isEmpty()) {
            // 执行根据手机号码的查询操作
            logList = adminService.getLogLikeTitle(logtitle);

        } else {

            logList = adminService.getAllLog();
        }

        model.addAttribute("logList",logList);
        return "log/logsearch";
    }

}
