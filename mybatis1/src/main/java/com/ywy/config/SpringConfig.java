package com.ywy.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configurable
@ComponentScan({"com.ywy"}) // 配置包扫描路径
@PropertySource(value = {"classpath:db.properties"}, ignoreResourceNotFound = true) // 读取db配置文件
@Import({JDBCConfig.class, MybatisConfig.class}) // 导入配置bean
@EnableAspectJAutoProxy // 开启注解式aop切面代理 不开启注解通知不会执行
public class SpringConfig {

}
