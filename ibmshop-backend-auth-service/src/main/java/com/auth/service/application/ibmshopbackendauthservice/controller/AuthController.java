package com.auth.service.application.ibmshopbackendauthservice.controller;

import com.auth.service.application.ibmshopbackendauthservice.dto.LoginUserDto;
import com.auth.service.application.ibmshopbackendauthservice.dto.UserCredentialDto;
import com.auth.service.application.ibmshopbackendauthservice.dto.UserCredentialRegisterDto;
import com.auth.service.application.ibmshopbackendauthservice.service.AuthServiceImpl;
import com.auth.service.application.ibmshopbackendauthservice.service.JwtProviderImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthServiceImpl service;

    private final JwtProviderImpl jwtProvider;

    @PostMapping(value = "/admin")
    public ResponseEntity<UserCredentialDto> insertAdminCredential(@RequestBody UserCredentialRegisterDto dto) {
        log.info("Criando user credential");
        UserCredentialDto admin = service.credentialAdmin(dto);
        log.info("Criado user credential com sucesso");
        return ResponseEntity.ok(admin);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<UserCredentialDto> inserUserCredential(@RequestBody UserCredentialRegisterDto dto) {
        log.info("Criando user credential");
        UserCredentialDto user = service.credentialUser(dto);
        log.info("Criado user credential com sucesso");
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginUserDto dto) {
        return ResponseEntity.ok(service.login(dto));
    }

    @GetMapping("/validar")
    public String validarToken(@RequestParam("token") String token) {
        jwtProvider.validarToken(token);
        return "Token válido";
    }
}
