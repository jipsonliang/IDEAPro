package com.jipson.mybatis.domain;

import java.util.List;

/**
 * 订单类
 */
public class Order {
    private Integer id;
    private String orderNo;
    //建立关联关系
    private User user;//通过对象访问用户id
    private List<Item> items;//通过对象访问items
    //配置一对多（一个订单对多个物品，多用集合List）
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
