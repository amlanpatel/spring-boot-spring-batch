package com.practice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.domain.Employee;
import com.practice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private JobLauncher jobLauncher; 
	
	@Autowired
	private Job job;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/load")
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		Map<String, JobParameter> maps =  new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters =  new JobParameters(maps);
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		
		System.out.println("Job Is running...");

		while (jobExecution.isRunning()) {
			System.out.println("...");
		}
		
		System.out.println(jobExecution.getStatus());
		
		return jobExecution.getStatus();
	}

	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping(value = "/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/saveEmployee")
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
	}
	
	@PutMapping("/updateEmployee")
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
	}
}
