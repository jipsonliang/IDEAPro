package com.jipson.mybatis.domain;

import java.util.List;

/**
 * 用户类
 */
public class User {
    private Integer id;//这里为啥写包装类
    private String name;
    private int age;

    //配置一对多（一个用户对多个订单）
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
