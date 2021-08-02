package com.app.runnables;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

import com.app.beans.User;
import com.app.dao.UserDao;

public class UserProcessor implements Callable<Integer> {
	
	private String userRecord;
	private UserDao dao;
	
	public UserProcessor(String userRecord, UserDao dao) {
		this.userRecord = userRecord;
		this.dao = dao;
	}

	@Override
	public Integer call() throws Exception {
		int rows = 0;
		User user = null;
		
		System.out.println(Thread.currentThread().getName() + " processing record for: " + userRecord);
		
		StringTokenizer tokenizer = new StringTokenizer(userRecord, ",");
		while(tokenizer.hasMoreTokens()) {
			user = new User();
			user.setEmailAddress(tokenizer.nextToken());
			user.setName(tokenizer.nextToken());
			user.setId(Integer.valueOf(tokenizer.nextToken()));
			rows = this.dao.saveUser(user);
		}
		
		return rows;
	}

}
