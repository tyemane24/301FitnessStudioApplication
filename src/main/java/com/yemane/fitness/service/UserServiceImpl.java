package com.yemane.fitness.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yemane.fitness.model.User;
import com.yemane.fitness.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	private UserRepository user_repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User createUser(String email, String password) {
		User user = new User();
	    user.setEmail(email);
	    user.setPassword(passwordEncoder.encode(password));
	    user_repo.save(user);
	    return user;
	}

	

	@Override
	public boolean existsByEmail(String email) {
		 return user_repo.existsByEmail(email);
	}

	
	
}
