package com.immu.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.immu.dto.UserDTO;
import com.immu.entity.UserEntity;

@Component
public class LoginModelMapper {

	//ModelMapper is used for converting Entity to DTO and DTO to Entity
	private ModelMapper modelMapper = new ModelMapper();

	//converting DTO to Entity class
	public UserEntity convertDTOtoEntity(UserDTO userDTO) {
		return modelMapper.map(userDTO, UserEntity.class);
	}

	//Converting Entity to DTO Class
	public UserDTO convertEntitytoDTO(UserEntity userEntity) {
		return modelMapper.map(userEntity, UserDTO.class);
	}

}
