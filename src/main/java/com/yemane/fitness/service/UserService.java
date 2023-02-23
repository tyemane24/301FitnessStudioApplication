package com.yemane.fitness.service;



import java.util.List;

import com.yemane.fitness.model.User;


public interface UserService {

	//Creates record of user entity
	 User createUser(String email, String password); 
	 
	 //Returns all user records that exist in database
		List<User> getAllExistingUsers();
		
		//Returns User record based on their userId
		User findByUserId(Long userId);
		
}
