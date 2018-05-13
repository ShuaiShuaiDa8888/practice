package com.weishuai.shiro.shiro_web;

import com.weishuai.shiro.realm_shiro.utils.CrypographyUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WS on 2018/5/7.
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = -8769370205388617679L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login doget");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login dopost");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, CrypographyUtils.md5(password, "盐"));
        try {
            if (subject.isRemembered()) {
                System.out.println("已经记住密码了！");
            } else {
                token.setRememberMe(true);
                subject.login(token);
            }
            resp.sendRedirect("/success.jsp");
        } catch (Exception e) {
            req.setAttribute("error", "用户名或密码错误！");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
