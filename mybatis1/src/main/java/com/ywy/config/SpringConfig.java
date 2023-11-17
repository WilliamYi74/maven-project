package com.ywy.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configurable
@ComponentScan({"com.ywy"})
@PropertySource(value = {"classpath:db.properties"}, ignoreResourceNotFound = true) // 读取db配置文件
@Import({JDBCConfig.class, MybatisConfig.class})
public class SpringConfig {

}
