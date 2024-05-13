package com.ibmshop.productsapi.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibmshop.productsapi.domain.model.CategoryEntity;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	@Query(value = "SELECT * FROM category_table WHERE UPPER(TRIM(nome_categoria)) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
	Optional<CategoryEntity> findByNome(String nome_categoria);
}
