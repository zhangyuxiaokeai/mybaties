package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {
    /**
     * 解决字段名和属性名不一致的情况：
     * a->为字段名起别名，保持和属性名一致
     * b->设置全局配置 ，将下划线自动映射为驼峰
     *  <settings>
     *         将下划线自动映射为驼峰 emp_name:empName
     *         <setting name="mapUnderscoreToCamelCase" value="true"/>
     *     </settings>
     * c->通过resultMap设置自定义的映射关系
     *
    *
     *  resultMap id="empResultMap" type="Emp">
     *         <id property="eid" column="eid"></id>
     *         <result property="empName" column="emp_name"></result>
     *         <result property="age" column="age"></result>
     *         <result property="sex" column="sex"></result>
     *         <result property="email" column="email"></result>
     *     </resultMap>
     *
     *
     * 处理多对一的映射关系

     * a->级联属性赋值
     *   处理多对一映射关系方式一：级联属性赋值
     *     <resultMap id="empAndDeptResultMapOne" type="Emp">
     *         <id property="eid" column="eid"></id>
     *         <result property="empName" column="emp_name"></result>
     *         <result property="age" column="age"></result>
     *         <result property="sex" column="sex"></result>
     *         <result property="email" column="email"></result>
     *         <result property="dept.did" column="did"></result>
     *         <result property="dept.deptName" column="dept_name"></result>
     *     </resultMap>
     *
     *
     *  b->处理多对一映射关系方式二
     *          处理多对一映射关系方式二：association属性赋值
     *     <resultMap id="empAndDeptResultMapTwo" type="Emp">
     *         <id property="eid" column="eid"></id>
     *         <result property="empName" column="emp_name"></result>
     *         <result property="age" column="age"></result>
     *         <result property="sex" column="sex"></result>
     *         <result property="email" column="email"></result>
     *
     * association：处理多对一的映射关系
     * property:需要处理多对的映射关系的属性名
     * javaType:改属性的类型
     * -->
     *         <association property="dept" javaType="Dept">
     *             <id property="did" column="did"></id>
     *             <result property="deptName" column="dept_name"></result>
     *         </association>
     *     </resultMap>
     *
     *
     * 处理一对多的映射关系
     *a->collection
     * <resultMap id="deptAndEmpResultMap" type="Dept">
     *         <id property="did" column="did"></id>
     *         <result property="deptName" column="dept_name"></result>
     *         <collection property="emps" ofType="Emp">
     *             <id property="eid" column="eid"></id>
     *             <id property="empName" column="emp_name"></id>
     *             <id property="age" column="age"></id>
     *             <id property="sex" column="sex"></id>
     *             <id property="email" column="email"></id>
     *         </collection>
     *
     *     </resultMap>
     *b->分部查询
     *
     *
     */

    @Test
    public void getGetAllEmp(){
        SqlSession session = SqlSessionUtils.getSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        List<Emp> allEmp = mapper.getAllEmp();
        System.out.println(allEmp);
        }


    @Test
    public void getEmpAndEmpt(){
        SqlSession session = SqlSessionUtils.getSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDept(2);
        System.out.println(empAndDept);
        System.out.println("***********************************");
        System.out.println(empAndDept.getDept());
    }

    @Test
    public void getGetEmpAndDeptByStep(){
        SqlSession session = SqlSessionUtils.getSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDeptByStepOne(3);
        System.out.println(empAndDept.getEmpName());
    }
    @Test
    public void testgetDeptAndEmp(){
        SqlSession session = SqlSessionUtils.getSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmp(1);
        System.out.println(deptAndEmp);
        System.out.println(deptAndEmp.getDeptName());
    }


    @Test
    public void testgetDeptAndEmpByStep(){
        SqlSession session = SqlSessionUtils.getSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmp(1);
        System.out.println(deptAndEmp);
    }
}
