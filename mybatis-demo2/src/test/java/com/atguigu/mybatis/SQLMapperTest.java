package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.SQLMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SQLMapperTest {
    @Test
    public void testGetUserByLike(){
        SqlSession session = SqlSessionUtils.getSession();
        SQLMapper mapper = session.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        System.out.println(list);
    }

    @Test
    public void testdeleteMore(){
        SqlSession session = SqlSessionUtils.getSession();
        SQLMapper mapper = session.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("1,2,3");
        System.out.println(result);
    }
    @Test
    public void testgetUserByTableName(){
        SqlSession session = SqlSessionUtils.getSession();
        SQLMapper mapper = session.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByTableName("t_user");
        System.out.println(list);
    }

    @Test
    public void testinsertUser(){
        SqlSession session = SqlSessionUtils.getSession();
        SQLMapper mapper = session.getMapper(SQLMapper.class);
        User user = new User(null, "王五", "123", 23, "男", "123@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
