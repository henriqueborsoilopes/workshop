package com.workshop.resource.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.resource.entities.User;
import com.workshop.resource.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		List<User> userList = userRepository.findAll();
		return userList;
	}
}
