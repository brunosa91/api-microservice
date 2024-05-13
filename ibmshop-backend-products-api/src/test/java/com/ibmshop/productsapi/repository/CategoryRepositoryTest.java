package com.ibmshop.productsapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibmshop.productsapi.domain.model.CategoryEntity;
import com.ibmshop.productsapi.domain.repository.CategoryRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static com.ibmshop.productsapi.migration.ProductSeviceConstants.CategoryEntityTest;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private TestEntityManager testEntityManager;

    @Test
    public void CreateCategory_WithValidData_ReturnsCategory() {
    	
    CategoryEntity category= categoryRepository.save(CategoryEntityTest);
    
    CategoryEntity sut =  testEntityManager.find(CategoryEntity.class, category.getId());
    	
    assertThat(sut).isNotNull();
    assertThat(sut.getNome_categoria()).isEqualTo(CategoryEntityTest.getNome_categoria());
 
    }
    
    @Test
    public void CreateCategory_WithInvalidData_ThrowsException() {
    	CategoryEntity emptyCategory = new CategoryEntity();  
    	CategoryEntity InvalidCategory = new CategoryEntity(null,null);
    	
    	assertThatThrownBy(()-> categoryRepository.save(emptyCategory));
    //	assertThatThrownBy(()-> categoryRepository.save(InvalidCategory));

    	
    	}
}