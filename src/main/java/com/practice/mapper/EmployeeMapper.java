package com.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;

import com.practice.domain.Employee;

@Mapper
public interface EmployeeMapper {
	
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "name", column = "name"),
		@Result(property = "emailId", column = "emailId"),
		@Result(property = "salary", column = "salary")
	})
	
	@Insert("INSERT INTO employee(id, name, emailId, salary) VALUES(#{id}, #{name}, #{emailId}, #{salary})")
	public void insertEmployee(Employee employee);
	
	@Select("SELECT id, name, emailId, salary FROM employee WHERE id=#{id}")
	public Employee getEmployeeById(Integer id);
	
	@Select("SELECT id, name, emailId, salary FROM employee")
	public List<Employee> getAllEmployees();
	
	@Update("UPDATE employee SET name=#{name}, emailId =#{emailId}, salary =#{salary} WHERE id =#{id}")
	public void updateEmployee(Employee employee);
	
	@Delete("DELETE FROM employee WHERE id =#{id}")
	public void deleteEmployee(int id);
}
