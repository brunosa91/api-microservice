package com.ibmshop.productsapi.app.service.manutencao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibmshop.productsapi.app.dto.input.SubCategoryDtoInsert;
import com.ibmshop.productsapi.app.dto.input.SubCategoryDtoUpdate;
import com.ibmshop.productsapi.app.dto.output.CategoryDtoOutput;
import com.ibmshop.productsapi.app.dto.output.ProductDtoOutput;
import com.ibmshop.productsapi.app.dto.output.SubCategoryDtoOutput;
import com.ibmshop.productsapi.app.mapper.SubCategoryMapperImpl;
import com.ibmshop.productsapi.app.service.consultation.CategoryConsultationService;
import com.ibmshop.productsapi.app.service.consultation.SubCategoryConsultationService;
import com.ibmshop.productsapi.domain.model.SubCategoryEntity;
import com.ibmshop.productsapi.domain.repository.SubCategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class SubCategoryMaintenanceService {

	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@Autowired
	private SubCategoryConsultationService subCategoryconsultationService;
	@Autowired
	private CategoryConsultationService categoryConsultationService;
	@Autowired
	private SubCategoryMapperImpl subCategoryMapper;

	@Transactional
	public SubCategoryEntity insert(SubCategoryDtoInsert obj) {

		CategoryDtoOutput objCat = categoryConsultationService.findById(obj.getId_category());

		SubCategoryEntity subEnt = subCategoryMapper.DtotoEntitySubCategory(obj);

		return subCategoryRepository.save(subEnt);
	}

	@Transactional
	public void update(SubCategoryDtoUpdate obj, Long id) {

		SubCategoryDtoOutput newObj = subCategoryconsultationService.findById(obj.getId());

		updateData(newObj, obj);

		SubCategoryEntity objDto = subCategoryMapper.DtotoEntitySubCategoryUpdate(newObj);

		subCategoryRepository.save(objDto);

	}

	@Transactional
	private void updateData(SubCategoryDtoOutput newObj, SubCategoryDtoUpdate obj) {
		newObj.setNome_sub_categoria(obj.getNome_sub_categoria());
		newObj.setDescricao(obj.getDescricao());
		newObj.setId_category(obj.getId());

	}

	public void delete(Long id) {
		SubCategoryDtoOutput subCategory = subCategoryconsultationService.findById(id);

		List<ProductDtoOutput> productList = subCategory.getProductEntity();

		if (productList != null && !productList.isEmpty()) {
			throw new RuntimeException("Não é possível excluir uma sub categoria que ainda possui produtos.");
		}

		SubCategoryEntity objDto = subCategoryMapper.DtotoEntitySubCategoryUpdate(subCategory);

		subCategoryRepository.delete(objDto);

	}

}
