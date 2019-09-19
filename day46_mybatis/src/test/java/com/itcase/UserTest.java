package com.itcase;

import com.itcase.dao.UserDao;
import com.itcase.dao.impl.UserDaoImpl;
import com.itcase.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @创建人 kzp
 * @创建时间
 * @描述
 */
public class UserTest {

    /**
     * 向数据库Users表中添加一条记录
     * step1：设计POJO实体类
     * step2：建立数据库及表结构
     * step3：编写映射文件（ORM）
     * step4:将映射文件注册到mybatis的主配置文件中
     * step5：利用mybatis提供的类进行插入操作
     */
    @Test
    public void Test00() {
        try {
            //准备数据
            User user = new User();
            user.setName("王吉吉");
            user.setGender("女");
            //利用mybatis的API进行操作：
            //1、 加载mybatis的主配置文件
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            //2、 创建sqlSessionFactory 对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            //3、 获取sqlsession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //4、 使用sqlsession进行操作
            /**
             * insert 参数：
             *          string : 语句的id
             *          Object: 操作的数据
             */
            sqlSession.insert("userMapper.addUser",user);
            //5、提交事务（mybatis中 事务 默认是手动 提交的）
            sqlSession.commit();
            //6、 释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  基于编写dao实现类的方式使用mybatis
     * step1：基于上一个例子拷贝建立一个新的模块
     * step2：编写一个Dao接口
     *  step3：编写dao的实现
     *  step4：编写测试方法
     *
     */

    @Test
    public void Test02(){
        //准备数据
        User user = new User();
        user.setName("王zhe");
        user.setGender("男");
        UserDao userDao = new UserDaoImpl();
        userDao.saveUser(user);
    }


}
