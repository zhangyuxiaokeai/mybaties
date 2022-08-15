package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class selectMapperTest {
    /**
     * Mybatis的各种查询功能
     * 1、
     * a->若查询出的数据只有一条，可以通过实体类对象接受
     * b->可以通过list集合接受
     * c->可以通过map集合
     * 结果：{password=123456, sex=男, id=3, age=23, email=123456@qq.com, username=admin}
     * 2.若查询出的数据有多条，可以通过list集合接受，一定不能通过实体类对象接受，此时会抛出异常
     *      ：TooManyResultsException
     * a->可以通过list集合接受
     *  b->可以通过map集合
     * c->可以通过实体类list集合接收
     * d->可用通过list<map>接受
     * e->可以通过mapper接口的方法上添加@mapkey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值作为键，放在同一个map结合中
     * Mybatis 中设置了默认的类型别名
     * java.lang.Integer--->int ,integer
     * int-->_int,_integer
     * Map->map
     */
    @Test
    public void testGetUserById(){
        SqlSession session = SqlSessionUtils.getSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(3));
    }

    /**
     * 查询所有
     */
    @Test
    public void testgetAllUser(){
        SqlSession session = SqlSessionUtils.getSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }

    /**
     * 查询总记录数
     */
    @Test
    public void testgetUserCount(){
        SqlSession session = SqlSessionUtils.getSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testgetUserByToMap() {
        SqlSession session = SqlSessionUtils.getSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        Map<String, Object> userByToMap = mapper.getUserByToMap(3);
        System.out.println(userByToMap);
    }

    @Test
    public void testgetAllUserToMap() {
        SqlSession session = SqlSessionUtils.getSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        Map<String, Object> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);
    }
    }
