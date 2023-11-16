package com.ywy.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer id;
    private String name;
    private Integer cid;

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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cid=" + cid +
                '}';
    }

    public Product() {
    }

    public Product(Integer id, String name, Integer cid) {
        this.id = id;
        this.name = name;
        this.cid = cid;
    }
}
