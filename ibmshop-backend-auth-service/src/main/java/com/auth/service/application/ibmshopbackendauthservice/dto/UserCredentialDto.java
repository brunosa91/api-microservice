package com.auth.service.application.ibmshopbackendauthservice.dto;

import com.auth.service.application.ibmshopbackendauthservice.entidades.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentialDto {

    String email;
    String Senha;

    Role role;

    boolean ativo;

}
