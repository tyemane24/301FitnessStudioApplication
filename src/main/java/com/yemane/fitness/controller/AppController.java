package com.yemane.fitness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/admin")
	public String viewIndex() {
		return "admin";
	}
	
}
