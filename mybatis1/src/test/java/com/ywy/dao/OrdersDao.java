package com.ywy.dao;

import com.ywy.entity.Orders;

import java.util.List;

public interface OrdersDao {
    List<Orders> findByOrders(Orders orders);
    Long batchUpdateNumberByIds(List<Orders> orders);
}
