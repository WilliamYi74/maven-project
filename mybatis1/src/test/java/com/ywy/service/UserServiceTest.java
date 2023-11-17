package com.ywy.service;

import com.github.pagehelper.PageHelper;
import com.ywy.config.SpringConfig;
import com.ywy.dao.UserDao;
import com.ywy.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) // 使用spring提供的类加载器
@ContextConfiguration(classes = SpringConfig.class) // 读取spring指定上下文
public class UserServiceTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void test(){
        PageHelper.startPage(2,2);
        List<User> userList = userDao.findAll(null);
        userList.forEach(item->{
            System.out.println(item);
        });
    }
}
