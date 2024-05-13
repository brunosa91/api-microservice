package com.ibmshop.productsapi.app.mapper;

import com.ibmshop.productsapi.app.dto.input.SubCategoryDtoInsert;
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
public class SubCategoryMapperImpl implements SubCategoryMapper {

    @Override
    public SubCategoryEntity DtotoEntitySubCategory(SubCategoryDtoInsert subCategoryDto) {
        if ( subCategoryDto == null ) {
            return null;
        }

        SubCategoryEntity subCategoryEntity = new SubCategoryEntity();

        subCategoryEntity.setCategoryEntity( subCategoryDtoInsertToCategoryEntity( subCategoryDto ) );
        subCategoryEntity.setId( subCategoryDto.getId() );
        subCategoryEntity.setNome_sub_categoria( subCategoryDto.getNome_sub_categoria() );
        subCategoryEntity.setDescricao( subCategoryDto.getDescricao() );
        subCategoryEntity.setId_category( subCategoryDto.getId_category() );

        return subCategoryEntity;
    }

    @Override
    public SubCategoryEntity DtotoEntitySubCategoryUpdate(SubCategoryDtoOutput subCategoryDto) {
        if ( subCategoryDto == null ) {
            return null;
        }

        SubCategoryEntity subCategoryEntity = new SubCategoryEntity();

        subCategoryEntity.setCategoryEntity( subCategoryDtoOutputToCategoryEntity( subCategoryDto ) );
        subCategoryEntity.setId( subCategoryDto.getId() );
        subCategoryEntity.setNome_sub_categoria( subCategoryDto.getNome_sub_categoria() );
        subCategoryEntity.setDescricao( subCategoryDto.getDescricao() );
        subCategoryEntity.setId_category( subCategoryDto.getId_category() );

        return subCategoryEntity;
    }

    @Override
    public SubCategoryDtoOutput EntitytoDtoSubCategory(SubCategoryEntity subCategoryEntity) {
        if ( subCategoryEntity == null ) {
            return null;
        }

        SubCategoryDtoOutput subCategoryDtoOutput = new SubCategoryDtoOutput();

        subCategoryDtoOutput.setId_category( subCategoryEntityCategoryEntityId( subCategoryEntity ) );
        subCategoryDtoOutput.setId( subCategoryEntity.getId() );
        subCategoryDtoOutput.setNome_sub_categoria( subCategoryEntity.getNome_sub_categoria() );
        subCategoryDtoOutput.setDescricao( subCategoryEntity.getDescricao() );
        subCategoryDtoOutput.setProductEntity( productEntityListToProductDtoOutputList( subCategoryEntity.getProductEntity() ) );

        return subCategoryDtoOutput;
    }

    protected CategoryEntity subCategoryDtoInsertToCategoryEntity(SubCategoryDtoInsert subCategoryDtoInsert) {
        if ( subCategoryDtoInsert == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( subCategoryDtoInsert.getId_category() );

        return categoryEntity;
    }

    protected CategoryEntity subCategoryDtoOutputToCategoryEntity(SubCategoryDtoOutput subCategoryDtoOutput) {
        if ( subCategoryDtoOutput == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( subCategoryDtoOutput.getId_category() );

        return categoryEntity;
    }

    private Long subCategoryEntityCategoryEntityId(SubCategoryEntity subCategoryEntity) {
        if ( subCategoryEntity == null ) {
            return null;
        }
        CategoryEntity categoryEntity = subCategoryEntity.getCategoryEntity();
        if ( categoryEntity == null ) {
            return null;
        }
        Long id = categoryEntity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
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
}
