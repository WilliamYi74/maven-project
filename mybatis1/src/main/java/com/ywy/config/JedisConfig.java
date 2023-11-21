package com.ywy.config;

import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * redis配置类
 */
public class JedisConfig {
    private static String host;
    private static Integer port;
    private static String password;
    private static Integer maxTotal; // 最大连接数
    private static Integer maxIdle; // 最大活动连接数

    private static JedisPoolConfig jedisPoolConfig; // jedis连接池配置文件
    private static JedisPool jedisPool; // jedis连接池对象
    private static Integer timeout; // jedis连接超时时间

    static {
        ResourceBundle jedisProperties = ResourceBundle.getBundle("jedis"); // 根据properties文件名读取prop文件
        host = jedisProperties.getString("jedis.host");
        port = Integer.parseInt(jedisProperties.getString("jedis.port"));
        maxTotal = Integer.parseInt(jedisProperties.getString("jedis.maxTotal"));
        maxIdle = Integer.parseInt(jedisProperties.getString("jedis.maxIdle"));
        password = jedisProperties.getString("jedis.password");
        timeout =  Integer.parseInt(jedisProperties.getString("jedis.timeout"));
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
    }

    /**
     * Jedis工厂方法获取连接对象
     * @return Jedis
     */
    @Bean
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
