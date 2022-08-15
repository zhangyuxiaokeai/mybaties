package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {

    /**
     * mybatis获取参数的两种方式： ${} ,#{}
     * ${}:本质是字符串拼接
     * #{}本质是占位符赋值
     * <p>
     * mybatis获取参数值的各种情况：
     * 1.mapper接口方法的参数个数为单个的字面量类型
     * 可以通过${}，#{}以任意的字符串获取参数值，但是需要主要${}的单引号问题
     * 2.mapper接口方法的参数为多个参数值时
     * 此时Mybatis会将这些参数放在一个map集合中，以两种方式进行存储
     * 此时只需要通过#{} 和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 3.若mapper接口的方式的参数有多个时，可以手动讲这些参数放在map中存储
     * 4.如果mapper的接口方法的参数是实体类类型的参数
     * 只需要通过#{}和#{}以属性的方式访问属性即可，但是需要注意￥{}的单引号问题
     * 5.命名参数 @Param注解命名参数
     * 此时Mybatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a->以@param注解为键，一参数为值
     * b->以param1,param2。。为键，以参数为值
     * 可以通过${}，#{}以任意的字符串获取参数值，但是需要主要${}的单引号问题
     */


    @Test
    public void testGetAllUser() {
        SqlSession session = SqlSessionUtils.getSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        List<User> allUser = mapper.getAllUser();
        for (int i = 0; i < allUser.size(); i++) {
            System.out.println(allUser.get(i));
        }
    }


    @Test
    public void testUserByUserName() {
        SqlSession session = SqlSessionUtils.getSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        User userByUsername = mapper.getUserByUsername("admin");
        System.out.println(userByUsername);
    }


    @Test
    public void testChcekLogin() {
        SqlSession session = SqlSessionUtils.getSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        User admin = mapper.checkLogin("admin", "123456");
        System.out.println(admin.toString());
    }

    @Test
    public void testCheckLoginByMap() {
        SqlSession session = SqlSessionUtils.getSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
    }


    @Test
    public void testInsertUser() {
        SqlSession session = SqlSessionUtils.getSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        User user = new User(null, "周欢", "123456", 23, "女", "132");
        int i = mapper.insertUser(user);
        System.out.println(i);
    }

    @Test
    public void testcheckLoginByParam() {
        SqlSession session = SqlSessionUtils.getSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        User admin = mapper.checkLoginByParam("admin", "123456");
        System.out.println(admin.toString());
    }
}