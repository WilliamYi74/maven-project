package com.ywy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;

/**
 * jdbc配置bean
 */
public class JDBCConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")
    public DataSource getDataSource() {
        try {
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setDriverClassName(this.driver);
            dataSource.setUrl(this.url);
            dataSource.setUsername(this.username);
            dataSource.setPassword(this.password);
            return dataSource;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
