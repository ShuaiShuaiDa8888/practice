package com.shiro.controller;

import com.shiro.entity.User;
import com.shiro.utils.CrypographyUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by WS on 2018/5/13.
 */
@Controller
@RequestMapping("/api/1.0")
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), CrypographyUtils.md5(user.getPassword(), "盐"));
        try{
            subject.login(token);
            Session session = subject.getSession();
            System.out.println("sessionId: " + session.getId());
            System.out.println("sessionHost: " + session.getHost());
            System.out.println("sessionTimeout: " + session.getTimeout());
            session.setAttribute("info", "session的数据");
            return "redirect:/home.jsp";
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("user", user);
            request.setAttribute("errorMsg", "用户名或密码错误！");
            return "index";
        }
    }
}
