package com.auth.service.application.ibmshopbackendauthservice.repository;

import com.auth.service.application.ibmshopbackendauthservice.entidades.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential,Long > {
Optional<UserCredential> findByEmail(String email);
}
