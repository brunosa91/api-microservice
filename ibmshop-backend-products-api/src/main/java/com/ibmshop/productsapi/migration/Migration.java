package com.ibmshop.productsapi.migration;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ibmshop.productsapi.domain.model.CategoryEntity;
import com.ibmshop.productsapi.domain.model.SubCategoryEntity;
import com.ibmshop.productsapi.domain.repository.CategoryRepository;
import com.ibmshop.productsapi.domain.repository.SubCategoryRepository;




@Configuration
@Profile("test")
public class Migration implements CommandLineRunner  {

	@Autowired 
	private CategoryRepository categoryRepository;
	@Autowired 
	private SubCategoryRepository subCategoryRepository;
	
	
	
	

	@Override
	public void run(String... args) throws Exception {
/*
		CategoryEntity c1 = new CategoryEntity(null, "Vetuário");
		SubCategoryEntity sc1 = new SubCategoryEntity(null, "Sapartos","Sapato para uso em festas sociais",c1);

		 categoryRepository.saveAll(Arrays.asList(c1));
		 subCategoryRepository.saveAll(Arrays.asList(sc1));
		
			*/}
			
		
	
}
