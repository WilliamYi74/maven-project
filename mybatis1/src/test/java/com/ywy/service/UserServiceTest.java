package com.ywy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywy.App;
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
@ContextConfiguration(classes = SpringConfig.class) // 读取spring的上下文配置文件或者spring配置文件的位置
public class UserServiceTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    private App app;
    @Test
    public void test(){
        PageHelper.startPage(1,10);
        List<User> userList = userDao.findAll(null);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        pageInfo.getList().forEach(System.out::println);
    }

    @Test
    public void testApp(){
        app.testAspectJ("william", 17);
    }
}
