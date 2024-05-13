package com.ibmshop.productsapi.unit.service;

import static com.ibmshop.productsapi.migration.ProductSeviceConstants.CategoryEntityTest;
import static com.ibmshop.productsapi.migration.ProductSeviceConstants.CategoryEntityBlank;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ibmshop.productsapi.app.service.consultation.CategoryConsultationService;
import com.ibmshop.productsapi.app.service.manutencao.CategoryMaintenanceService;
import com.ibmshop.productsapi.domain.model.CategoryEntity;
import com.ibmshop.productsapi.domain.repository.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
	@InjectMocks
	private CategoryMaintenanceService categoryMaintenanceService;
	
	@Mock
	private CategoryConsultationService categoryConsultationService;

	@Mock
	private CategoryRepository categoryRepository;

	// operacao_estado_retorno
	@Test
	public void insertCategory_WithValidData_ReturnsCategory() {
		
		when(categoryRepository.save(CategoryEntityTest)).thenReturn(CategoryEntityTest);
		CategoryEntity sut =  categoryMaintenanceService.insert(CategoryEntityTest);
		
		assertThat(sut).isEqualTo(CategoryEntityTest);

	}
	
	@Test
	public void insertCategory_WithInvalidData_ThrowException() {
		when(categoryRepository.save(CategoryEntityBlank)).thenThrow(EntityNotFoundException.class);
		
		assertThatThrownBy(()-> categoryMaintenanceService.insert(CategoryEntityBlank)).isInstanceOf(EntityNotFoundException.class);
	}

	@Test
	public void GetCategory_ByExistId_ReturnCategory() {
		when(categoryRepository.findById(1l)).thenReturn(Optional.of(CategoryEntityTest));
		Optional<CategoryEntity> sut = categoryRepository.findById(1L);
		assertThat(sut).isPresent();
		assertThat(sut.get()).isEqualTo(CategoryEntityTest);
	}
	
	@Test
	public void GetCategory_ByUnexistId_ReturnEmpty() {
		when(categoryRepository.findById(1l)).thenReturn(Optional.empty());
		Optional<CategoryEntity> sut = categoryRepository.findById(1L);
		assertThat(sut).isEmpty();
		
	}
	
}
