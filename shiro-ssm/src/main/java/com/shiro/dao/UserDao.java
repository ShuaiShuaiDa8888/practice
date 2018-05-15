package com.shiro.dao;

import com.shiro.entity.User;

import java.util.Set;

/**
 * Created by WS on 2018/5/13.
 */
public interface UserDao {

    /**
     * 通过用户名查询用户
     *
     * @param userName
     * @return
     */
    User getByUserName(String userName);

    /**
     * 通过用户名查询角色信息
     *
     * @param userName
     * @return
     */
    Set<String> getRoles(String userName);

    /**
     * 通过用户名查询权限信息
     *
     * @param userName
     * @return
     */
    Set<String> getPermissions(String userName);
}
