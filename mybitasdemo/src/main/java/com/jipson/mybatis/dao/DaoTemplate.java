package com.jipson.mybatis.dao;

import com.jipson.mybatis.util.Util;
import org.apache.ibatis.session.SqlSession;

public class DaoTemplate {
    /**
     * 模板执行方法
     */
    public static Object execute(MybatisCallback cb){
        SqlSession s = null;
        try{
            s = Util.openSession();//用工具类的开启会话方法
            //s.insert("users.insert", user);//代码段中，唯一不一样的一句话
            Object ret1 = cb.doInMybatis(s);
            s.commit();//提交事务
            return ret1;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            //出现异常需要回滚事务
            Util.rollBack(s);
        } finally{
            Util.closeSession(s);
        }
        return null;
    }
}
