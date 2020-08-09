package com.atkjs927.crud.dao;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.atkjs927.crud.bean.Department;
import com.atkjs927.crud.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;

	@Autowired
	private DepartmentDao departmentDao;

	static {
		employees = new HashMap<Integer, Employee>();

		employees.put(1001, new Employee(1001, "E-AAAAAA", "aa@163.com", 1, new Date(), new Department(101, "D-AA")));
		employees.put(1002, new Employee(1002, "E-BBBBBB", "bb@163.com", 1, new Date(), new Department(102, "D-BB")));
		employees.put(1003, new Employee(1003, "E-CCCCCC", "cc@163.com", 0, new Date(), new Department(103, "D-CC")));
		employees.put(1004, new Employee(1004, "E-DDDDDD", "dd@163.com", 0, new Date(), new Department(104, "D-DD")));
		employees.put(1005, new Employee(1005, "E-EEEEEE", "ee@163.com", 1, new Date(), new Department(105, "D-EE")));
	}

	private static Integer initId = 1006;

	public void save(Employee employee) {
		if (employee.getId() == null) {
			employee.setId(initId++);
		}

		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}

	public Collection<Employee> getAll() {
		return employees.values();
	}

	public Employee get(Integer id) {
		return employees.get(id);
	}

	public void delete(Integer id) {
		employees.remove(id);
	}
}
