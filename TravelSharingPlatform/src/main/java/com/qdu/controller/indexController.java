package com.qdu.controller;

import com.qdu.pojo.Travel_log;
import com.qdu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class indexController {
    @Autowired
    private UserService userService;
    //首页加载
    @RequestMapping({"/","/index"})
    public String eachList( Model model){
        List<Travel_log> logs = userService.getThreeLog();
        System.out.println(logs);
        System.out.println("------------------------------------------------------------");
        model.addAttribute("logList",userService.getThreeLog());


        return "index";
    }
}
