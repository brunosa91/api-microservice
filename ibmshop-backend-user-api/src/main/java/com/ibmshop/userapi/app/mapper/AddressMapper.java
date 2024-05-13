package com.ibmshop.userapi.app.mapper;

import com.ibmshop.userapi.app.dto.input.AddressDtoInsert;
import com.ibmshop.userapi.app.dto.output.AddressDtoOutput;
import com.ibmshop.userapi.app.dto.update.AddressDtoUpdate;
import com.ibmshop.userapi.domain.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AddressMapper{

    @Mapping(source = "user.id", target = "idUser")
    AddressDtoOutput entityToDtoAddress(Address address);

    @Mapping(target = "user.id", source = "idUser")
    Address dtoToEntityAddress(AddressDtoInsert addressDtoInsert);

    @Mapping(target = "user.id", source = "idUser")
    Address dtoToEntityAddress(AddressDtoOutput addressDtoOutput);

    @Mapping(target = "user.id", source = "idUser")
    @Mapping(target = "country.id", source = "idCountry")
    Address dtoToEntityAddress(AddressDtoUpdate addressDtoUpdate);


}

