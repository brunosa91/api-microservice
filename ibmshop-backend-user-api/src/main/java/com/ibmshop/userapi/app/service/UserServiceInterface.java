package com.ibmshop.userapi.app.service;

import java.util.List;
import java.util.Optional;


import com.ibmshop.userapi.app.dto.input.UserDtoInsert;
import com.ibmshop.userapi.app.dto.output.UserDtoOutput;
import com.ibmshop.userapi.app.dto.update.UserDtoUpdate;
import com.ibmshop.userapi.domain.entities.UserEntity;
import jakarta.transaction.Transactional;

public interface UserServiceInterface {

	List<UserDtoOutput> findAll();

	UserDtoOutput findById(Long id);

	List<UserDtoOutput> findByName(String nome);

	UserDtoOutput findByCpf(String cpf);

	UserEntity insert(UserDtoInsert obj);

	void updadeUserActive(UserDtoUpdate obj, Long id);




	void updateUser(UserDtoUpdate obj, Long id);

}
