package com.ibmshop.productsapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibmshop.productsapi.domain.model.SubCategoryEntity;

public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Long> {

}
