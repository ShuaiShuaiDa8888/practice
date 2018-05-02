package com.weishuai.shiro.shiro03;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by WS on 2018/5/2.
 */
public class Shiro03Util {
    public static Subject login(String classpath, String userName, String password){
        //创建一个SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(classpath);
        //构造SecurityUtils实例
        SecurityManager instance = factory.getInstance();
        //将SecurityManager设置在系统运行环境中
        SecurityUtils.setSecurityManager(instance);
        //用SecurityUtils获取Subject，用来访问系统资源
        Subject subject = SecurityUtils.getSubject();
        //设置用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            subject.login(token);
            System.out.println(subject.isAuthenticated() ? "登陆success！" : "登陆fail！");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("出现异常，登陆失败！");
        }
        return subject;
    }
}
