package com.ibmshop.productsapi.app.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ibmshop.productsapi.app.dto.input.ProductDtoInsert;
import com.ibmshop.productsapi.app.dto.output.ProductDtoOutput;
import com.ibmshop.productsapi.domain.model.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	@Mapping(target = "subCategoryEntity.id", source = "id_sub_category")
	ProductEntity DtotoEntityProduct(ProductDtoInsert productDto);

	@Mapping(target = "subCategoryEntity.id", source = "id_sub_category")
	ProductEntity DtotoEntityProductUpdate(ProductDtoOutput productDto);

	@InheritInverseConfiguration
	ProductDtoOutput EntityToDtoProduct(ProductEntity productEntity);
}
