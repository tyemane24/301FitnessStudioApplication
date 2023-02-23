package com.yemane.fitness.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yemane.fitness.model.WorkoutClass;

@Repository
public interface WorkoutClassRepository extends JpaRepository<WorkoutClass,Long> {

	 
}
