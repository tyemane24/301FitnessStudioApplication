package com.yemane.fitness.service;



import com.yemane.fitness.model.User;


public interface UserService {

	 User createUser(String email, String password); 
	 
		boolean existsByEmail(String email);
}
