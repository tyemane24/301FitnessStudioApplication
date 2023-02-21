package com.yemane.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yemane.fitness.model.WorkoutClass;

@Repository
public interface WorkoutClassRepository extends JpaRepository<WorkoutClass,Long> {

}
