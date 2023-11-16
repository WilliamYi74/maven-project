package com.ywy.entity;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private Integer id;
    private String name;
    private Integer cid;
    private List<User> userList;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cid=" + cid +
                ", userList=" + userList +
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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Product() {
    }

    public Product(Integer id, String name, Integer cid, List<User> userList) {
        this.id = id;
        this.name = name;
        this.cid = cid;
        this.userList = userList;
    }
}
