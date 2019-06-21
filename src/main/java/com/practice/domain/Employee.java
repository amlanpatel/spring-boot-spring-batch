package com.practice.domain;

public class Employee {

	private Integer id;
	private String name;
	private String emailId;
	private Integer salary;

	public Employee() {
	}

	public Employee(Integer id, String name, String emailId, Integer salary) {
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", emailId=" + emailId + "]";
	}

}
