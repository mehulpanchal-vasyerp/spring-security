package com.security.demo.services;

import com.security.demo.dto.AuthenticationRequest;
import com.security.demo.dto.AuthenticationResponse;
import com.security.demo.dto.UserDetailDto;
import com.security.demo.model.Users;

public interface AuthenticationService {
	AuthenticationResponse register(UserDetailDto  userDetailDto);
	AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
	Users getUserByUsername(String username);
}



