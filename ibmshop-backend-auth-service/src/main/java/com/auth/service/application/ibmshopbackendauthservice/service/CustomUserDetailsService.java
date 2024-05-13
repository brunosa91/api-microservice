package com.auth.service.application.ibmshopbackendauthservice.service;

import com.auth.service.application.ibmshopbackendauthservice.entidades.CustomUserDetails;
import com.auth.service.application.ibmshopbackendauthservice.entidades.UserCredential;
import com.auth.service.application.ibmshopbackendauthservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserCredentialRepository userCredentialRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredential> credential = userCredentialRepository.findByEmail(username);
        return credential.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("User Not Found name: " + username));
    }
}
