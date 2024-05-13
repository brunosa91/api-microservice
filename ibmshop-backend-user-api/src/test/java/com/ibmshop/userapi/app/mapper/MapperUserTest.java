package com.ibmshop.userapi.app.mapper;

import com.ibmshop.userapi.app.dto.input.AddressDtoInsert;
import com.ibmshop.userapi.app.dto.output.AddressDtoOutput;
import com.ibmshop.userapi.app.dto.output.CountryDtoOutput;
import com.ibmshop.userapi.app.dto.output.UserDtoOutput;
import com.ibmshop.userapi.app.dto.update.AddressDtoUpdate;
import com.ibmshop.userapi.app.service.UserService;
import com.ibmshop.userapi.domain.entities.Address;
import com.ibmshop.userapi.domain.entities.CountryEntity;
import com.ibmshop.userapi.domain.entities.UserEntity;
import com.ibmshop.userapi.domain.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import  static com.ibmshop.userapi.common.UserConstant.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MapperUserTest {




    @InjectMocks
    private UserMapperImpl mapper;

    @Test
    public void dtoToEntity(){


        UserEntity sut = mapper.dtoToEntity(USER_DTO_INSERT);
        Assertions.assertThat(sut).isEqualTo(USER);

    }

    @Test
    public void dtoToEntity_IsNotConvert(){


        UserEntity sut = mapper.dtoToEntity(null);
        Assertions.assertThat(sut).isNull();

    }
    @Test
    public void dtoOutPutToEntity(){


        UserEntity sut = mapper.dtoToEntityUpdate(USER_DTO_OUTPUT);
        Assertions.assertThat(sut).isEqualTo(USER);

    }

    @Test
    public void dtoOutPutToEntity_IsNotConvert(){


        UserEntity sut = mapper.dtoToEntityUpdate(null);
        Assertions.assertThat(sut).isNull();

    }

    @Test
    public void dtoUpdateToEntity(){


        UserEntity sut = mapper.dtoToEntityUpdateUser(USER_DTO_UPDATE);
        Assertions.assertThat(sut).isEqualTo(USER);

    }

    @Test
    public void dtoUpdateToEntity_IsNotConvert(){


        UserEntity sut = mapper.dtoToEntityUpdateUser(null);
        Assertions.assertThat(sut).isNull();

    }


    @Test
    public void entityToDto(){


        UserDtoOutput sut = mapper.entityToDto(USER);
        Assertions.assertThat(sut).isEqualTo(USER_DTO_OUTPUT);

    }

    @Test
    public void entityToDto_IsNotConvert(){


        UserDtoOutput sut = mapper.entityToDto(null);
        Assertions.assertThat(sut).isNull();

    }



    @Test
    public void countryDtoInsertToCountryEntity(){


        CountryEntity sut = mapper.countryDtoInsertToCountryEntity(COUNTRY_DTO_INSERT);
        Assertions.assertThat(sut).isEqualTo(COUNTRY_ENTITY);

    }

    @Test
    public void countryDtoInsertToCountryEntity_IsNotConvert(){


        CountryEntity sut = mapper.countryDtoInsertToCountryEntity(null);
        Assertions.assertThat(sut).isNull();

    }


    @Test
    public void addressDtoInsertToAddress(){


        Address sut = mapper.addressDtoInsertToAddress(ADDRESS_DTO_INSERT);

        Assertions.assertThat(sut).isEqualTo(ADDRESS);

    }

    @Test
    public void addressDtoInsertToAddress_IsNotConvert(){


        Address sut = mapper.addressDtoInsertToAddress(null);
        Assertions.assertThat(sut).isNull();

    }

    @Test
    public void addressDtoInsertListToAddressList(){
        List<AddressDtoInsert> addressDtoOutputList = new ArrayList<>();
        addressDtoOutputList.add(ADDRESS_DTO_INSERT);
       List< Address >sut = mapper.addressDtoInsertListToAddressList(addressDtoOutputList);
        Assertions.assertThat(sut.get(0)).isEqualTo(ADDRESS);

    }

    @Test
    public void addressDtoInsertListToAddressList_IsNotConvert(){


        List<Address> sut = mapper.addressDtoInsertListToAddressList(null);
        Assertions.assertThat(sut).isNull();

    }


    @Test
    public void countryDtoOutputToCountryEntity(){


        CountryEntity sut = mapper.countryDtoOutputToCountryEntity(COUNTRY_DTO_OUTPUT);
        Assertions.assertThat(sut).isEqualTo(COUNTRY_ENTITY);

    }

    @Test
    public void countryDtoOutputToCountryEntity_IsNotConvert(){


        CountryEntity sut = mapper.countryDtoOutputToCountryEntity(null);
        Assertions.assertThat(sut).isNull();

    }

    @Test
    public void addressDtoOutputToAddress(){


        Address sut = mapper.addressDtoOutputToAddress(ADDRESS_DTO_OUTPUT);
        Assertions.assertThat(sut).isEqualTo(ADDRESS);

    }

    @Test
    public void addressDtoOutputToAddress_IsNotConvert(){


        Address sut = mapper.addressDtoOutputToAddress(null);
        Assertions.assertThat(sut).isNull();

    }


    @Test
    public void addressDtoOutputListToAddressList(){
        List<AddressDtoOutput> addressDtoOutputList = new ArrayList<>();
        addressDtoOutputList.add(ADDRESS_DTO_OUTPUT);
        List< Address >sut = mapper.addressDtoOutputListToAddressList(addressDtoOutputList);
        Assertions.assertThat(sut.get(0)).isEqualTo(ADDRESS);

    }

    @Test
    public void addressDtoOutputListToAddressList_IsNotConvert(){


        List< Address >sut = mapper.addressDtoOutputListToAddressList(null);
        Assertions.assertThat(sut).isNull();

    }

    @Test
    public void addressDtoUpdateToAddress(){


        Address sut = mapper.addressDtoUpdateToAddress(ADDRESS_DTO_UPDATE);
        Assertions.assertThat(sut).isEqualTo(ADDRESS);

    }

    @Test
    public void addressDtoUpdateToAddress_IsNotConvert(){


        Address sut = mapper.addressDtoUpdateToAddress(null);
        Assertions.assertThat(sut).isNull();

    }

    @Test
    public void addressDtoUpdateListToAddressList(){
        List<AddressDtoUpdate> addressDtoUpdateListList = new ArrayList<>();
        addressDtoUpdateListList.add(ADDRESS_DTO_UPDATE);
        List< Address >sut = mapper.addressDtoUpdateListToAddressList(addressDtoUpdateListList);
        Assertions.assertThat(sut).isEqualTo(ADDRESS);

    }

    @Test
    public void addressDtoUpdateListToAddressList_IsNotConvert(){


        List< Address >sut = mapper.addressDtoUpdateListToAddressList(null);
        Assertions.assertThat(sut).isNull();

    }


    @Test
    public void countryEntityToCountryDtoOutput(){


        CountryDtoOutput sut = mapper.countryEntityToCountryDtoOutput(COUNTRY_ENTITY);
        Assertions.assertThat(sut).isEqualTo(COUNTRY_DTO_OUTPUT);

    }

    @Test
    public void countryEntityToCountryDtoOutput_IsNotConvert(){


        CountryDtoOutput sut = mapper.countryEntityToCountryDtoOutput(null);
        Assertions.assertThat(sut).isNull();

    }

    @Test
    public void addressToAddressDtoOutput(){


        AddressDtoOutput sut = mapper.addressToAddressDtoOutput(ADDRESS);
        Assertions.assertThat(sut).isEqualTo(ADDRESS_DTO_OUTPUT);

    }

    @Test
    public void addressToAddressDtoOutput_IsNotConvert(){


        AddressDtoOutput sut = mapper.addressToAddressDtoOutput(null);
        Assertions.assertThat(sut).isNull();

    }

    @Test
    public void addressListToAddressDtoOutputList(){
        List<Address> addressList = new ArrayList<>();
        addressList.add(ADDRESS);
        List< AddressDtoOutput >sut = mapper.addressListToAddressDtoOutputList(addressList);
        Assertions.assertThat(sut.get(0)).isEqualTo(ADDRESS_DTO_OUTPUT);

    }

    @Test
    public void addressListToAddressDtoOutputList_IsNotConvert(){


        List< AddressDtoOutput >sut = mapper.addressListToAddressDtoOutputList(null);
        Assertions.assertThat(sut).isNull();

    }
}

