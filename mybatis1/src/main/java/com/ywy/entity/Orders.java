package com.ywy.entity;

import java.io.Serializable;

public class Orders implements Serializable {
    private Integer id;
    private String number;
    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", uid=" + uid +
                '}';
    }

    public Orders() {
    }

    public Orders(Integer id, String number, Integer uid) {
        this.id = id;
        this.number = number;
        this.uid = uid;
    }
}
