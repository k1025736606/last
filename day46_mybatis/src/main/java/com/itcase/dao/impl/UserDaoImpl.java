package com.itcase.dao.impl;

import com.itcase.dao.UserDao;
import com.itcase.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @创建人 kzp
 * @创建时间
 * @描述
 */
public class UserDaoImpl implements UserDao {
    public void saveUser(User user) {
        try {
            //1 加载mybatis的主配置文件
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            //2 创建 SQLSessionFactory 对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            //3 获取sqlsession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //4 使用sqlSession进行操作
            sqlSession.insert("userMapper.addUser",user);
            //5 提交事务
            sqlSession.commit();
            //释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
