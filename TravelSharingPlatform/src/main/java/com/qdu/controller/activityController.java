package com.qdu.controller;

import com.qdu.pojo.Group_travel_activity;
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

@Controller
@RequestMapping("/activity")
public class activityController {

    @Autowired
    private UserService userService;

    @RequestMapping("/to_detail/{activityId}")
    public String log(@PathVariable int activityId , Model model){

        model.addAttribute("activity",userService.getActivityById(activityId));
        return "/activity/activitydetail";
    }

    @RequestMapping("/submit")
    public String handleActivitySubmit(@RequestParam("activityTitle") String activityTitle,
                                  @RequestParam("activityDescription") String activityDescription,
                                  @RequestParam("userName2") String userName2,
                                  HttpSession session) {

        Group_travel_activity activity = new Group_travel_activity();
        User user1 = userService.getUserByUsername(userName2);
        activity.setActivityTitle(activityTitle);
        activity.setActivityDescription(activityDescription);
        activity.setUserId(user1.getUserId());

        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        activity.setCreateTime(date);

        userService.addActivity(activity);

        return "redirect:/user/publish";
    }
}
