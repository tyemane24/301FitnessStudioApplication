package com.yemane.fitness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yemane.fitness.model.WorkoutClass;
import com.yemane.fitness.repository.WorkoutClassRepository;

@Service
public class ClassServiceImpl implements ClassService {

	private WorkoutClassRepository class_repo;
	
	public ClassServiceImpl(WorkoutClassRepository class_repo) {
		super();
		this.class_repo = class_repo;
	}
	
	@Override
	public List<WorkoutClass> getAllWorkoutClasses() {
		
		return class_repo.findAll() ;
	}

	@Override
	public WorkoutClass saveWorkoutClass(WorkoutClass workoutClass) {
		
		return class_repo.save(workoutClass);
	}

	@Override
	public WorkoutClass getWorkoutClassById(Long id) {
	
		return class_repo.findById(id).get();
	}

	@Override
	public WorkoutClass updateWorkoutClass(WorkoutClass workoutClass) {
		
		return class_repo.save(workoutClass);
	}

	@Override
	public void deleteWorkoutClassById(Long id) {
		class_repo.deleteById(id);
		
	}

	
	
}
