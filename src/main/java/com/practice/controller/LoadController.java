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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.domain.User;
import com.practice.repository.UserRepository;

@RestController
@RequestMapping("/load")
public class LoadController {

	@Autowired
	private JobLauncher jobLauncher; 
	
	@Autowired
	private Job job;
	
	@Autowired
	private UserRepository userRepository; 
	
	@GetMapping
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		Map<String, JobParameter> maps =  new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters =  new JobParameters(maps);
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		System.out.println(jobExecution.getStatus());
		
		System.out.println("Job Is running...");
		while (jobExecution.isRunning()) {
			System.out.println("...");
			
		}
		
		return jobExecution.getStatus();
	}

	@GetMapping("/All")
	public List<User> fetchAllUsers(){
		return userRepository.findAll();
	}
}
