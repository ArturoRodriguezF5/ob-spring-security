package com.arthycode.obspringsecuritycifrado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ObSpringSecurityCifradoApplication {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObSpringSecurityCifradoApplication.class, args);
		UserRepository userRepo = context.getBean(UserRepository.class);

		PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);

		User user = new User(null, "User 5", passwordEncoder.encode("admin"));
		userRepo.save(user);
	}

}
