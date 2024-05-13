package com.auth.service.application.ibmshopbackendauthservice.entidades;

import lombok.Getter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.Set;
@Getter
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Set<Role> authorities;

    private boolean enabled;

    public CustomUserDetails(UserCredential userCredential) {
        this.username = userCredential.getEmail();
        this.password = userCredential.getSenha();
        this.authorities = Collections.singleton(userCredential.getRole());
        this.enabled = userCredential.isAtivo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
