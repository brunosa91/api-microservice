package com.ibmshop.productsapi.app.mapper;

import com.ibmshop.productsapi.app.dto.input.CategoryDtoInsert;
import com.ibmshop.productsapi.app.dto.input.SubCategoryDtoInsert;
import com.ibmshop.productsapi.app.dto.output.CategoryDtoOutput;
import com.ibmshop.productsapi.app.dto.output.ProductDtoOutput;
import com.ibmshop.productsapi.app.dto.output.SubCategoryDtoOutput;
import com.ibmshop.productsapi.domain.model.CategoryEntity;
import com.ibmshop.productsapi.domain.model.ProductEntity;
import com.ibmshop.productsapi.domain.model.SubCategoryEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T15:23:58-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class CategoriesMapperImpl implements CategoriesMapper {

    @Override
    public CategoryEntity DtoToEntityCategory(CategoryDtoInsert categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( categoryDto.getId() );
        categoryEntity.setNome_categoria( categoryDto.getNome_categoria() );
        categoryEntity.setSubCategory( subCategoryDtoInsertListToSubCategoryEntityList( categoryDto.getSubCategory() ) );

        return categoryEntity;
    }

    @Override
    public CategoryEntity DtoToEntityCategoryUpdate(CategoryDtoOutput categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( categoryDto.getId() );
        categoryEntity.setNome_categoria( categoryDto.getNome_categoria() );
        categoryEntity.setSubCategory( subCategoryDtoOutputListToSubCategoryEntityList( categoryDto.getSubCategory() ) );

        return categoryEntity;
    }

    @Override
    public CategoryDtoOutput EntityToDtoCategory(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryDtoOutput categoryDtoOutput = new CategoryDtoOutput();

        categoryDtoOutput.setId( categoryEntity.getId() );
        categoryDtoOutput.setNome_categoria( categoryEntity.getNome_categoria() );
        categoryDtoOutput.setSubCategory( subCategoryEntityListToSubCategoryDtoOutputList( categoryEntity.getSubCategory() ) );

        return categoryDtoOutput;
    }

    protected SubCategoryEntity subCategoryDtoInsertToSubCategoryEntity(SubCategoryDtoInsert subCategoryDtoInsert) {
        if ( subCategoryDtoInsert == null ) {
            return null;
        }

        SubCategoryEntity subCategoryEntity = new SubCategoryEntity();

        subCategoryEntity.setId( subCategoryDtoInsert.getId() );
        subCategoryEntity.setNome_sub_categoria( subCategoryDtoInsert.getNome_sub_categoria() );
        subCategoryEntity.setDescricao( subCategoryDtoInsert.getDescricao() );
        subCategoryEntity.setId_category( subCategoryDtoInsert.getId_category() );

        return subCategoryEntity;
    }

    protected List<SubCategoryEntity> subCategoryDtoInsertListToSubCategoryEntityList(List<SubCategoryDtoInsert> list) {
        if ( list == null ) {
            return null;
        }

        List<SubCategoryEntity> list1 = new ArrayList<SubCategoryEntity>( list.size() );
        for ( SubCategoryDtoInsert subCategoryDtoInsert : list ) {
            list1.add( subCategoryDtoInsertToSubCategoryEntity( subCategoryDtoInsert ) );
        }

        return list1;
    }

    protected ProductEntity productDtoOutputToProductEntity(ProductDtoOutput productDtoOutput) {
        if ( productDtoOutput == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( productDtoOutput.getId() );
        productEntity.setNome_produto( productDtoOutput.getNome_produto() );
        productEntity.setDescricao( productDtoOutput.getDescricao() );
        productEntity.setSku( productDtoOutput.getSku() );
        productEntity.setEstoque( productDtoOutput.getEstoque() );
        productEntity.setValor_unitario( productDtoOutput.getValor_unitario() );
        productEntity.setData_criacao( productDtoOutput.getData_criacao() );

        return productEntity;
    }

    protected List<ProductEntity> productDtoOutputListToProductEntityList(List<ProductDtoOutput> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductEntity> list1 = new ArrayList<ProductEntity>( list.size() );
        for ( ProductDtoOutput productDtoOutput : list ) {
            list1.add( productDtoOutputToProductEntity( productDtoOutput ) );
        }

        return list1;
    }

    protected SubCategoryEntity subCategoryDtoOutputToSubCategoryEntity(SubCategoryDtoOutput subCategoryDtoOutput) {
        if ( subCategoryDtoOutput == null ) {
            return null;
        }

        SubCategoryEntity subCategoryEntity = new SubCategoryEntity();

        subCategoryEntity.setId( subCategoryDtoOutput.getId() );
        subCategoryEntity.setNome_sub_categoria( subCategoryDtoOutput.getNome_sub_categoria() );
        subCategoryEntity.setDescricao( subCategoryDtoOutput.getDescricao() );
        subCategoryEntity.setId_category( subCategoryDtoOutput.getId_category() );
        subCategoryEntity.setProductEntity( productDtoOutputListToProductEntityList( subCategoryDtoOutput.getProductEntity() ) );

        return subCategoryEntity;
    }

    protected List<SubCategoryEntity> subCategoryDtoOutputListToSubCategoryEntityList(List<SubCategoryDtoOutput> list) {
        if ( list == null ) {
            return null;
        }

        List<SubCategoryEntity> list1 = new ArrayList<SubCategoryEntity>( list.size() );
        for ( SubCategoryDtoOutput subCategoryDtoOutput : list ) {
            list1.add( subCategoryDtoOutputToSubCategoryEntity( subCategoryDtoOutput ) );
        }

        return list1;
    }

    protected ProductDtoOutput productEntityToProductDtoOutput(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDtoOutput productDtoOutput = new ProductDtoOutput();

        productDtoOutput.setId( productEntity.getId() );
        productDtoOutput.setNome_produto( productEntity.getNome_produto() );
        productDtoOutput.setDescricao( productEntity.getDescricao() );
        productDtoOutput.setSku( productEntity.getSku() );
        productDtoOutput.setEstoque( productEntity.getEstoque() );
        productDtoOutput.setValor_unitario( productEntity.getValor_unitario() );
        productDtoOutput.setData_criacao( productEntity.getData_criacao() );

        return productDtoOutput;
    }

    protected List<ProductDtoOutput> productEntityListToProductDtoOutputList(List<ProductEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductDtoOutput> list1 = new ArrayList<ProductDtoOutput>( list.size() );
        for ( ProductEntity productEntity : list ) {
            list1.add( productEntityToProductDtoOutput( productEntity ) );
        }

        return list1;
    }

    protected SubCategoryDtoOutput subCategoryEntityToSubCategoryDtoOutput(SubCategoryEntity subCategoryEntity) {
        if ( subCategoryEntity == null ) {
            return null;
        }

        SubCategoryDtoOutput subCategoryDtoOutput = new SubCategoryDtoOutput();

        subCategoryDtoOutput.setId( subCategoryEntity.getId() );
        subCategoryDtoOutput.setNome_sub_categoria( subCategoryEntity.getNome_sub_categoria() );
        subCategoryDtoOutput.setDescricao( subCategoryEntity.getDescricao() );
        subCategoryDtoOutput.setProductEntity( productEntityListToProductDtoOutputList( subCategoryEntity.getProductEntity() ) );
        subCategoryDtoOutput.setId_category( subCategoryEntity.getId_category() );

        return subCategoryDtoOutput;
    }

    protected List<SubCategoryDtoOutput> subCategoryEntityListToSubCategoryDtoOutputList(List<SubCategoryEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SubCategoryDtoOutput> list1 = new ArrayList<SubCategoryDtoOutput>( list.size() );
        for ( SubCategoryEntity subCategoryEntity : list ) {
            list1.add( subCategoryEntityToSubCategoryDtoOutput( subCategoryEntity ) );
        }

        return list1;
    }
}
