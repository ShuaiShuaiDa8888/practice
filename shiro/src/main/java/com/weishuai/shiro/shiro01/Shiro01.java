package com.weishuai.shiro.shiro01;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by WS on 2018/5/1.
 */
public class Shiro01 {
    public static void main(String[] args) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro01.ini");
        SecurityManager instance = factory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("java1234", "123456");
        try {
            subject.login(token);
            System.out.println(subject.isAuthenticated() ? "登陆成功" : "登陆失败");
        }catch (Exception e){
            e.printStackTrace();
        }
        subject.logout();
    }
}
