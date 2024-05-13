package com.ibmshop.userapi.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.ibmshop.userapi.app.dto.input.AddressDtoInsert;
import com.ibmshop.userapi.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibmshop.userapi.domain.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


	@Query(value = "SELECT * FROM user_table WHERE UPPER(TRIM(nome)) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
	List<UserEntity> findByNome(String nome);


	Optional<UserEntity> findByCpf(String cpf);

	List<UserEntity> findByAtivoTrue();

}