package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {


    /**
     * 动态sql
     * if
     * 1.if:根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到sql中
     *where
     * 2.当where标签中有内容时，会自动生成where关键字，并将内容前多余的and 或者or去掉
     * 当where标签中没有内容时，此时where标签将没有任何效果
     * 注意：where不能将其中内容后面多余的and或or去掉
     *
     * 3.trim:
     * 若标签中内容时：
     *      prefix,suffix:将trim标签中内容前面或后面添加指定内容
     *      prefixOverrides， suffixOverrides：将trim标签中内容前面或后面去掉指定内容
     *若标签中没有内容时，trim标签也没有任何效果
     *
     *
     * 4.choose ,when,otherwise,相当于if...else if else
     *when至少要有一个，otherwise最多只能有一个
     *
     *
     * 5.foreach
     * collection:设置需要循环的数组或集合
     * item:表示数组或集合中的每一个数据
     * separator:循环体之间的分隔符
     * open:foreach标签所述循环的内容的开始符
     * close:foreach标签所述循环的内容的结束符
     *
     * 6.sql
     * 设置sql片段；
     *  <sql id="empColumns">eid,emp_name,age,sex,email</sql>
     *   引用sql片段：
     *   select <include refid="empColumns"></include> from t_emp
     */
    @Test
    public void testinsertMoreByList(){
        SqlSession session = SqlSessionUtils.getSession();
        DynamicSQLMapper mapper = session.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "a1", 23, "男", "13@qq.com");
        Emp emp2 = new Emp(null, "a2", 23, "男", "13@qq.com");
        Emp emp3 = new Emp(null, "a3", 23, "男", "13@qq.com");
        Emp emp4 = new Emp(null, "a4", 23, "男", "13@qq.com");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3, emp4);
        System.out.println(mapper.insertMoreByList(emps));
    }


    @Test
    public void testdeleteMoreByArray(){
        SqlSession session = SqlSessionUtils.getSession();
        DynamicSQLMapper mapper = session.getMapper(DynamicSQLMapper.class);
        int i = mapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println(i);
    }


    @Test
    public void testGetEmpByCondition(){
        SqlSession session = SqlSessionUtils.getSession();
        DynamicSQLMapper mapper = session.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "张三", 23, "", "123@qq.com"));
        System.out.println(list);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession session = SqlSessionUtils.getSession();
        DynamicSQLMapper mapper = session.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, "", null, "", ""));
        System.out.println(list);
    }
}
