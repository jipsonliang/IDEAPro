package com.jipson.mybatis.test;


import com.jipson.mybatis.domain.Item;
import com.jipson.mybatis.domain.Order;
import com.jipson.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestOrder {
    /**
     * insert
     */
    @Test
    public void insert() throws Exception {
        //指定java类路径
        String resource = "mybatis-config.xml";
        //加载文件，形成输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂Builder,相当于连接池
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sf打开会话建立连接
        SqlSession s = sf.openSession();
        //System.out.println(s);
        User u = new User();
        u.setId(2);
        Order o = new Order();
        o.setOrderNo("No005");
        o.setUser(u);
        s.insert("orders.insert", o);
        s.commit();//提交事务
        s.close();
    }

    /**
     * update
     */
    @Test
    public void update() throws Exception {
        //指定java类路径
        String resource = "mybatis-config.xml";
        //加载文件，形成输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂Builder,相当于连接池
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sf打开会话建立连接
        SqlSession s = sf.openSession();
        //System.out.println(s);
        Order o = new Order();
        o.setId(5);
        o.setOrderNo("No005");
        s.insert("orders.update", o);
        s.commit();//提交事务
        s.close();
    }

    /**
     * selectOne
     */
    @Test
    public void selectOne() throws Exception {
        //指定java类路径
        String resource = "mybatis-config.xml";
        //加载文件，形成输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂Builder,相当于连接池
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sf打开会话建立连接
        SqlSession s = sf.openSession();
        //System.out.println(s);

        Order order = s.selectOne("orders.selectone", 1);
        System.out.println(order.getOrderNo()+": "+order.getUser().getName());
        for (Item i: order.getItems()) {
            System.out.println(i.getId() + ":" + i.getItemName());
            
        }

       // s.commit();//提交事务
        s.close();
    }

    /**
     * selectAll
     */
    @Test
    public void selectAll() throws Exception {
        //指定java类路径
        String resource = "mybatis-config.xml";
        //加载文件，形成输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂Builder,相当于连接池
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sf打开会话建立连接
        SqlSession s = sf.openSession();


        List<Order> order = s.selectList("orders.selectall");
        for ( Order o: order ) {
            System.out.println(o.getOrderNo()+": "+o.getUser().getName());
        }

        s.close();
    }

}
