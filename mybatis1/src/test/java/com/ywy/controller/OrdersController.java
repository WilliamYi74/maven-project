package com.ywy.controller;

import com.ywy.dao.OrdersDao;
import com.ywy.entity.Orders;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class OrdersController {
    @Test
    public void testFindOrdersById() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersDao mapper = sqlSession.getMapper(OrdersDao.class);
        List<Orders> ordersList = mapper.findByOrders(null);
        System.out.println(ordersList);
    }

    @Test
    public void testBatchUpdateNameByIds() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrdersDao mapper = sqlSession.getMapper(OrdersDao.class);
        List<Orders> ordersList = new ArrayList();
        for (int i = 1; i < 8; i++) {
            Orders orders = new Orders();
            orders.setId(i);
            ordersList.add(orders);
        }
        Long effectRows = mapper.batchUpdateNumberByIds(ordersList);
        System.out.println(effectRows + "条成功");
    }
}
