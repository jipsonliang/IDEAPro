package com.jipson.mybatis.util;

import com.jipson.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Util {
    //静态成员变量属于整个类所有，访问可不用new出类对象，直接使用类.成员变量访问
    private static SqlSessionFactory sf;

    //静态代码块在加载时执行一次
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sf = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 开启会话
     * 封装成静态方法调用，直接调用
     */
    public static SqlSession openSession(){
        return sf.openSession();
    }

    /**
     * 关闭会话
     * 关闭哪个会话，要把哪个会话由参赛带进来
     */
    public static void closeSession(SqlSession s){
        if(s != null){
            s.close();
        }
    }

    /**
     * 回滚事务
     */
    public static void rollBack(SqlSession s){
        if(s != null){
            s.rollback();
        }
    }
}
