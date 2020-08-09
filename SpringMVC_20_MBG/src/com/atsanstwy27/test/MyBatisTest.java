package com.atkjs927.test;


import com.atkjs927.bean.Teacher;
import com.atkjs927.bean.TeacherExample;
import com.atkjs927.dao.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MyBatisTest {

    // 工廠一個
    SqlSessionFactory sqlSessionFactory;

    @Test
    public void test02(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //1、測試
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = new ArrayList<Teacher>();
        for (int i = 0; i < 1000; i++) {
            Teacher teacher = new Teacher();
            teacher.setTeachername(UUID.randomUUID().toString().substring(0, 5));
            teacher.setClassName(UUID.randomUUID().toString().substring(0, 5));
            teachers.add(teacher);
        }
        System.out.println("批量保存.....");
        mapper.insertBatch(teachers);
        sqlSession.commit();
        sqlSession.close();


    }

    /**
     * 測試代碼生成器
     * @throws IOException
     */
    @Test
    public void test01(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //1、測試
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        //2、測試查詢所有teacher
        List<Teacher> list = mapper.selectByExample(null);
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }

        //3、帶複雜條件的查詢
        //select * from t_teacher id=? and teacherName like ?
        //封裝查詢條件的
        TeacherExample example = new TeacherExample();
        example.setOrderByClause("id DESC");
        //1、使用example創建一個Criteria（查詢準則）
        TeacherExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(1);
        criteria.andTeachernameLike("%a%");

        System.out.println("======================");
        List<Teacher> list2 = mapper.selectByExample(example);
        for (Teacher teacher : list2) {
            System.out.println(teacher);
        }

        /**
         * 多個複雜條件
         * select * from t_teacher where  (id=? and teacherName like ?) or (address like ? and birth bet)
         */
        TeacherExample example2 = new TeacherExample();


        //一個Criteria能封裝一整個條件
        TeacherExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andIdGreaterThan(1);
        criteria2.andTeachernameLike("%a%");

        //創建第二個查詢條件
        TeacherExample.Criteria criteria3 = example2.createCriteria();
        criteria3.andAddressLike("%%");
        criteria3.andBirthDateBetween(new Date(), new Date());

        example2.or(criteria3);
        System.out.println("=======-=-=-=-=-=-=-");
        System.out.println(mapper.selectByExample(example2));

    }


    @Before
    public void initSqlSessionFactory() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

}
