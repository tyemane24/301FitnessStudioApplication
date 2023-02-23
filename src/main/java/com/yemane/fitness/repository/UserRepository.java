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
	
	  @Query(value = "SELECT u.user_id, uc.class_id FROM user u JOIN user_classes uc ON u.user_id = uc.user_id  JOIN workout_class wc ON wc.class_id = uc.class_id; ", nativeQuery = true)
	  List<Object> getUserIdAndClassId();
	
	

	
	
	
	}

