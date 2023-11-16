package com.ywy.controller;


import com.ywy.dao.ProductDao;
import com.ywy.entity.Product;
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
    public void testFindAll() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductDao mapper = sqlSession.getMapper(ProductDao.class);
        List<Product> productList = mapper.findAll();
        productList.forEach(item -> {
            System.out.println(item);
        });
    }

    @Test
    public void testInsertProduct() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductDao mapper = sqlSession.getMapper(ProductDao.class);
        Product product = new Product(null, "小包包", 1);
        int effectRows = mapper.insertProduct(product);
        System.out.println(effectRows + "条成功");
    }
}
