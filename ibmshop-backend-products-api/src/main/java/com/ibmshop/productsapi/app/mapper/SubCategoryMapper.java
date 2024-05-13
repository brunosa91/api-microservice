package com.ibmshop.productsapi.app.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ibmshop.productsapi.app.dto.input.SubCategoryDtoInsert;
import com.ibmshop.productsapi.app.dto.output.SubCategoryDtoOutput;
import com.ibmshop.productsapi.domain.model.SubCategoryEntity;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {

	@Mapping(target = "productEntity", ignore = true)
	@Mapping(target = "categoryEntity.id", source = "id_category")
	SubCategoryEntity DtotoEntitySubCategory(SubCategoryDtoInsert subCategoryDto);

	@Mapping(target = "productEntity", ignore = true)
	@Mapping(target = "categoryEntity.id", source = "id_category")
	SubCategoryEntity DtotoEntitySubCategoryUpdate(SubCategoryDtoOutput subCategoryDto);

	@InheritInverseConfiguration
	SubCategoryDtoOutput EntitytoDtoSubCategory(SubCategoryEntity subCategoryEntity);

}