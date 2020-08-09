package com.atkjs927.dao;

import com.atkjs927.bean.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// @Test [-Dlog4j.configurationFile=log4j2.xml]
public class MyBatisTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void initSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSelect01() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);

        try {
            Teacher teacher = teacherDao.getTeacherById(1);
            System.out.println(teacher);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testSelect02() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);

        try {
            Teacher teacher = new Teacher();
            teacher.setId(1);
            teacher.setName("%e%");
            //teacher.setDate(new Date());
            List<Teacher> list = teacherDao.getTeacherByCondition(teacher);
            System.out.println(list);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testSelect03() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);

        try {

            List<Teacher> list = teacherDao.getTeacherByIdIn(Arrays.asList(1, 2, 3, 4, 5));
            System.out.println(list);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testSelect04() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher();
            teacher.setId(1);
            teacher.setName("%e%");
            List<Teacher> list = teacherDao.getTeacherByConditionChoose(teacher);
            System.out.println(list);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testUpdate() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher();
            teacher.setId(1);
            teacher.setName("hahaha");
            teacherDao.updateTeacher(teacher);
            openSession.commit();
        } finally {
            openSession.close();
        }
    }
}
