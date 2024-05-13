package com.ibmshop.userapi.domain.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibmshop.userapi.domain.entities.Address;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserId(Long id);


    Optional<Address> findByApelido(String apelido);





}