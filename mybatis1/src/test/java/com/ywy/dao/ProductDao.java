package com.ywy.dao;

import com.ywy.entity.Product;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();

    @Insert({
            "insert into product values(null, #{product.name}, #{product.cid})"
    })
    int insertProduct(Product product);
}
