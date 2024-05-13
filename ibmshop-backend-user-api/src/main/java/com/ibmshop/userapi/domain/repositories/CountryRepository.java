package com.ibmshop.userapi.domain.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibmshop.userapi.domain.entities.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
	
	@Query(value = "select u from CountryEntity u where Upper(trim(u.nome))like %?1%")
	Optional<CountryEntity> findByCountry(String nome);
	
	

}