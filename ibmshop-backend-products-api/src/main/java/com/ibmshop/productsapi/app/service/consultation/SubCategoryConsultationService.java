package com.ibmshop.productsapi.app.service.consultation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibmshop.productsapi.app.dto.output.SubCategoryDtoOutput;
import com.ibmshop.productsapi.app.mapper.SubCategoryMapperImpl;
import com.ibmshop.productsapi.domain.model.SubCategoryEntity;
import com.ibmshop.productsapi.domain.repository.SubCategoryRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class SubCategoryConsultationService {

	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@Autowired
	private SubCategoryMapperImpl subCategoryMapper;

	public List<SubCategoryDtoOutput> findAll() {

		List<SubCategoryEntity> subCategoryEnityList = subCategoryRepository.findAll();

		List<SubCategoryDtoOutput> SubCategoryDtoList = subCategoryEnityList.stream()
				.map(subCategoryMapper::EntitytoDtoSubCategory).collect(Collectors.toList());
		if (SubCategoryDtoList.isEmpty()) {
			throw new EntityNotFoundException("Ops! Ainda não há sub categoria cadastradas");
		}
		return SubCategoryDtoList;

	}

	@Transactional
	public SubCategoryDtoOutput findById(Long id) {
		Optional<SubCategoryEntity> obj = subCategoryRepository.findById(id);
		if (obj.isEmpty())
			throw new EntityNotFoundException(
					"Desculpe, não foi possível encontrar uma Sub categoria com este id. Verifique e tente novamente.");
		SubCategoryDtoOutput ObjToDto = subCategoryMapper.EntitytoDtoSubCategory(obj.get());
		return ObjToDto;

	}
}
