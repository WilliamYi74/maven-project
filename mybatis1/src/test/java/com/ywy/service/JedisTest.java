package com.ywy.service;

import com.ywy.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class JedisTest {
    @Autowired
    private Jedis jedis;

    @Test
    public void testRedis() {
        System.out.println("测试string----------------------------");
        // 测试string
        jedis.set("name", "william");
        System.out.println(jedis.get("name"));
        System.out.println("测试hash----------------------------");
        // 测试hash
        jedis.hset("person:id:1", "name", "张三");
        jedis.hset("person:id:1", "age", "17");
        jedis.hset("person:id:2", "name", "李四");
        jedis.hset("person:id:2", "age", "18");
        System.out.println("person1:name" + jedis.hget("person:id:1", "name"));
        System.out.println("person1:age" + jedis.hget("person:id:1", "age"));
        System.out.println("person2:name" + jedis.hget("person:id:2", "name"));
        System.out.println("person2:age" + jedis.hget("person:id:2", "age"));
        System.out.println("测试set----------------------------");
        jedis.sadd("persons", "01张三", "02李四", "03王五");
        System.out.println("persons:" + jedis.smembers("persons"));
        System.out.println("测试list----------------------------");
        jedis.lpop("list",9);
        jedis.lpush("list", "1", "2", "3");
        System.out.println("list:" + jedis.lrange("list", 0, -1));
    }

}
