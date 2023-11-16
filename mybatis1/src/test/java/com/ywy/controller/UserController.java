package com.ywy.controller;

import com.ywy.dao.UserDao;
import com.ywy.entity.Orders;
import com.ywy.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserController {
    @Test
    public void testFindById() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setName("三");
//        user.setId(2);
        Orders orders = new Orders();
        orders.setId(3);
//        orders.setNumber("hm006");
        user.setOrders(orders);
        List<User> userList = mapper.findAll(user);
        for (User u : userList) {
            System.out.println(u);
            for (Orders o : u.getOrdersList()) {
                System.out.println(o);
            }
        }
    }
}
