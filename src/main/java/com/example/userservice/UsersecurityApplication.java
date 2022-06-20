package com.example.userservice;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UsersecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersecurityApplication.class, args);
	}


	//from config
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//save role , save user after main run
	@Bean
	CommandLineRunner run(UserService userService){
		return  args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "thama ketno", "aom", "3143", new ArrayList<>()));
			userService.saveUser(new User(null, "ahis kumar", "ohca", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "vitu duaiso", "nuti", "3412", new ArrayList<>()));
			userService.saveUser(new User(null, "nutra danon", "tania", "1123", new ArrayList<>()));

			userService.addRoleToUser("ohca", "ROLE_USER");
			userService.addRoleToUser("aom", "ROLE_MANAGET");
			userService.addRoleToUser("aom", "ROLE_ADMIN");
			userService.addRoleToUser("aom", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("nuti", "ROLE_ADMIN");
			userService.addRoleToUser("tania", "ROLE_MANAGER");
		};
	}
}
