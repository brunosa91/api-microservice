package com.ibmshop.productsapi.app.service.manutencao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibmshop.productsapi.app.dto.input.CategoryDtoUpdate;
import com.ibmshop.productsapi.app.dto.output.CategoryDtoOutput;
import com.ibmshop.productsapi.app.dto.output.SubCategoryDtoOutput;
import com.ibmshop.productsapi.app.mapper.CategoriesMapperImpl;
import com.ibmshop.productsapi.app.service.consultation.CategoryConsultationService;
import com.ibmshop.productsapi.cross.ValidationItemExist;
import com.ibmshop.productsapi.domain.model.CategoryEntity;
import com.ibmshop.productsapi.domain.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryMaintenanceService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryConsultationService categoryConsultationService;

	@Autowired
	private CategoriesMapperImpl categoryMapper;

	@Transactional
	public CategoryEntity insert(CategoryEntity obj) {
		Optional<CategoryEntity> opCategoryInsert = categoryRepository.findByNome(obj.getNome_categoria());
		if (opCategoryInsert.isPresent()) {
			throw new ValidationItemExist("nome_categoria",
					"Não foi possível cadastrar uma categoria. Já existe uma categoria cadastrada com este nome. Verifique e tente novamente");
		}
		return categoryRepository.save(obj);
	}

	@Transactional
	public void update(CategoryDtoUpdate obj, Long id) {

		CategoryDtoOutput newObj = categoryConsultationService.findById(obj.getId());

		updateData(newObj, obj);

		CategoryEntity objDto = categoryMapper.DtoToEntityCategoryUpdate(newObj);

		categoryRepository.save(objDto);

	}

	@Transactional
	private void updateData(CategoryDtoOutput newObj, CategoryDtoUpdate obj) {
		newObj.setNome_categoria(obj.getNome_categoria());

	}

	@Transactional

	public void delete(Long id) {
		CategoryDtoOutput category = categoryConsultationService.findById(id);

		List<SubCategoryDtoOutput> subcategories = category.getSubCategory();

		if (subcategories != null && !subcategories.isEmpty()) {
			throw new RuntimeException("Não é possível excluir uma categoria que ainda possui subcategorias.");
		}

		CategoryEntity objDto = categoryMapper.DtoToEntityCategoryUpdate(category);
		categoryRepository.delete(objDto);

	}

}
