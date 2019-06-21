package com.practice.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.practice.dao.EmployeeDao;
import com.practice.domain.Employee;

@Component
public class DBWriter implements ItemWriter<Employee>{

	private EmployeeDao employeeDao;
	
	@Autowired
	public DBWriter(BeanFactory beanFactory, Environment environment) {
		employeeDao = (EmployeeDao) beanFactory.getBean(environment.getProperty("custom.dao.implementation"));
	}

	@Override
	public void write(List<? extends Employee> employees) throws Exception {
		System.out.println("Data is going to save for employees :" + employees);
		for(Employee employee : employees) {
			employeeDao.saveEmployee(employee);
		}
	}

}
