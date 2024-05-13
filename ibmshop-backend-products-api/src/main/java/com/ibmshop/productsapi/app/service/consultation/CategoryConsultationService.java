package com.ibmshop.productsapi.app.service.consultation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibmshop.productsapi.app.dto.output.CategoryDtoOutput;
import com.ibmshop.productsapi.app.mapper.CategoriesMapperImpl;
import com.ibmshop.productsapi.domain.model.CategoryEntity;
import com.ibmshop.productsapi.domain.repository.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class CategoryConsultationService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoriesMapperImpl categoryMapper;

	public List<CategoryDtoOutput> findAll() {

		List<CategoryEntity> list = categoryRepository.findAll();
		List<CategoryDtoOutput> listDto = list.stream().map(categoryMapper::EntityToDtoCategory)
				.collect(Collectors.toList());

		if (listDto.isEmpty()) {
			throw new EntityNotFoundException("Ops! Ainda não há categoria cadastradas");
		}
		return listDto;

	}

	@Transactional
	public CategoryDtoOutput findById(Long id) {
		Optional<CategoryEntity> obj = categoryRepository.findById(id);
		if (obj.isEmpty())
			throw new EntityNotFoundException(
					"Desculpe, não foi possível encontrar uma categoria com este id. Verifique e tente novamente.");
		CategoryDtoOutput objDto = categoryMapper.EntityToDtoCategory(obj.get());
		return objDto;

	}

	@Transactional
	public CategoryDtoOutput findByName(String nome_categoria) {
		Optional<CategoryEntity> opCategoryName = categoryRepository.findByNome(nome_categoria);
		if (opCategoryName.isEmpty())
			throw new EntityNotFoundException(
					"Não foi possível encontrar uma categoria com este Nome. Verifique e tente novamente.");
		CategoryDtoOutput objDto = categoryMapper.EntityToDtoCategory(opCategoryName.get());

		return objDto;

	}

}
