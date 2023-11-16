package com.ywy.controller;

import com.ywy.dao.ProductDao;
import com.ywy.dao.UserDao;
import com.ywy.entity.Product;
import com.ywy.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserController {
    @Test
    public void findProductByUserName() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.findProductByUserName("三");
        System.out.println(user.getName() + "有如下商品:");
        for (Product product : user.getProductList()) {
            System.out.print(product.getName() + ",");
        }
    }
}
