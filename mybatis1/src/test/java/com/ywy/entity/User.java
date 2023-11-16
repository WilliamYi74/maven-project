package com.ywy.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    
    private Orders orders;
    private List<Orders> ordersList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", orders=" + orders +
                ", ordersList=" + ordersList +
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

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public User() {
    }

    public User(Integer id, String name, Integer age, Orders orders, List<Orders> ordersList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.orders = orders;
        this.ordersList = ordersList;
    }
}
