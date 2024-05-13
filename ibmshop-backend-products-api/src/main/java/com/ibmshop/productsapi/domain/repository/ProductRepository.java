package com.ibmshop.productsapi.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibmshop.productsapi.domain.model.ProductEntity;


public interface ProductRepository extends JpaRepository <ProductEntity, Long>{
	
	@Query(value = "select u from ProductEntity u where Upper(trim(u.nome_produto))like %?1%")
	Optional<ProductEntity> findByNome(String nome);
	
	Optional<ProductEntity> findBySku(Integer sku);
}
