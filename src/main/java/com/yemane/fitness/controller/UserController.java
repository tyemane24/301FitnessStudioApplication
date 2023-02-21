package com.yemane.fitness.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yemane.fitness.model.User;
import com.yemane.fitness.model.UserClass;
import com.yemane.fitness.model.WorkoutClass;
import com.yemane.fitness.model.exceptions.UserClassRegistrationException;
import com.yemane.fitness.model.exceptions.UserRegistrationException;
import com.yemane.fitness.repository.UserRepository;
import com.yemane.fitness.repository.WorkoutClassRepository;
import com.yemane.fitness.service.ClassService;
import com.yemane.fitness.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private WorkoutClassRepository class_repo;
	
	private UserService userService;
	
	private ClassService classService;
	

	@GetMapping("/user-classes")
	public String getAllUserClasses(Model model, Principal principal) {

		String email = principal.getName();
		User user = userRepository.findByEmail(email);

		Set<WorkoutClass> workoutClasses = user.getWorkoutClasses();

		model.addAttribute("workoutClasses", workoutClasses);

		return "user_classes";
	}

	@GetMapping("/sign-up/{classId}/")
	public String register(@PathVariable Long classId, Principal principal) throws UserClassRegistrationException {
	    String email = principal.getName();
	    User user = userRepository.findByEmail(email);
	    WorkoutClass workoutClass = classService.getWorkoutClassById(classId);

	    if (user.getWorkoutClasses().contains(workoutClass)) {
	        throw new UserClassRegistrationException("You are already registered for this class.");
	    }

	    user.getWorkoutClasses().add(workoutClass);
	    userRepository.save(user);

	    return "redirect:/classes";
	}
	@GetMapping("/register")
	public String registerForm(Model model) {
	    model.addAttribute("user", new User());
	    return "register_user";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute User user) throws UserRegistrationException {
	    if (userService.existsByEmail(user.getEmail())) {
	        throw new UserRegistrationException("User with that email already exists.");
	    }

	    userService.createUser(user.getEmail(), user.getPassword());

	    return "redirect:/login";
	}
}
