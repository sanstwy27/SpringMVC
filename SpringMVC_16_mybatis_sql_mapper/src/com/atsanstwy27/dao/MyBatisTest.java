package com.atkjs927.dao;

import com.atkjs927.bean.Cat;
import com.atkjs927.bean.Employee;
import com.atkjs927.bean.Key;
import com.atkjs927.bean.Lock;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Test [-Dlog4j.configurationFile=resource/conf/log4j2.xml]
public class MyBatisTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void initSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testInsert01() {
        //SqlSession openSession = sqlSessionFactory.openSession();
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee(null, "tomcat", 0, "tomcat@tomcat.com", "tomcat");
            int i = employeeDao.insertEmployee(employee);
            System.out.println(i);
            System.out.println("剛才插入的id: " + employee.getId());
        } finally {
            //openSession.commit();
            openSession.close();
        }
    }

    @Test
    public void testInsert02() {
        //SqlSession openSession = sqlSessionFactory.openSession();
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee(null, "tomcat", 0, "tomcat@tomcat.com", "tomcat");
            int i = employeeDao.insertEmployee2(employee);
            System.out.println(i);
            System.out.println("剛才插入的id: " + employee.getId());
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
    public void testSelect02() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);

        try {
            Employee employee = employeeDao.getEmpByIdAndEmpName(1, "admin");
            System.out.println(employee);
        } finally {
            openSession.close();
        }

    }

    @Test
    public void testSelect03() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", 1);
            map.put("empName", "admin");
            Employee employee = employeeDao.getEmpByIdAndEmpName2(map);
            System.out.println(employee);
        } finally {
            openSession.close();
        }

    }

    @Test
    public void testSelect04() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", 1);
            map.put("empName", "admin");
            map.put("tablename", "t_employee");
            Employee employee = employeeDao.getEmpByIdAndEmpName3(map);
            System.out.println(employee);
        } finally {
            openSession.close();
        }

    }


    @Test
    public void testSelect05() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);

        try {
            List<Employee> allEmps = employeeDao.getAllEmps();
            for(Employee employee : allEmps) {
                System.out.println(employee);
            }
        } finally {
            openSession.close();
        }

    }


    @Test
    public void testSelect06() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);

        try {
            Map<String, Object> map = employeeDao.getEmpByIdReturnMap(1);
            System.out.println(map);
        } finally {
            openSession.close();
        }

    }


    @Test
    public void testSelect07() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);

        try {
            Map<Integer, Employee> map = employeeDao.getAllEmpsReturnMap();
            System.out.println(map);
            System.out.println(map.get(1));
        } finally {
            openSession.close();
        }

    }


    /*
     * 測試t_cat表，當數據庫列名與bean中的cat.java字段不對應時該如何做
     * 默認MyBatis自動封裝結果集；
     * 1.按照列名和屬性名一一對應的規則且不區分大小寫
     * 2.如果不一一對應
     * 		１，開啟駝峰命名法（滿足駝峰命名規則數據庫中是aaa_bbb,bean中是aaaBbb）
     * 		２，起別名，寫sql語句時，由於數據庫不區分大小寫cName和cname是一樣
     * 			select id,cname name,cAge age,cgender gender from t_cat where id=#{id}
     *3.使用resultMap自定義結果集
     */
    @Test
    public void testSelect08() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        CatDao catDao = openSession.getMapper(CatDao.class);

        try {
            Cat cat = catDao.getCatById(1);
            System.out.println(cat);
        } finally {
            openSession.close();
        }

    }


    /**
     * CASE -- SELECT JOIN
     * @throws IOException
     */
    @Test
    public void testAssociation01() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            KeyDao keyDao = openSession.getMapper(KeyDao.class);
            Key key = keyDao.getKeyById(2);
            System.out.println(key);
        } finally {
            openSession.close();
        }

    }


    @Test
    public void testAssociation02() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            LockDao LockDao = openSession.getMapper(LockDao.class);
            Lock lock = LockDao.getLockById(2);
            System.out.println(lock);
        } finally {
            openSession.close();
        }

    }


    /**
     * CASE -- SELECT JOIN -- Simple
     * @throws IOException
     */
    @Test
    public void testSimple01() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            KeyDao keyDao = openSession.getMapper(KeyDao.class);
            Key key = keyDao.getKeyByIdSimple(1);
            System.out.println(key);
        } finally {
            openSession.close();
        }

    }


    // lazyLoadingEnabled
    @Test
    public void testSimple02() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            KeyDao keyDao = openSession.getMapper(KeyDao.class);
            Key key = keyDao.getKeyByIdSimple(1);
            System.out.println(key.getKeyName());
        } finally {
            openSession.close();
        }

    }


    // SELECT By Step
    @Test
    public void testSimple03() throws IOException {

        //initSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            LockDao lockDao = openSession.getMapper(LockDao.class);
            Lock lock = lockDao.getLockByIdByStep(1);
            System.out.println("LockName: " + lock.getLockName());
            System.out.println(lock.getKeys());
        } finally {
            openSession.close();
        }

    }

}
