package com.fsc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Appconfig {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	
	
	 

	
	@Bean
	public JwtTokenStore jwtTokenStore() {
		return new JwtAccessTokenConverter();
		
	}
}
