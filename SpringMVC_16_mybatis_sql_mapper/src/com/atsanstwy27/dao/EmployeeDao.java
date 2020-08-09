package com.atkjs927.dao;

import com.atkjs927.bean.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {

    public Employee getEmpById(Integer id);
    public int updateEmployee(Employee employee);
    public boolean deleteEmployee(Integer id);
    public int insertEmployee(Employee employee);

    // By SQL Mapper
    public Employee getEmpByIdAndEmpName(Integer id, String empName);
    public Employee getEmpByIdAndEmpName2(Map<String, Object> map);
    public Employee getEmpByIdAndEmpName3(Map<String, Object> map);
    public List<Employee> getAllEmps();
    public Map<String, Object> getEmpByIdReturnMap(Integer id);
    @MapKey("id")
    public Map<Integer, Employee> getAllEmpsReturnMap();
    public int insertEmployee2(Employee employee);
}
