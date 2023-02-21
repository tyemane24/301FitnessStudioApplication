package com.yemane.fitness.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yemane.fitness.model.Workout;

@Service
public interface WorkoutService {

List<Workout> getAllWorkouts();
	
    Workout saveWorkout(Workout workout);
	
	Workout getWorkoutById(Long id);
	
	Workout updateWorkout(Workout workout);
	
	void deleteWorkoutById(Long id);
	
}
