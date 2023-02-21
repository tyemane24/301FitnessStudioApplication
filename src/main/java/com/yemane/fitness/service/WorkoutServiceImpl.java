package com.yemane.fitness.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yemane.fitness.model.Workout;
import com.yemane.fitness.repository.WorkoutRepository;

@Service
public class WorkoutServiceImpl implements WorkoutService {

	private WorkoutRepository workout_repo;
	
	public WorkoutServiceImpl(WorkoutRepository workout_repo) {
		super();
		this.workout_repo = workout_repo;
	}

	@Override
	public List<Workout> getAllWorkouts() {
		
		return workout_repo.findAll();
	}

	@Override
	public Workout saveWorkout(Workout workout) {
		
		return workout_repo.save(workout);
	}

	@Override
	public Workout getWorkoutById(Long id) {
		
		return workout_repo.findById(id).get();
	}

	@Override
	public Workout updateWorkout(Workout workout) {
	
		return workout_repo.save(workout);
	}

	@Override
	public void deleteWorkoutById(Long id) {
		workout_repo.deleteById(id);
		
	}
	
	

	
	
}
