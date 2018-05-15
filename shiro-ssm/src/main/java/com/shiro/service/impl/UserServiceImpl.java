package com.shiro.service.impl;

import com.shiro.dao.UserDao;
import com.shiro.entity.User;
import com.shiro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by WS on 2018/5/13.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }

    @Override
    public Set<String> getRoles(String userName) {
        return userDao.getRoles(userName);
    }

    @Override
    public Set<String> getPermissions(String userName) {
        return userDao.getPermissions(userName);
    }


}
