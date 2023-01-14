package com.workshop.resource.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.resource.dtos.UserDTO;
import com.workshop.resource.dtos.mappers.UserMapper;
import com.workshop.resource.entities.User;
import com.workshop.resource.repositories.UserRepository;
import com.workshop.resource.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> findAll() {
		List<User> userList = userRepository.findAll();
		return userList.stream().map(x -> UserMapper.toDTO(x)).collect(Collectors.toList());
	}
	
	public UserDTO findById(String id) {
		Optional<User> entity = userRepository.findById(id);
		if (!entity.isPresent()) {
			throw new ObjectNotFoundException(id);
		}
		return UserMapper.toDTO(entity.get());
	}
}