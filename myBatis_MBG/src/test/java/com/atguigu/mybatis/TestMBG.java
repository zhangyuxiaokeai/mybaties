package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMBG {
    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
//            List<Emp> emps = mapper.selectByExample(null);
//            for (int i = 0; i < emps.size(); i++) {
//                System.out.println(emps.get(i));
//            }
            //根据条件查修
//            EmpExample empExample = new EmpExample();
//            empExample.createCriteria().andEmpNameEqualTo("张三");
//            List<Emp> emps = mapper.selectByExample(empExample);
//                        for (int i = 0; i < emps.size(); i++) {
//                System.out.println(emps.get(i));
//            }
            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",22,null,"123@sd",3));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
