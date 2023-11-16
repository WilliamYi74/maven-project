package com.ywy.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;

    private List<Product> productList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", productList=" + productList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public User() {
    }

    public User(Integer id, String name, Integer age, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.productList = productList;
    }
}
