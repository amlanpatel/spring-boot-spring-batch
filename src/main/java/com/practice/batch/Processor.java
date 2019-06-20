package com.practice.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.practice.domain.User;

@Component
public class Processor implements ItemProcessor<User, User>{
	
	public static final Map<String, String> DEPT_NAMES = new HashMap<>();
	
	
	public Processor() {
		DEPT_NAMES.put("001", "Technology");
		DEPT_NAMES.put("002", "OPerations");
		DEPT_NAMES.put("003", "Accounts");
	}

	@Override
	public User process(User item) throws Exception {
		System.out.println(item);
		item.setDept(DEPT_NAMES.get(item.getDept()));
		System.out.println("After Processed \n"+item);
		return item;
	}

}
