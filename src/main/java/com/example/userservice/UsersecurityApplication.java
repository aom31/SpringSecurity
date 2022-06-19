package com.example.userservice;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class UsersecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersecurityApplication.class, args);
	}


	//save role , save user after main run
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

		};
	}
}
