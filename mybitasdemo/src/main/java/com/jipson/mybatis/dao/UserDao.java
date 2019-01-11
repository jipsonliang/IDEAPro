package com.jipson.mybatis.dao;

import com.jipson.mybatis.domain.User;
import com.jipson.mybatis.util.Util;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class UserDao {
    /**
     * 插入操作
     */
    public void insert(final User user) {

        DaoTemplate.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession s) {
                s.insert("users.insert", user);
                return null;
            }

        });
    }

    /**
     * 更新操作
     */
    public void update(final User user) {
        DaoTemplate.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession s) {
                s.insert("users.update", user);
                return null;
            }
        });

    }

    /**
     * 查询一个操作
     */
    public User selectOne(final Integer id){
        return (User)DaoTemplate.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession s) {
                return s.selectOne("users.selectone", id);//匿名内部类调用的接口常量
            }
        });
    }

    /**
     * 查询所有操作
     */
    public List<User> selectAll(){
        return (List<User>)DaoTemplate.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession s) {
                return s.selectList("users.selectall");//匿名内部类调用的接口常量
            }
        });
    }
}
