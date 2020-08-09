package com.atkjs927.dao;

import com.atkjs927.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

public class MyBatisTest {

    @Test
    public void test() throws IOException {
        String resource = "resource/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        Employee employee;
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
            employee = employeeDao.getEmpById(1);
        } finally {
            openSession.close();
        }
        System.out.println(employee);

    }
}
