package com.auth.service.application.ibmshopbackendauthservice.mapper;


import com.auth.service.application.ibmshopbackendauthservice.dto.UserCredentialDto;
import com.auth.service.application.ibmshopbackendauthservice.dto.UserCredentialRegisterDto;
import com.auth.service.application.ibmshopbackendauthservice.entidades.UserCredential;
import org.mapstruct.Mapping;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    UserCredentialDto entityToUserCredentialDto(UserCredential userCredential);

    UserCredential registeDtoToUserCredential(UserCredentialRegisterDto dto);
}
