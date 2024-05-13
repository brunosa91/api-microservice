package com.ibmshop.userapi.app.service;

import com.ibmshop.userapi.app.dto.output.AddressDtoOutput;
import com.ibmshop.userapi.app.dto.output.UserDtoOutput;
import com.ibmshop.userapi.app.mapper.AddressMapperImpl;
import com.ibmshop.userapi.cross.exception.ValidationItemExist;
import com.ibmshop.userapi.domain.entities.Address;
import com.ibmshop.userapi.domain.entities.UserEntity;
import com.ibmshop.userapi.domain.repositories.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.ibmshop.userapi.common.UserConstant.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private AddressMapperImpl mapper;

    @Test
    public void createUser(){

        List<Address> addressList = new ArrayList<>();

        addressList.add(ADDRESS);

        when(addressRepository.findByUserId(1L)).thenReturn(addressList);
        when(addressRepository.save(ADDRESS)).thenReturn(ADDRESS);
        when(mapper.dtoToEntityAddress(ADDRESS_DTO_INSERT)).thenReturn(ADDRESS);

        Address sut = addressService.insert(ADDRESS_DTO_INSERT);
        Assertions.assertThat(sut).isEqualTo(ADDRESS);

    }





    @Test
    public void CreateAddress_WithNickNameExist(){
        when(addressRepository.findByApelido(ADDRESS.getApelido())).thenReturn(Optional.of(ADDRESS));
        Assertions.assertThatExceptionOfType(ValidationItemExist.class).isThrownBy(()->addressService.insert(ADDRESS_DTO_INSERT));

    }






    @Test
    public void testFindAllUser() {

        List<Address> addressList = new ArrayList<>();


        addressList.add(ADDRESS);


        when(addressRepository.findAll()).thenReturn(addressList);
        //when(addressService.findAll()).thenReturn(userList);
        when(mapper.entityToDtoAddress(ADDRESS)).thenReturn(ADDRESS_DTO_OUTPUT);


        List<AddressDtoOutput> result = addressService.findAll();

        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result.get(0)).isEqualTo(ADDRESS_DTO_OUTPUT);
    }

    @Test
    public  void testFindAllUserNoReturn(){

        when(addressRepository.findAll()).thenReturn(Collections.EMPTY_LIST);

       // when(mapper.entityToDto(USER)).thenReturn(USER_DTO_OUTPUT);

        List<AddressDtoOutput> result = addressService.findAll();

        Assertions.assertThat(result).isEmpty();


    }



    @Test
    public void testFindById() {

        when(addressRepository.findById(1l)).thenReturn(Optional.of(ADDRESS));

        when(mapper.entityToDtoAddress(ADDRESS)).thenReturn(ADDRESS_DTO_OUTPUT);

        Optional< AddressDtoOutput> result = Optional.ofNullable(addressService.findById(1l));

        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result.get()).isEqualTo(ADDRESS_DTO_OUTPUT);


    }

    @Test
    public void testFindByIdUnexist() {

        when(addressRepository.findById(1l)).thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(EntityNotFoundException.class).isThrownBy(() -> addressService.findById(1L));




    }

    @Test
    public void testFindByCpf() {

        List<Address> addressList = new ArrayList<>();

        addressList.add(ADDRESS);
        when(addressRepository.findByUserId(1l)).thenReturn(addressList);
        when(mapper.entityToDtoAddress(ADDRESS)).thenReturn(ADDRESS_DTO_OUTPUT);

        List< AddressDtoOutput> result = addressService.findByIdUser(1l);
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result.get(0)).isEqualTo(ADDRESS_DTO_OUTPUT);
    }


    @Test
    public void FindUserToAddress_WithUserUnexist(){
        when(addressRepository.findByUserId(1l)).thenReturn(Collections.emptyList());
        Assertions.assertThatExceptionOfType(EntityNotFoundException.class).isThrownBy(()->addressService.findByIdUser(1l));

    }



          @Test
    public void UpdateAddress_WithValidData(){

        when(addressRepository.findById(1L)).thenReturn(Optional.of(ADDRESS));
       // when(mapper.dtoToEntityUpdate(USER_DTO_UPDATE)).thenReturn(USER);

        Optional<Address> address = addressRepository.findById(1L);

        Assertions.assertThat(address).isPresent();

        Assertions.assertThatNoException().isThrownBy(()->addressService.update(ADDRESS_DTO_UPDATE, 1l));

    }


    @Test
    public void UpdateAddress_Unexist(){

        when(addressRepository.findById(1L)).thenReturn(Optional.empty());
        // when(mapper.dtoToEntityUpdate(USER_DTO_UPDATE)).thenReturn(USER);

        Optional<Address> address = addressRepository.findById(1L);

        Assertions.assertThat(address).isEmpty();

        Assertions.assertThatExceptionOfType(EntityNotFoundException.class).isThrownBy(()->addressService.update(ADDRESS_DTO_UPDATE, 1l));

    }

    @Test
    public void DeleteAddress_WithExist(){

        when(addressRepository.findById(1L)).thenReturn(Optional.of(ADDRESS));


        Optional<Address> address = addressRepository.findById(1L);

       Assertions.assertThat(address).isPresent();


        Assertions.assertThatCode(()->addressService.delete(1L)).doesNotThrowAnyException();

    }


    @Test
    public void DeleteAddress_Unexist(){

        when(addressRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Address> address = addressRepository.findById(1L);

        Assertions.assertThat(address).isEmpty();

        Assertions.assertThatExceptionOfType(EntityNotFoundException.class).isThrownBy(()->addressService.delete(1l));

    }

}

