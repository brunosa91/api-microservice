package com.ibmshop.productsapi.app.mapper;

import com.ibmshop.productsapi.app.dto.input.ProductDtoInsert;
import com.ibmshop.productsapi.app.dto.output.ProductDtoOutput;
import com.ibmshop.productsapi.domain.model.ProductEntity;
import com.ibmshop.productsapi.domain.model.SubCategoryEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T15:23:58-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity DtotoEntityProduct(ProductDtoInsert productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setSubCategoryEntity( productDtoInsertToSubCategoryEntity( productDto ) );
        productEntity.setId( productDto.getId() );
        productEntity.setNome_produto( productDto.getNome_produto() );
        productEntity.setDescricao( productDto.getDescricao() );
        productEntity.setSku( productDto.getSku() );
        productEntity.setEstoque( productDto.getEstoque() );
        productEntity.setValor_unitario( productDto.getValor_unitario() );
        productEntity.setData_criacao( productDto.getData_criacao() );

        return productEntity;
    }

    @Override
    public ProductEntity DtotoEntityProductUpdate(ProductDtoOutput productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setSubCategoryEntity( productDtoOutputToSubCategoryEntity( productDto ) );
        productEntity.setId( productDto.getId() );
        productEntity.setNome_produto( productDto.getNome_produto() );
        productEntity.setDescricao( productDto.getDescricao() );
        productEntity.setSku( productDto.getSku() );
        productEntity.setEstoque( productDto.getEstoque() );
        productEntity.setValor_unitario( productDto.getValor_unitario() );
        productEntity.setData_criacao( productDto.getData_criacao() );

        return productEntity;
    }

    @Override
    public ProductDtoOutput EntityToDtoProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDtoOutput productDtoOutput = new ProductDtoOutput();

        productDtoOutput.setId_sub_category( productEntitySubCategoryEntityId( productEntity ) );
        productDtoOutput.setId( productEntity.getId() );
        productDtoOutput.setNome_produto( productEntity.getNome_produto() );
        productDtoOutput.setDescricao( productEntity.getDescricao() );
        productDtoOutput.setSku( productEntity.getSku() );
        productDtoOutput.setEstoque( productEntity.getEstoque() );
        productDtoOutput.setValor_unitario( productEntity.getValor_unitario() );
        productDtoOutput.setData_criacao( productEntity.getData_criacao() );

        return productDtoOutput;
    }

    protected SubCategoryEntity productDtoInsertToSubCategoryEntity(ProductDtoInsert productDtoInsert) {
        if ( productDtoInsert == null ) {
            return null;
        }

        SubCategoryEntity subCategoryEntity = new SubCategoryEntity();

        subCategoryEntity.setId( productDtoInsert.getId_sub_category() );

        return subCategoryEntity;
    }

    protected SubCategoryEntity productDtoOutputToSubCategoryEntity(ProductDtoOutput productDtoOutput) {
        if ( productDtoOutput == null ) {
            return null;
        }

        SubCategoryEntity subCategoryEntity = new SubCategoryEntity();

        subCategoryEntity.setId( productDtoOutput.getId_sub_category() );

        return subCategoryEntity;
    }

    private Long productEntitySubCategoryEntityId(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }
        SubCategoryEntity subCategoryEntity = productEntity.getSubCategoryEntity();
        if ( subCategoryEntity == null ) {
            return null;
        }
        Long id = subCategoryEntity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
