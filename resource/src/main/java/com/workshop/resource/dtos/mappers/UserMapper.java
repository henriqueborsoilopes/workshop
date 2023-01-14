package com.workshop.resource.dtos.mappers;

import com.workshop.resource.dtos.UserDTO;
import com.workshop.resource.entities.User;

public class UserMapper {

	public static UserDTO toDTO(User entity) {
		return new UserDTO(entity.getId(), entity.getName(), entity.getEmail());
	}
	
	public static User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
