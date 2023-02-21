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



@Controller
public class WorkoutClassController {

	@Autowired
	public ClassService classService;
	
	@Autowired
	private WorkoutService workoutService;
	
	@GetMapping("/classes")
	public String listClasses(Model model) {
		List<WorkoutClass> listClasses = classService.getAllWorkoutClasses();
		model.addAttribute("listClasses", listClasses);
		return "classes";
	}
	

	@GetMapping("/classes/new")
	public String showNewClassorm(Model model) {
		
		List<Workout> listWorkouts = workoutService.getAllWorkouts();
		model.addAttribute("class", new WorkoutClass());		
		model.addAttribute("listWorkouts", listWorkouts);
		
		return "class_form";
		
	}
	
	
	@PostMapping("/classes/save")
	
	public String saveWorkoutClass(@ModelAttribute("class")WorkoutClass workoutClass) {
		
		classService.saveWorkoutClass(workoutClass);
		
		return "redirect:/";	
	}
	

@GetMapping("/classes/{classId}")
public String deleteClass(@PathVariable("classId")Long id, Model model) {
	classService.deleteWorkoutClassById(id);
	return "redirect:/";
}
	
	
	
}
