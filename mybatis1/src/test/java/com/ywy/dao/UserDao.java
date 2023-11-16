package com.ywy.dao;

import com.ywy.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll(User user);
}
