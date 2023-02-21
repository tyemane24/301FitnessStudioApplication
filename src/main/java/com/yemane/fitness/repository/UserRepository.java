package com.yemane.fitness.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yemane.fitness.model.User;
import com.yemane.fitness.model.WorkoutClass;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
  
	
	
	User findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	}

