package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageHelperTest {

    /**
     *Limit index, pageSize
     * index:当前页的起始索引
     * pageSize:每页显示的条数
     *pageNum：当前页的页码
     * index=(pageName-1)*pageSize
     *
     * 使用Mybatis的分页插件实现分页的功能：
     * 1.需要在查询功能之前开启分页
     * PageHelper.startPage(int pageNum,int pageSize);
     * 2.再查询功能之后获取分页相关信息
     *  PageInfo<Emp> pageInfo = new PageInfo(emps, 5);
     *  emps表示当前分页的数据
     *  5表示当前啊导航分页的数量
     */
    @Test
    public void testPageHelper(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            PageHelper.startPage(1,4);
            List<Emp> emps = mapper.selectByExample(null);
            PageInfo<Emp> pageInfo = new PageInfo(emps, 5);
            emps.forEach(emp -> System.out.println(emp));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
