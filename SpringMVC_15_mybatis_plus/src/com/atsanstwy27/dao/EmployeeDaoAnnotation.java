package com.atkjs927.dao;


import com.atkjs927.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeDaoAnnotation {

    @Select("select * from t_employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Update("update t_employee" +
            "        set empname=#{empName}, gender=#{gender}, email=#{email}" +
            "        where id=#{id}")
    public int updateEmployee(Employee employee);

    @Delete("delete from t_employee where id=#{id}")
    public boolean deleteEmployee(Integer id);

    @Insert("insert into t_employee(empname, gender, email)" +
            "        values(#{empName}, #{gender}, #{email})")
    public int insertEmployee(Employee employee);

}
