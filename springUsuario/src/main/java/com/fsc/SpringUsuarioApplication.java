package com.fsc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
public class SpringUsuarioApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringUsuarioApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("BCRYPT = " + passwordEncoder.encode("654321"));
		
	}

}
