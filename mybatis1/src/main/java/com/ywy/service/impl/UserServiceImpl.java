package com.ywy.service.impl;

import com.ywy.dao.UserDao;
import com.ywy.dao.impl.UserDaoImpl;
import com.ywy.entity.User;
import com.ywy.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();
    public List<User> findAll() {
        return userDao.findAll();
    }
}
