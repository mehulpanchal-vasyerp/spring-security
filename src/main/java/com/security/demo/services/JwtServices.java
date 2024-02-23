package com.security.demo.services;

import java.util.Date;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtServices {

    String extractUsername(String jwt);

    Date extractExpiration(String token);

    Boolean isTokenValid(String token, UserDetails userDetails);

    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    String generateToken(UserDetails userDetails);

}


