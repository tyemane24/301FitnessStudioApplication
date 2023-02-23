package com.yemane.fitness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Handles web requests mapped to user and admin index web pages

@Controller
public class AppController {

	//Returns home page 
	@GetMapping("/index")
	public String viewIndex() {
		return "index";
	}
	
//Returns user home page
	@GetMapping("/user-index")
	public String viewUserIndex() {
		return "user_index";
	}
	

}
