package com.security.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.demo.dto.AuthenticationRequest;
import com.security.demo.dto.AuthenticationResponse;
import com.security.demo.dto.UserDetailDto;
import com.security.demo.model.Users;
import com.security.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtServices jwtService;
	private final AuthenticationManager authenticationManager;

	@Override
	public AuthenticationResponse register(UserDetailDto userDetailDto) {
		ModelMapper mapper = new ModelMapper();
		userDetailDto.setPassword(passwordEncoder.encode(userDetailDto.getPassword()));
		Users user = mapper.map(userDetailDto, Users.class);
		userRepository.save(user);
		String jwtToken = jwtService.generateToken(user);
		return new AuthenticationResponse(jwtToken);
	}

	@Override
	public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
				authenticationRequest.getPassword()));
		Users user = userRepository.findByUsername(authenticationRequest.getUsername());
		String jwtToken = jwtService.generateToken(user);
		return new AuthenticationResponse(jwtToken);
	}

	@Override
	public Users getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}


}
