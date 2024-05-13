package com.ibmshop.userapi.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ibmshop.userapi.app.dto.client.UserCredentialDtoInsert;
import com.ibmshop.userapi.app.feign.UserAuthClient;
import com.ibmshop.userapi.app.mapper.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibmshop.userapi.app.dto.input.UserDtoInsert;
import com.ibmshop.userapi.app.dto.output.UserDtoOutput;
import com.ibmshop.userapi.app.dto.update.UserDtoUpdate;
import com.ibmshop.userapi.cross.exception.ValidationItemExist;
import com.ibmshop.userapi.domain.entities.UserEntity;
import com.ibmshop.userapi.domain.repositories.UserRepository;
import lombok.extern.log4j.Log4j2;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
@Log4j2
@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	UserAuthClient userAuthClient;

	@Autowired
	private UserMapperImpl mapper;

	@Override
	public List<UserDtoOutput> findAll() {
		List<UserEntity> ListEntity = userRepository.findByAtivoTrue();

		log.info(String.format("Encontrado no repository usuarios ativos ${} " , ListEntity ));
		List<UserDtoOutput> listDto = ListEntity.stream().map(mapper::entityToDto).toList();

		log.info(String.format("Mapeado usuarios ativos para Dto ${} " + listDto ));

		return listDto;

	}

	@Override
	@Transactional
	public UserDtoOutput findById(Long id) {
		Optional<UserEntity> userEntityOptional = userRepository.findById(id);

		log.info(String.format("Encontrado um user no repository por id ${} " + userEntityOptional ));

		if (userEntityOptional.isEmpty())
			throw new EntityNotFoundException(
					"Desculpe, não foi possível encontrar um usuário com este id. Verifique e tente novamente.");
		UserDtoOutput userDtoOutput = mapper.entityToDto(userEntityOptional.get());

		log.info(String.format("Mapeado o user para Dto n ${} " + userDtoOutput ));

		if (userDtoOutput.getAtivo() == false) {

			userDtoOutput.setAtivo(true);
		}
		return userDtoOutput;
	}

	@Override
	@Transactional
	public List<UserDtoOutput> findByName(String name) {
		List<UserEntity> listUserName = userRepository.findByNome(name);

		log.info(String.format("Encontrado um usuarios no repository por Nome ${} " + listUserName ));

		if (listUserName.isEmpty())
			throw new EntityNotFoundException(
					"Não foi possível encontrar um usuário com este Nome. Verifique e tente novamente e tente outra vez.");
		List<UserDtoOutput> listUserDto =  listUserName.stream().map(op -> mapper.entityToDto(op)).collect(Collectors.toList());

		log.info(String.format("Mapeado os usuarios para dto ${} " + listUserDto ));

		return listUserDto;

	}

	@Override
	@Transactional
	public UserDtoOutput findByCpf(String cpf) {
		Optional<UserEntity> userEntity = userRepository.findByCpf(cpf);

		log.info(String.format("Encontrado um usuarios no repository por cpf ${} " + userEntity ));

		if (userEntity.isEmpty())
			throw new EntityNotFoundException(
					"Desculpe, não foi possível encontrar um usuário com este cpf. Verifique e tente novamente.");
		UserDtoOutput listUserByCpf = mapper.entityToDto(userEntity.get());

		log.info(String.format("Mapeado os usuarios para dto ${} " + listUserByCpf ));

		return listUserByCpf;
	}

	@Override
	@Transactional
	public UserEntity insert(UserDtoInsert obj) {
		Optional<UserEntity> opInsertUser = userRepository.findByCpf(obj.getCpf());
		log.info(String.format("Encontrado um usuarios no repository por cpf ${} " + opInsertUser ));

		if (opInsertUser.isPresent())
			throw new ValidationItemExist("cpf",
					"Não foi possível cadastrar o usuário. Já existe um usuário cadastrado com este CPF. Verifique e tente novamente");
		obj.setData_criacao(LocalDateTime.now());
		obj.setData_modificacao(LocalDateTime.now());

		userAuthClient.inserUserCredential(new UserCredentialDtoInsert(obj.getEmail(),obj.getSenha()));


		UserEntity objEntity = mapper.dtoToEntity(obj);



		log.info(String.format("Mapeado os usuarios para dto ${} " + objEntity ));


		return userRepository.save(objEntity);
	}

	@Override
	@Transactional
	public void updadeUserActive(UserDtoUpdate userDtoUpdate, Long id) {

		Optional<UserEntity> userEntity = userRepository.findById(id);
		log.info(String.format("Encontrado um usuarios no repository por id ${} " + userEntity ));

		if (userEntity.isEmpty())
			throw new EntityNotFoundException(
					"Desculpe, não foi possível encontrar um usuário com este id. Verifique e tente novamente.");

		UserEntity newUserEntity = userEntity.get();

		newUserEntity.setAtivo(userDtoUpdate.getAtivo());

		userRepository.save(newUserEntity);

	}


	@Override
	@Transactional
	public void updateUser(UserDtoUpdate userDtoUpdate, Long id) {

		Optional<UserEntity> userEntity = userRepository.findById(id);

		log.info(String.format("Encontrado um usuarios no repository por id ${} " + userEntity ));

		if (userEntity.isEmpty())
			throw new EntityNotFoundException(
					"Desculpe, não foi possível encontrar um usuário com este id. Verifique e tente novamente.");

        UserEntity newUserEntity = userEntity.get();
		newUserEntity.setNome(userDtoUpdate.getNome());
		newUserEntity.setSobrenome(userDtoUpdate.getSobrenome());
		newUserEntity.setTelefone(userDtoUpdate.getTelefone());


		userRepository.save(newUserEntity);
	}



}
