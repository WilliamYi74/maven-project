package com.ywy.service.impl;

import com.ywy.dao.ProductDao;
import com.ywy.dao.impl.ProductDaoImpl;
import com.ywy.entity.User;
import com.ywy.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao = new ProductDaoImpl();
    public List<User> findAllByUids(Integer[] uids) {
        return null;
    }
}
