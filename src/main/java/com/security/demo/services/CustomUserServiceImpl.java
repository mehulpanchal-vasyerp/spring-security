package com.security.demo.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.demo.dto.UserDetailDto;
import com.security.demo.model.Role;
import com.security.demo.model.User;
import com.security.demo.repository.RoleRepository;
import com.security.demo.repository.UserRepository;

@Service
public class CustomUserServiceImpl implements UserDetailsService,CustomUserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
//
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).get();
		 	List<GrantedAuthority>authorities = List.of(new SimpleGrantedAuthority(user.getRole()));
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(),authorities);
//		return org.springframework.security.core.userdetails.User(username, user.getPassword(),authorities);

	}
@Override
public void saveUser(UserDetailDto userDetailDto) {
	User user = new User();
	user.setName(userDetailDto.getName());
	user.setUsername(userDetailDto.getUsername());
	user.setEmail(userDetailDto.getEmail());
	user.setPassword(passwordEncoder.encode(userDetailDto.getPassword()));
	user.setRole(userDetailDto.getRole());
	userRepository.save(user);
	
	
	
	
}

}
