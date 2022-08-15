package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
   /*
   MyBatis面向接口编程的两个一致
   1.映射文件的namespace要和mapper接口的全类名保持一致
   2.映射文件中的sql语句的id要和mapper接口中的方法一致


   表--实体类--mapper接口---映射文件
    */

    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改信息
     */
    void updateUser();
    /**
     * 删除用户
     */
    void  deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 查询所有的信息
     *
     */
    List<User> getAllUser();
}
