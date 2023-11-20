package com.ywy.dao;

import com.ywy.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    List<User> findAll(User user);
}
