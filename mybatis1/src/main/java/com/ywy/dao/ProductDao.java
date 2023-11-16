package com.ywy.dao;

import com.ywy.entity.Product;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
    @Select("select p.id, p.name, p.cid from product p, us_pro up where p.id = up.pid")
    @Results({
            @Result(
                    property = "userList",
                    javaType = List.class,
                    column = "id",
                    many = @Many(select = "com.ywy.dao.UserDao.findByPid")
            )
    })
    public List<Product> findAll();

    public List<Product> findAllByUids(Integer[] uids);
}
