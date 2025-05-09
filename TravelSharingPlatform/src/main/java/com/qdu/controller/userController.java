package com.qdu.controller;

import com.qdu.pojo.Admin;
import com.qdu.pojo.Group_travel_activity;
import com.qdu.pojo.Travel_log;
import com.qdu.pojo.User;
import com.qdu.service.AdminService;
import com.qdu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/to_login")
    public String to_login() {
        return "user/user_login";
    }

    @GetMapping("/to_register")
    public String to_register() {
        return "user/register";
    }

    @GetMapping("/to_userself")
    public String to_userself() {
        return "user/userself";
    }

    @GetMapping("/password")
    public String password() {
        return "user/password";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session, Model model){

        System.out.println(username);
        System.out.println(password);

        User user= userService.selectUser(username,password);
        //登录成功
        if (user!=null){
            session.setAttribute("user",username);
            System.out.println("登录成功");
            return "/index";
        }else {
            model.addAttribute("msg","登录失败");
            return "user/user_login";
        }
    }

    @PostMapping("/register")
    public String addUser(User u,HttpSession session, Model model) {

        if (userService.check(u.getUsername())==1){

//            String encodePassword = pwdEncoder.encode(u.getUserpwd());//随机盐加密后的密码

            userService.addUser(u.getUsername(),u.getPassword(),u);

            return "user/user_login";

        }else {
            model.addAttribute("msg","注册失败");
            return "user/register";
        }
    }

    @RequestMapping("/profile")
    public String profile( HttpSession session,Model model){

        String username = (String)session.getAttribute("user");
        if(username==null)
            System.out.println("未找到user");
        User user = userService.getUserByUsername(username);

        model.addAttribute("user",user);
        return "user/profile";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("username") String username,
                         @RequestParam("email") String email,
                         @RequestParam("gender") String gender,
                         @RequestParam("city") String city,
                         @RequestParam("occupation") String occupation,
                         HttpSession session)
    {
        com.qdu.pojo.User user1 = userService.getUserByUsername(username);

        user1.setEmail(email);
        user1.setGender(gender);
        user1.setCity(city);
        user1.setOccupation(occupation);
        userService.updateByUsername(user1,username);
        return "user/userself";
    }

    @RequestMapping("/changepassword")
    public String changepassword(HttpSession session,String oldPassword,String newPassword){

        String username = (String)session.getAttribute("user");
        com.qdu.pojo.User user1 = userService.getUserByUsername(username);

        if(user1.getPassword().equals(oldPassword)){
            userService.changepwd(username,newPassword);
            return "user/userself";
        }else {
            return "user/password_fail";
        }
    }

    @RequestMapping ("/user_log/{username}")
    public String searchLog(@PathVariable String username,
                                 Model model){
        System.out.println("++++++++++++++++++++");
        System.out.println(username);
        List<Travel_log> LogList =null;
        User user1 = userService.getUserByUsername(username);

        System.out.println(user1.getUserId());

        LogList = adminService.getLogLikeId(String.valueOf(user1.getUserId()));

        model.addAttribute("LogList",LogList);
        return "user/mylog";
    }

    @RequestMapping("/deleteLog/{logId}")
    public String delete_log(@PathVariable Integer logId){
        System.out.println(logId+"删除");
        adminService.deleteLog(logId);
        return "redirect:/user/to_userself";
    }

    @RequestMapping ("/user_activity/{username}")
    public String searchActivity(@PathVariable String username,
                                 Model model){
        System.out.println("++++++++++++++++++++");
        System.out.println(username);
        List<Group_travel_activity> ActivityList =null;
        User user1 = userService.getUserByUsername(username);

        System.out.println(user1.getUserId());

        ActivityList = adminService.getActivityLikeId(String.valueOf(user1.getUserId()));

        model.addAttribute("activityList",ActivityList);
        return "user/my_activity";
    }

    @RequestMapping("/deleteActivity/{activityId}")
    public String delete_activity(@PathVariable Integer activityId){
        System.out.println(activityId+"删除");
        adminService.deleteActivity(activityId);
        return "redirect:/user/to_userself";
    }


}
