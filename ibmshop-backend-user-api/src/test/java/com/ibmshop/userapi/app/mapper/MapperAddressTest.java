package com.ibmshop.userapi.app.mapper;

import com.ibmshop.userapi.app.dto.input.AddressDtoInsert;
import com.ibmshop.userapi.app.dto.output.AddressDtoOutput;
import com.ibmshop.userapi.app.dto.output.CountryDtoOutput;
import com.ibmshop.userapi.app.dto.output.UserDtoOutput;
import com.ibmshop.userapi.app.dto.update.AddressDtoUpdate;
import com.ibmshop.userapi.domain.entities.Address;
import com.ibmshop.userapi.domain.entities.CountryEntity;
import com.ibmshop.userapi.domain.entities.UserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.ibmshop.userapi.common.UserConstant.*;

@ExtendWith(MockitoExtension.class)
public class MapperAddressTest {




    @InjectMocks
    private AddressMapperImpl mapper;

    @Test
    public void dtoToEntity(){


        Address sut = mapper.dtoToEntityAddress(ADDRESS_DTO_INSERT);
        Assertions.assertThat(sut).isEqualTo(ADDRESS);

    }



}

