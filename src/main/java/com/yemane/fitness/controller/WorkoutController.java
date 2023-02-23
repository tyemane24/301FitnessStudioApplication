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

//Handles web requests mapped to Java functions involving Workout entity and associated static HTML web pages 

@Controller
public class WorkoutController {

	@Autowired
	private WorkoutService workoutService;

	// Returns list of all existing records in Workout entity in admin view
	@GetMapping("/workouts")
	public String listWorkouts(Model model) {
		List<Workout> listWorkouts = workoutService.getAllWorkouts();
		model.addAttribute("listWorkouts", listWorkouts);
		return "workouts";
	}

	// Returns list of all existing records in Workout entity in user view
	@GetMapping("/user-workouts")
	public String listUserWorkouts(Model model) {
		List<Workout> listWorkouts = workoutService.getAllWorkouts();
		model.addAttribute("listWorkouts", listWorkouts);
		return "user_workouts";
	}

	// Returns form to create new record of Workout entity
	@GetMapping("/workouts/new")
	public String showNewWorkoutForm(Model model) {
		model.addAttribute("workout", new Workout());

		return "workout_form";
	}

	// Saves new record of Workout entity when form submitted
	@PostMapping("/workouts/save")
	public String saveWorkout(Workout workout) {
		workoutService.saveWorkout(workout);

		return "redirect:/workouts";
	}

	// Returns form to edit record of Workout entity
	@GetMapping("/workouts/edit/{workoutId}")
	public String showEditWorkoutForm(@PathVariable("workoutId") Long id, Model model) {
		Workout workout = workoutService.getWorkoutById(id);
		model.addAttribute("workout", workout);
		return "edit_workout";
	}

	// Saves changes to record of Workout entity when edit form is submitted
	@PostMapping("/workouts/{workoutId}")
	public String updateWorkout(@PathVariable("workoutId") Long id, Workout workout, Model model) {
		Workout existingWorkout = workoutService.getWorkoutById(id);
		existingWorkout.setWorkoutId(id);
		existingWorkout.setWorkoutType(workout.getWorkoutType());
		existingWorkout.setPrice(workout.getPrice());
		workoutService.saveWorkout(existingWorkout);
		return "redirect:/workouts";
	}

	// Deletes record of Workout entity
	@GetMapping("/workouts/{workoutId}")
	public String deleteWorkout(@PathVariable("workoutId") Long id, Model model) {
		workoutService.deleteWorkoutById(id);
		return "redirect:/workouts";
	}
}
