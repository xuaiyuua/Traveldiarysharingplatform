package com.qdu.controller;

import com.qdu.pojo.Admin;
import com.qdu.pojo.Group_travel_activity;
import com.qdu.pojo.Travel_log;
import com.qdu.pojo.User;
import com.qdu.service.AdminService;
import com.qdu.service.UserService;
import com.qdu.service.impl.AdminServiceImpl;
import com.qdu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private AdminServiceImpl AdminServiceImpl;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;


    @RequestMapping("/toLogin")
    public String admin_login(){

        System.out.println("admin_login");
        return "/admin/admin_login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username") String adminname,
                        @RequestParam("password") String password,
                        HttpSession session, Model model){

        System.out.println(adminname);
        System.out.println(password);

        Admin admin= AdminServiceImpl.selectAdmin(adminname,password);
        //登录成功
        if (admin!=null){
            session.setAttribute("admin",admin.getAdminUsername());
            System.out.println("登录成功");
            return "admin/main";
        }else {
            model.addAttribute("msg","登录失败");
            return "admin/admin_login";
        }
    }

    @RequestMapping("/index")
    public String index(){

        return "admin/main";
    }

    @RequestMapping("/users")
    public String list(Model model){
        //查询用户列表
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        //跳转到员工列表页面
        return "admin/users";
    }

    @RequestMapping ("/searchUser")
    public String search(@RequestParam(name = "username", required = false) String username,
                         @RequestParam(name = "phone", required = false) String phone, Model model){
        System.out.println("++++++++++++++++++++");
        System.out.println(username);
        System.out.println(phone);
        List<User> userList =null;
        if (username!= null &&!username.isEmpty()) {
            // 执行根据用户名的查询操作
            userList = userService.getUserLikeName(username);
            System.out.println(userList);

        } else if (phone!= null &&!phone.isEmpty()) {
            // 执行根据手机号码的查询操作
            userList = userService.getUserLikePhone(phone);

        } else {
            userList = userService.getAllUser();
        }

        model.addAttribute("userList",userList);
        return "admin/users";
    }

    @RequestMapping("/deleteUser/{userId}")
    public String delete_user(@PathVariable Integer userId){
        System.out.println(userId+"删除");
        userService.deleteUser(userId);
        return "redirect:/admin/users";
    }

    @RequestMapping("/log")
    public String loglist(Model model){
        //查询日志列表
        List<Travel_log> logList = adminService.getAllLog();
        model.addAttribute("logList",logList);
        //跳转到员工列表页面
        return "admin/log";
    }

    @RequestMapping ("/searchLog")
    public String searchLog(@RequestParam(name = "userid", required = false) String userid,
                         @RequestParam(name = "logtitle", required = false) String logtitle, Model model){
        System.out.println("++++++++++++++++++++");
        System.out.println(userid);
        System.out.println(logtitle);
        List<Travel_log> logList =null;
        if (userid!= null &&!userid.isEmpty()) {
            // 执行根据用户名的查询操作
            logList = adminService.getLogLikeId(userid);
            System.out.println(logList);

        } else if (logtitle!= null &&!logtitle.isEmpty()) {
            // 执行根据手机号码的查询操作
            logList = adminService.getLogLikeTitle(logtitle);

        } else {

            logList = adminService.getAllLog();
        }

        model.addAttribute("logList",logList);
        return "admin/log";
    }

    @RequestMapping("/deleteLog/{logId}")
    public String delete_log(@PathVariable Integer logId){
        System.out.println(logId+"删除");
        adminService.deleteLog(logId);
        return "redirect:/admin/log";
    }

    @RequestMapping("/activity")
    public String activitylist(Model model){
        //查询日志列表
        List<Group_travel_activity> activityList = adminService.getAllActivity();
        model.addAttribute("activityList",activityList);
        //跳转到员工列表页面
        return "admin/activity";
    }

    @RequestMapping ("/searchActivity")
    public String searchActivity(@RequestParam(name = "userid", required = false) String userid,
                            @RequestParam(name = "activitytitle", required = false) String activitytitle, Model model){
        System.out.println("++++++++++++++++++++");
        System.out.println(userid);
        System.out.println(activitytitle);
        List<Group_travel_activity> activityList =null;
        if (userid!= null &&!userid.isEmpty()) {
            // 执行根据用户名的查询操作
            activityList = adminService.getActivityLikeId(userid);
            System.out.println(activityList);

        } else if (activitytitle!= null &&!activitytitle.isEmpty()) {
            // 执行根据手机号码的查询操作
            activityList = adminService.getActivityLikeTitle(activitytitle);

        } else {

            activityList = adminService.getAllActivity();
        }

        model.addAttribute("activityList",activityList);
        return "admin/activity";
    }

    @RequestMapping("/deleteActivity/{activityId}")
    public String delete_activity(@PathVariable Integer activityId){
        System.out.println(activityId+"删除");
        adminService.deleteActivity(activityId);
        return "redirect:/admin/activity";
    }
}
