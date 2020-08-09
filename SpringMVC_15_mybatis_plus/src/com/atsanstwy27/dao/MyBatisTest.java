package com.atkjs927.dao;

import com.atkjs927.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

// @Test [-Dlog4j.configurationFile=resource/conf/log4j2.xml]
public class MyBatisTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void initSqlSessionFactory() throws IOException {
        String resource = "resource/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testInsert() {
        //SqlSession openSession = sqlSessionFactory.openSession();
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
            int i = employeeDao.insertEmployee(new Employee(null, "tomcat", 0, "tomcat@tomcat.com", "tomcat"));
            System.out.println(i);
        } finally {
            //openSession.commit();
            openSession.close();
        }
    }


    @Test
    public void testSelect() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);

        try {
            Employee employee = employeeDao.getEmpById(1);
            System.out.println(employee);
        } finally {
            openSession.close();
        }

    }


    @Test
    public void testAnnotation() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDaoAnnotation employeeDaoAnnotation = openSession.getMapper(EmployeeDaoAnnotation.class);

        try {
            Employee employee = employeeDaoAnnotation.getEmpById(1);
            System.out.println(employee);
        } finally {
            openSession.close();
        }

    }
}
