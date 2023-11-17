package com.ywy;


import com.ywy.config.SpringConfig;
import com.ywy.dao.UserDao;
import com.ywy.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class App {

    @Test
    public void test(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        ac.getBean("dataSource");
    }
}
