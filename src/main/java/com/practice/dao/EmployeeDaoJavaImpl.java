package com.practice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.practice.domain.Employee;

@Repository("EmployeeDaoJava")
public class EmployeeDaoJavaImpl implements EmployeeDao {
	
	private static List<Employee> employees = new ArrayList<>();
	static {
		employees.add(new Employee(1,"Amlan","amlan@gmail.com", 100));
		employees.add(new Employee(2, "Kumar", "kumar@gmail.com", 200));
		employees.add(new Employee(3, "Patel", "patel@gmail.com", 300));
	}
	
	@Override
	public Employee getEmployeeById(Integer id) {
		return employees.stream().filter(employee -> employee.getId().equals(id)).findAny().orElse(null);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employees;
	}

	@Override
	public void saveEmployee(Employee employee) {
		System.out.println(employees.size());
		employee.setId(employees.size()+1);
		employees.add(employee);
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		Employee temp = employees.stream().filter(emp -> emp.getId().equals(employee.getId())).findAny().orElse(null);
		if(temp != null) {
			employees.remove(temp);
			employees.add(employee);
		}
	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee temp = employees.stream().filter(emp -> emp.getId().equals(id)).findAny().orElse(null);
		employees.remove(temp);
	}

}
