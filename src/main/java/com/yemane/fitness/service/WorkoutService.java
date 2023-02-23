package com.yemane.fitness.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yemane.fitness.model.Workout;

@Service
public interface WorkoutService {

	//Returns list of all records of Workout entity
List<Workout> getAllWorkouts();
	
//Creates and saves record of Workout entity
    Workout saveWorkout(Workout workout);
	
    //Returns record of Workout entity based on its Id
	Workout getWorkoutById(Long id);
	
	//Updates existing record of Workout entity
	Workout updateWorkout(Workout workout);
	
	//Deletes record of Workout entity
	void deleteWorkoutById(Long id);
	
}
