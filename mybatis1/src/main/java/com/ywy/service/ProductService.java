package com.ywy.service;

import com.ywy.entity.User;

import java.util.List;

public interface ProductService {
    List<User> findAllByUids(Integer[] uids);
}
