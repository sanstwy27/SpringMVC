package com.atkjs927.crud.component;


import com.atkjs927.crud.dao.DepartmentDao;
import com.atkjs927.crud.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/*
 * 將String轉換Employee
 */
public class MyStringToEmployeeConverter implements Converter<String, Employee> {

    @Autowired
    DepartmentDao dao;
    /*
     * 自定義轉換規則
     */
    @Override
    public Employee convert(String source) {
        System.out.println("頁面提交的將要轉換的字符串："+source);
        Employee employee=new Employee();
        if(source.contains("%")){
            String[] split=source.split("%");
            employee.setLastName(split[0]);
            employee.setEmail(split[1]);
            employee.setGender(Integer.parseInt(split[2]));
            employee.setDepartment(dao.getDepartment(Integer.parseInt(split[3])));
        }
        return employee;
    }

}