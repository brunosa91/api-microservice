package com.auth.service.application.ibmshopbackendauthservice.service;

import com.auth.service.application.ibmshopbackendauthservice.dto.LoginUserDto;
import com.auth.service.application.ibmshopbackendauthservice.dto.UserCredentialDto;
import com.auth.service.application.ibmshopbackendauthservice.dto.UserCredentialRegisterDto;
import com.auth.service.application.ibmshopbackendauthservice.entidades.Role;
import com.auth.service.application.ibmshopbackendauthservice.entidades.UserCredential;
import com.auth.service.application.ibmshopbackendauthservice.mapper.Mapper;
import com.auth.service.application.ibmshopbackendauthservice.repository.UserCredentialRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl {
    private final UserCredentialRepository userCredentialRepository;
    private final Mapper mapper;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtProviderImpl jwtProvider;

    @Transactional
    public UserCredentialDto credentialAdmin(UserCredentialRegisterDto dto){
        UserCredential admin = setarSenha(dto);
        admin.setRole(Role.ADMIN);
        admin.setAtivo(true);
        return mapper.entityToUserCredentialDto(userCredentialRepository.save(admin));

    }
    @Transactional
    public UserCredentialDto credentialUser(UserCredentialRegisterDto dto){

        UserCredential user = setarSenha(dto);
        user.setRole(Role.USER);
        user.setAtivo(true);

        return mapper.entityToUserCredentialDto(userCredentialRepository.save(user));
    }


    private UserCredential setarSenha(UserCredentialRegisterDto dto){

        UserCredential userCredential = mapper.registeDtoToUserCredential(dto);

        userCredential.setSenha(passwordEncoder.encode(dto.getSenha()));

        return userCredential;
    }

    public String login(LoginUserDto dto){

        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getSenha()));
            if (authentication.isAuthenticated())
                return jwtProvider.gerarToken(authentication.getName(),(List<? extends GrantedAuthority>)authentication.getAuthorities());
            else
                throw new RuntimeException("erro ao gerar tokem");
        }catch (AuthenticationException e){
            log.info(e.getMessage());
            return null;
        }
    }
}
