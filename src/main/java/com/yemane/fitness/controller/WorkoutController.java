package com.yemane.fitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yemane.fitness.model.Workout;
import com.yemane.fitness.service.WorkoutService;



@Controller
public class WorkoutController {

	@Autowired
	private WorkoutService workoutService;
	
	
	@GetMapping("/workouts")
	public String listWorkouts(Model model) {
		List<Workout> listWorkouts = workoutService.getAllWorkouts();
		model.addAttribute("listWorkouts",listWorkouts);
		return "workouts";
	}
	
	@GetMapping("/workouts/new")
	public String showNewWorkoutForm(Model model) {
		model.addAttribute("workout", new Workout());
		
		return "workout_form";
	}
	
	@PostMapping("/workouts/save")
	public String saveWorkout(Workout workout) {
		workoutService.saveWorkout(workout);
		
		return "redirect:/";
	}
	
	@GetMapping("/workouts/edit/{workoutId}") 
		public String showEditWorkoutForm(@PathVariable("workoutId") Long id, Model model) {
			Workout workout = workoutService.getWorkoutById(id);
			model.addAttribute("workout", workout);
					return "edit_workout";
		}
	@PostMapping("/workouts/{workoutId}")
	public String updateWorkout(@PathVariable("workoutId")Long id, Workout workout, Model model) {
		Workout existingWorkout = workoutService.getWorkoutById(id);
		existingWorkout.setWorkoutId(id);
		existingWorkout.setWorkoutType(workout.getWorkoutType());
		existingWorkout.setPrice(workout.getPrice());
		workoutService.saveWorkout(existingWorkout);
		return "redirect:/";
	}
	@GetMapping("/workouts/{workoutId}")
	public String deleteWorkout(@PathVariable("workoutId")Long id, Model model) {
		workoutService.deleteWorkoutById(id);
		return "redirect:/";
	}
	}


