package com.jipson.mybatis.test;

import com.jipson.mybatis.domain.Order;
import com.jipson.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestUser {
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

        u.setName("jetty");
        u.setAge(15);
        s.insert("users.insert", u);
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
        User u = new User();
        u.setId(1);
        u.setName("jack");
        u.setAge(18);
        s.insert("users.update", u);
        s.commit();//提交事务
        s.close();
    }

    /**
     * 查询一个
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
        //User u = new User();
        User user = s.selectOne("users.selectone", 1);
        System.out.println(user.getName()+": "+user.getAge());

        for (Order o: user.getOrders()){
            System.out.println(o.getId() + ":" + o.getOrderNo());
        }


       // s.commit();//提交事务
        s.close();
    }

    /**
     * update
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
        //System.out.println(s);
        // User u = new User();
        List<User> user = s.selectList("users.selectall");
        for (User uu: user) {
            System.out.println(uu.getName()+":"+uu.getAge());
        }

        // s.commit();//提交事务
        s.close();
    }
}
