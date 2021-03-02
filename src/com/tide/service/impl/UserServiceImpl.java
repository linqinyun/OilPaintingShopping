package com.tide.service.impl;

import com.tide.dao.UserDao;
import com.tide.dao.impl.UserDaoImpl;
import com.tide.daomain.User;
import com.tide.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User login(User user) {
        UserDao userDao = new UserDaoImpl();

        return userDao.login(user);
    }
}
