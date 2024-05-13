package com.ibmshop.userapi.app.mapper;


import org.mapstruct.Mapper;

import com.ibmshop.userapi.app.dto.input.UserDtoInsert;
import com.ibmshop.userapi.app.dto.output.UserDtoOutput;
import com.ibmshop.userapi.app.dto.update.UserDtoUpdate;
import com.ibmshop.userapi.domain.entities.UserEntity;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface  UserMapper{

	UserEntity dtoToEntity(UserDtoInsert dto);

	UserEntity dtoToEntityUpdate(UserDtoOutput dto);

	UserEntity dtoToEntityUpdateUser(UserDtoUpdate dto);

	UserDtoOutput entityToDto(UserEntity entity);



	
	
	
}

