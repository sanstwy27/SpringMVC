package com.atkjs927.dao;

import com.atkjs927.bean.Employee;

public interface EmployeeDao {

    public Employee getEmpById(Integer id);
    public int updateEmployee(Employee employee);
    public boolean deleteEmployee(Integer id);
    public int insertEmployee(Employee employee);
}
