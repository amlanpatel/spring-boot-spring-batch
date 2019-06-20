package com.practice.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.domain.User;
import com.practice.repository.UserRepository;

@Component
public class DBWriter implements ItemWriter<User>{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void write(List<? extends User> users) throws Exception {
		System.out.println("Data is going to save for users :" + users);
		userRepository.saveAll(users);
	}

}
