package com.ywy.dao;

import com.ywy.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select u.id, u.name name,u.age age from user u ,us_pro up where u.id=up.uid and up.pid=#{pid}")
    public List<User> findByPid(Integer pid);

    @Select("select id, name, age from user where name like CONCAT('%',#{name},'%')")
    @Results({
            @Result(
                    property = "productList",
                    javaType = List.class,
                    column = "id",
                    many = @Many(select = "com.ywy.dao.ProductDao.findAllByUid")
            )
    })
    public List<User> findProductByUserName(String name);
}
