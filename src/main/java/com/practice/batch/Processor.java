package com.practice.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.practice.domain.Employee;

@Component
public class Processor implements ItemProcessor<Employee, Employee>{
	
	public static final Map<String, String> DEPT_NAMES = new HashMap<>();
	
	@Override
	public Employee process(Employee employee) throws Exception {
		System.out.println(employee);
		employee.setEmailId(employee.getName()+"@gmail.com");
		System.out.println("After Processing \n" + employee);
		System.out.println("===========================================");
		return employee;
	}

}
