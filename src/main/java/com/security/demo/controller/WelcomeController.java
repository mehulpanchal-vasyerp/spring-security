package com.security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.security.demo.dto.UserDetailDto;
import com.security.demo.services.CustomUserService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WelcomeController {
	
	@Autowired 
	private CustomUserService customUserService;
	
	@GetMapping("/welcome")
	public String getWelcome() {
		return "welcome";	
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@PostMapping("/addUser")
	public String addUser(UserDetailDto userDetailDto) {
		customUserService.saveUser(userDetailDto);
		return "redirect:/login";
	}
	@GetMapping("/admin")
	public String admin() {
		return "admin";	
	}
	@GetMapping("/user")
	public String user() {
		return "user";
	}

	
	
}
