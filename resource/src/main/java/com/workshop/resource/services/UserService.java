package com.workshop.resource.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.resource.dtos.UserDTO;
import com.workshop.resource.dtos.mappers.UserMapper;
import com.workshop.resource.entities.User;
import com.workshop.resource.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> findAll() {
		List<User> userList = userRepository.findAll();
		return userList.stream().map(x -> UserMapper.toDTO(x)).collect(Collectors.toList());
	}
}