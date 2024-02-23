package com.security.demo.controller;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.security.demo.dto.AuthenticationRequest;
import com.security.demo.dto.AuthenticationResponse;
import com.security.demo.dto.UserDetailDto;
import com.security.demo.model.Users;
import com.security.demo.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class FrontentPublicController {

	private final AuthenticationService authenticationService;
	private final AuthenticationManager authenticationManager;

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("Index");
		return mav;
	}

	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}

	@PostMapping("/addUser-page")
	public String addUser(UserDetailDto userDetailDto) {
		authenticationService.register(userDetailDto);
		return "redirect:/login";
	}

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("clogin");
	}

	@PostMapping("/auth")
	public ModelAndView loginProcess(AuthenticationRequest authRequest) throws IOException {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			Users userDetails = authenticationService.getUserByUsername(authRequest.getUsername());
			AuthenticationResponse res = authenticationService.authenticate(authRequest);

			ModelAndView mav;
			if (userDetails.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
				mav = new ModelAndView("admin");
			} else {
				mav = new ModelAndView("user");
			}
			mav.addObject("token", res.getToken());
			System.out.println(res.getToken());
			return mav;
		} else {
			// Authentication failed
			throw new BadCredentialsException("Invalid username or password");
		}

	}
}
