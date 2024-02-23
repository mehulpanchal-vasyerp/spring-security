package com.security.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.dto.AuthenticationRequest;
import com.security.demo.dto.AuthenticationResponse;
import com.security.demo.dto.UserDetailDto;
import com.security.demo.services.AuthenticationService;
@RestController
@RequestMapping()
public class PublicController {

private AuthenticationService authenticationService;
	
	@GetMapping("/free")
	public String free() {
		return "hello from free point";
		
	}
	@PostMapping("/addUser")
	public ResponseEntity<AuthenticationResponse> addUser(@RequestBody UserDetailDto userDetailDto){
		return ResponseEntity.ok(authenticationService.register(userDetailDto));
	}
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
		return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
	}

	

}
