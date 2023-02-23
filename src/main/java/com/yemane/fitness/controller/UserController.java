package com.yemane.fitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yemane.fitness.model.User;

import com.yemane.fitness.model.WorkoutClass;

import com.yemane.fitness.repository.UserRepository;

import com.yemane.fitness.service.ClassService;
import com.yemane.fitness.service.UserService;

//Handles web requests mapped to Java functions and associated static HTML web pages for users with role "visitor" to access

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ClassService classService;

	//Method mapped with @GetMapping annotation to return a list of users and the class that they have registered 
	@GetMapping("/userclasses")
	public String getUserClasses(Model model) {
		List<Object> userClasses = userRepository.getUserIdAndClassId();
		model.addAttribute("userClasses", userClasses);
		return "user_classes";
	}

	//Method mapped with @PostMapping annotation to handle POST request matched with URI, saves user and class information when user submits form to sign up for a class
	@PostMapping("/sign-up")
	public String signUpForClass(@RequestParam("userId") Long userId, @RequestParam("classId") Long classId) {

		User user = userRepository.findById(userId).get();

		WorkoutClass workoutClass = classService.getWorkoutClassById(classId);

		user.getWorkoutClasses().add(workoutClass);
		userRepository.save(user);

		return "redirect:/userclasses";
	}

	//Returns form for sign-up when user clicks on sign-up button 
	@GetMapping("/signup")
	public String showSignUpForm(Model model) {
		List<User> users = userRepository.findAll();
		List<WorkoutClass> classes = classService.getAllWorkoutClasses();
		model.addAttribute("users", users);
		model.addAttribute("classes", classes);
		return "signup-form";
	}

	//Returns user account registration form when user clicks to register for an account
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "register_user";
	}

	//Saves user information when user submits filled form to register for account
	@PostMapping("/register")
	public String register(@ModelAttribute User user) {

		userService.createUser(user.getEmail(), user.getPassword());

		return "redirect:/user-index";
	}

	//Returns list of all users that exist in database
	@GetMapping("/admin-index")
	public String getUsers(Model model) {
		List<User> listUsers = userService.getAllExistingUsers();
		model.addAttribute("listUsers", listUsers);
		return "admin_index";

	}
	
//Returns login page
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
//Returns login page when user clicks logout button
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/login";
	}
}
