package com.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		security
		.csrf(a->a.disable())

		.authorizeHttpRequests(authorizeRequests -> authorizeRequests
//						.requestMatchers("/**").permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.requestMatchers("/user/**").hasRole("USER")
						.anyRequest().permitAll())
	
		
	.formLogin(form->form
			.successHandler(new CustomSuccessHandler()))

	.logout(logout -> logout
            .permitAll());
	return security.build();
	}
//	
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//		return configuration.getAuthenticationManager();
//	}
}
