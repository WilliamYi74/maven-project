package com.ywy.controller;

import com.ywy.dao.ProductDao;
import com.ywy.entity.Product;
import com.ywy.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProductController {
    @Test
    public void findProduct() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductDao mapper = sqlSession.getMapper(ProductDao.class);
        List<Product> productList = mapper.findAll();
        for (Product product : productList) {
            System.out.print("购买[" + product.getName() + "]的用户=>");
            for (User user : product.getUserList()) {
                System.out.print(user.getName() + " ");
            }
            System.out.println();
        }
        System.out.println(productList);
    }
}
