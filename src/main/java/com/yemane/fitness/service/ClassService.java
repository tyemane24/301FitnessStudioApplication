package com.yemane.fitness.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yemane.fitness.model.WorkoutClass;


@Service
public interface ClassService {

List<WorkoutClass> getAllWorkoutClasses();
	
    WorkoutClass saveWorkoutClass(WorkoutClass workoutClass);
	
	WorkoutClass getWorkoutClassById(Long id);
	
	WorkoutClass updateWorkoutClass(WorkoutClass workoutClass);
	
	void deleteWorkoutClassById(Long id);
}
