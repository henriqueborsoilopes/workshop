package com.workshop.resource.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workshop.resource.dtos.UserDTO;
import com.workshop.resource.dtos.mappers.UserMapper;
import com.workshop.resource.entities.User;
import com.workshop.resource.repositories.UserRepository;
import com.workshop.resource.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> userList = userRepository.findAll();
		return userList.stream().map(x -> UserMapper.toDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(String id) {
		Optional<User> entity = userRepository.findById(id);
		if (!entity.isPresent()) {
			throw new ObjectNotFoundException(id);
		}
		return UserMapper.toDTO(entity.get());
	}

	@Transactional
	public UserDTO insert(UserDTO userDTO) {
		userDTO = UserMapper.toDTO(userRepository.insert(UserMapper.fromDTO(userDTO)));
		return userDTO;
	}

	public void deleteById(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

	@Transactional
	public UserDTO update(UserDTO userDTO) {
		if (userDTO.getId() == null || !userRepository.existsById(userDTO.getId())) {
			throw new ObjectNotFoundException(userDTO.getId());
		}
		return UserMapper.toDTO(userRepository.save(UserMapper.fromDTO(userDTO)));
	}
}