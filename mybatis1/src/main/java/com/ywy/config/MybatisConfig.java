package com.ywy.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.log4j.Logger;
import org.mybatis.logging.LoggerFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * mybatis核心配置Bean
 * 使用@Bean给第三方库注入配置
 */
public class MybatisConfig {
    /**
     * 需要给mybatis提供一个sqlsession工厂bean
     *
     * @param dataSource 注入数据源
     * @return
     */
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(@Autowired DataSource dataSource) {
        try {
            SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
            ssfb.setTypeAliasesPackage("com.ywy.entity"); // 设置实体包扫描 注册Bean实体别名
            ssfb.setDataSource(dataSource); // 设置数据源
            //配置分页插件
            PageHelper pageHelper = new PageHelper();
            Properties properties = new Properties();
            properties.setProperty("pageSizeZero", "true");//分页尺寸为0时查询所有纪录不再执行分页
            properties.setProperty("reasonable", "true");//页码<=0 查询第一页，页码>=总页数查询最后一页
            properties.setProperty("supportMethodsArguments", "true");//支持通过 Mapper 接口参数来传递分页参数
            pageHelper.setProperties(properties);

            ssfb.setPlugins(new Interceptor[]{pageHelper});
            System.out.println(dataSource);
            return ssfb;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置mapper包扫描 告诉mybatis需要代理生成实现类的dao接口在哪
     *
     * @return
     */
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.ywy.dao");
        return mapperScannerConfigurer;
    }

    @Bean
    public org.mybatis.logging.Logger getLogger() {
        return LoggerFactory.getLogger(Logger.class);
    }
}
