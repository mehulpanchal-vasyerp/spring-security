package com.security.demo.services;

import org.springframework.stereotype.Service;

import com.security.demo.dto.UserDetailDto;
import com.security.demo.model.User;
@Service
public interface CustomUserService {
	  void saveUser(UserDetailDto userDetailDto);
	}


