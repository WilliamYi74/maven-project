package com.ywy;


import com.ywy.config.SpringConfig;
import com.ywy.entity.User;
import org.junit.Test;
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

    public User testAspectJ(String name, int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        System.out.println("原始方法执行了...");
        return user;
    }
}
