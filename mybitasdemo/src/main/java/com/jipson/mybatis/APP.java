package com.jipson.mybatis;

import com.jipson.mybatis.dao.UserDao;
import com.jipson.mybatis.domain.User;

import java.util.List;

public class APP {
    public static void main(String[] args) {
        UserDao dao = new UserDao();
        User us = dao.selectOne(1);
        System.out.println(us.getName());

        System.out.println("-------------");

        List<User> u = dao.selectAll();
        for (User uu : u  ) {
            System.out.println(uu.getName());

        }
        //添加了一行
    }
}
