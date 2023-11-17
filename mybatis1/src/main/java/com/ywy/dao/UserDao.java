package com.ywy.dao;

import com.ywy.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserDao {
    List<User> findAll(User user);
}
