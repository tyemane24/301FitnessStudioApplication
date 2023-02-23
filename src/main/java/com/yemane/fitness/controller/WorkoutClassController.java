package com.yemane.fitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yemane.fitness.model.WorkoutClass;
import com.yemane.fitness.model.Workout;
import com.yemane.fitness.service.ClassService;
import com.yemane.fitness.service.WorkoutService;

//Handles web requests mapped to Java functions involving WorkoutClass entity and associated static HTML web pages 

@Controller
public class WorkoutClassController {

	@Autowired
	public ClassService classService;

	@Autowired
	private WorkoutService workoutService;

	// Returns all classes existing in database in admin view (with admin
	// functionality options)
	@GetMapping("/classes")
	public String listClasses(Model model) {
		List<WorkoutClass> listClasses = classService.getAllWorkoutClasses();
		model.addAttribute("listClasses", listClasses);
		return "classes";
	}

	// Returns all classes existing in database in user view
	@GetMapping("/user-view-classes")
	public String userViewClasses(Model model) {
		List<WorkoutClass> listClasses = classService.getAllWorkoutClasses();
		model.addAttribute("listClasses", listClasses);
		return "userviewclass";
	}

	// Returns form to add new class (admin only)
	@GetMapping("/classes/new")
	public String showNewClassorm(Model model) {

		List<Workout> listWorkouts = workoutService.getAllWorkouts();
		model.addAttribute("class", new WorkoutClass());
		model.addAttribute("listWorkouts", listWorkouts);

		return "class_form";

	}

	// Saves new class to database after form submission
	@PostMapping("/classes/save")

	public String saveWorkoutClass(@ModelAttribute("class") WorkoutClass workoutClass) {

		classService.saveWorkoutClass(workoutClass);

		return "redirect:/classes";
	}

//Deletes class record
	@GetMapping("/classes/{classId}")
	public String deleteClass(@PathVariable("classId") Long id, Model model) {
		classService.deleteWorkoutClassById(id);
		return "redirect:/classes";
	}

}
