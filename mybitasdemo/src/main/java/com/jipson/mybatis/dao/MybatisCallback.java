package com.jipson.mybatis.dao;

import org.apache.ibatis.session.SqlSession;

/**
 * 模板类
 * 把绝大多数代码相同，只有一句话不同的代码段，编写成模板类
 */
public interface MybatisCallback {

    public abstract Object doInMybatis(SqlSession s);

}
