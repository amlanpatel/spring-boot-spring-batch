package com.practice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.domain.Employee;
import com.practice.mapper.EmployeeMapper;

@Repository("EmployeeDaoH2")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeMapper.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeMapper.getAllEmployees();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeMapper.insertEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeMapper.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeMapper.deleteEmployee(id);
	}

}
