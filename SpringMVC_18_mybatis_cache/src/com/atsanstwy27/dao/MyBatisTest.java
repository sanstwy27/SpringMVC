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

    /**
     * 一緩（本地緩存）：session 級別的緩存，默認開啟，session關閉則失效；
     * 二緩（全局緩存）：namespace級別的緩存，要手動開啟；
     *
     * @throws IOException
     */
    @Test
    public void testCache01() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);

        try {
            Teacher teacher1 = teacherDao.getTeacherById(1);
            System.out.println(teacher1);
            Teacher teacher2 = teacherDao.getTeacherById(1);
            System.out.println(teacher2);
            System.out.println(teacher1 == teacher2);
        } finally {
            openSession.close();
        }
    }


    /**
     * 一級緩存失效的四種情況
     *  1. sqlsession 不同，不同的session 之間不能共享數據；
     *  2.參數不同的情況；
     *  3.兩次相同的查詢之間有 增刪改 的操作；
     *  4.第二次查詢之前手動清空緩存；
     *
     * @throws IOException
     */
    @Test
    public void testCache02() throws IOException {

        // Session1
        SqlSession openSession1 = sqlSessionFactory.openSession();
        TeacherDao teacherDao1 = openSession1.getMapper(TeacherDao.class);
        Teacher teacher1 = teacherDao1.getTeacherById(1);
        System.out.println(teacher1);

        // Session2
        SqlSession openSession2 = sqlSessionFactory.openSession();
        TeacherDao teacherDao2 = openSession2.getMapper(TeacherDao.class);
        Teacher teacher2 = teacherDao2.getTeacherById(1);
        System.out.println(teacher2);

        System.out.println(teacher1 == teacher2);
        openSession1.close();
        openSession2.close();
    }

    @Test
    public void testCache03() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);

        try {
            Teacher teacher = teacherDao.getTeacherById(1);
            System.out.println(teacher);

            Teacher teacher1 = new Teacher();
            teacher1.setName("12345678");
            teacherDao.updateTeacher(teacher1);

            Teacher teacher2 = teacherDao.getTeacherById(1);
            System.out.println(teacher2);

            openSession.commit();
        } finally {
            openSession.close();
        }
    }


    /**
     * Test CacheEnabled
     *
     * @throws IOException
     */
    @Test
    public void testCache04() throws IOException {

        // Session1
        SqlSession openSession1 = sqlSessionFactory.openSession();
        TeacherDao teacherDao1 = openSession1.getMapper(TeacherDao.class);
        Teacher teacher1 = teacherDao1.getTeacherById(1);
        System.out.println(teacher1);
        openSession1.close();

        // Session2
        SqlSession openSession2 = sqlSessionFactory.openSession();
        TeacherDao teacherDao2 = openSession2.getMapper(TeacherDao.class);
        Teacher teacher2 = teacherDao2.getTeacherById(1);
        System.out.println(teacher2);
        openSession2.close();
    }

    /**
     * 1. 不會出現一級緩存和二級緩存中有同一個數據
     * 2. 關閉session，會把一級緩存放入二級緩存
     * 3. 任何時候都是先看二級緩存
     *
     * @throws IOException
     */
    @Test
    public void testCache05() throws IOException {

        // Session1
        SqlSession openSession1 = sqlSessionFactory.openSession();
        TeacherDao teacherDao1 = openSession1.getMapper(TeacherDao.class);
        Teacher teacher1 = teacherDao1.getTeacherById(1);
        System.out.println(teacher1);
        openSession1.close();

        // Session2
        SqlSession openSession2 = sqlSessionFactory.openSession();
        TeacherDao teacherDao2 = openSession2.getMapper(TeacherDao.class);
        Teacher teacher2 = teacherDao2.getTeacherById(1);
        System.out.println(teacher2);
        Teacher teacher3 = teacherDao2.getTeacherById(1);
        System.out.println(teacher3);

        Teacher teacher4 = teacherDao2.getTeacherById(2);
        System.out.println(teacher4);
        openSession2.close();
    }
}
