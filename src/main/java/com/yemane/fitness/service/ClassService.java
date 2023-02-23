package com.yemane.fitness.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yemane.fitness.model.WorkoutClass;


@Service
public interface ClassService {

List<WorkoutClass> getAllWorkoutClasses();
	
//Saves record of WorkoutClass entity
    WorkoutClass saveWorkoutClass(WorkoutClass workoutClass);
	
    //Returns record of WorkoutClass entity based on its Id
	WorkoutClass getWorkoutClassById(Long id);
	
	//Updates record of existing WorkoutClass entity
	WorkoutClass updateWorkoutClass(WorkoutClass workoutClass);
	
	//Deletes record of WorkoutClass entity
	void deleteWorkoutClassById(Long id);
}
