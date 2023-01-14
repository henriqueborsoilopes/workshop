package com.workshop.resource.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.resource.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@GetMapping
	public ResponseEntity<User> helloWorld() {
		User user = new User("1", "Henrique", "henrique@gmail.com");
		return ResponseEntity.ok().body(user);
	}
}
