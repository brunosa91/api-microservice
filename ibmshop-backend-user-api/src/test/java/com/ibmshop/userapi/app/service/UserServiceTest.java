package com.ibmshop.userapi.app.service;

import com.ibmshop.userapi.app.dto.input.UserDtoInsert;
import com.ibmshop.userapi.app.dto.output.UserDtoOutput;
import com.ibmshop.userapi.app.mapper.UserMapper;
import com.ibmshop.userapi.app.mapper.UserMapperImpl;
import com.ibmshop.userapi.common.UserConstant;
import com.ibmshop.userapi.cross.exception.ValidationItemExist;
import com.ibmshop.userapi.domain.entities.UserEntity;
import com.ibmshop.userapi.domain.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.assertj.core.api.Assertions.*;
import static  org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import  static com.ibmshop.userapi.common.UserConstant.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapperImpl mapper;

    @Test
    public void createUser(){
        when(userRepository.findByCpf(USER.getCpf())).thenReturn(Optional.empty());
        when(userRepository.save(USER)).thenReturn(USER);
        when(mapper.dtoToEntity(USER_DTO_INSERT)).thenReturn(USER);

        UserEntity sut = userService.insert(USER_DTO_INSERT);
        Assertions.assertThat(sut).isEqualTo(USER);

    }





    @Test
    public void CreateCpf_WithCpfExist(){
        when(userRepository.findByCpf(USER.getCpf())).thenReturn(Optional.of(USER));
        Assertions.assertThatExceptionOfType(ValidationItemExist.class).isThrownBy(()->userService.insert(USER_DTO_INSERT));

    }




    @Test
    public void testFindAllUser() {

        List<UserEntity> userList = new ArrayList<>();


        userList.add(USER);


        when(userRepository.findByAtivoTrue()).thenReturn(userList);
        when(mapper.entityToDto(USER)).thenReturn(USER_DTO_OUTPUT);


        List<UserDtoOutput> result = userService.findAll();

        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result.get(0)).isEqualTo(USER_DTO_OUTPUT);
    }

    @Test
    public  void testFindAllUserNoReturn(){

        when(userRepository.findByAtivoTrue()).thenReturn(Collections.EMPTY_LIST);


        List<UserDtoOutput> result = userService.findAll();

        Assertions.assertThat(result).isEmpty();


    }



    @Test
    public void testFindById() {

        when(userRepository.findById(1l)).thenReturn(Optional.of(USER));

        when(mapper.entityToDto(USER)).thenReturn(USER_DTO_OUTPUT);

        Optional< UserDtoOutput> result = Optional.ofNullable(userService.findById(1l));

        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result.get()).isEqualTo(USER_DTO_OUTPUT);


    }

    @Test
    public void testFindByIdUnexist() {

        when(userRepository.findById(1l)).thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(EntityNotFoundException.class).isThrownBy(() -> userService.findById(1L));




    }

    @Test
    public void testFindByCpf() {

        when(userRepository.findByCpf("85182468067")).thenReturn(Optional.of(USER));
        when(mapper.entityToDto(USER)).thenReturn(USER_DTO_OUTPUT);

        Optional< UserDtoOutput> result = Optional.ofNullable(userService.findByCpf("85182468067"));
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result.get()).isEqualTo(USER_DTO_OUTPUT);
    }
    @Test
    public void findCpfWithCpfUneExist(){
        when(userRepository.findByCpf("39650590846")).thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(EntityNotFoundException.class).isThrownBy(() -> userService.findByCpf("39650590846"));

    }
    @Test
    public void testFindByName() {

        List<UserEntity> userList = new ArrayList<>();

        userList.add(USER);

        when(userRepository.findByNome("bruno")).thenReturn(userList);
        when(mapper.entityToDto(USER)).thenReturn(USER_DTO_OUTPUT);
        List<UserDtoOutput> result = userService.findByName("bruno");

        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result.get(0)).isEqualTo(USER_DTO_OUTPUT);
    }
    @Test
    public void findByName_WithUnexistingName_ReturnsEmptyList() {

        when(userRepository.findByNome("bruno")).thenReturn(Collections.emptyList());

        Assertions.assertThatExceptionOfType(EntityNotFoundException.class).isThrownBy(()->userService.findByName("bruno"));
    }
    @Test
    public void UpdateUser_WithValidData(){

        when(userRepository.findById(1L)).thenReturn(Optional.of(USER));

        Optional<UserEntity> user = userRepository.findById(1L);

        Assertions.assertThat(user).isPresent();

        Assertions.assertThatNoException().isThrownBy(()->userService.updateUser(USER_DTO_UPDATE, 1l));

    }

    @Test
    public void UpdateUser_Unexist(){

        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<UserEntity> user = userRepository.findById(1L);

        Assertions.assertThat(user).isEmpty();

        Assertions.assertThatExceptionOfType(EntityNotFoundException.class).isThrownBy(()->userService.updateUser(USER_DTO_UPDATE, 1l));

    }
    @Test
    public void UpdateUserIsActive_WithValidData(){

        when(userRepository.findById(1L)).thenReturn(Optional.of(USER));

        Optional<UserEntity> user = userRepository.findById(1L);

        Assertions.assertThat(user).isPresent();

        Assertions.assertThatNoException().isThrownBy(()->userService.updadeUserActive(USER_DTO_UPDATE, 1l));

    }

    @Test
    public void UpdateUserIsActive_Unexist(){

        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<UserEntity> user = userRepository.findById(1L);

        Assertions.assertThat(user).isEmpty();

        Assertions.assertThatExceptionOfType(EntityNotFoundException.class).isThrownBy(()->userService.updadeUserActive(USER_DTO_UPDATE, 1l));

    }



}

