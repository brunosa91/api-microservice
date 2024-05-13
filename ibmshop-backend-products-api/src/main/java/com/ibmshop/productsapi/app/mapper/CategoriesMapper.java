package com.ibmshop.productsapi.app.mapper;

import org.mapstruct.Mapper;

import com.ibmshop.productsapi.app.dto.input.CategoryDtoInsert;
import com.ibmshop.productsapi.app.dto.output.CategoryDtoOutput;
import com.ibmshop.productsapi.domain.model.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoriesMapper {

	CategoryEntity DtoToEntityCategory(CategoryDtoInsert categoryDto);

	CategoryEntity DtoToEntityCategoryUpdate(CategoryDtoOutput categoryDto);

	CategoryDtoOutput EntityToDtoCategory(CategoryEntity categoryEntity);

}
