package com.ibmshop.productsapi.app.service.consultation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibmshop.productsapi.app.dto.output.ProductDtoOutput;
import com.ibmshop.productsapi.app.mapper.ProductMapper;
import com.ibmshop.productsapi.domain.model.ProductEntity;
import com.ibmshop.productsapi.domain.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProductConsultationService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductMapper productMapper;

	public List<ProductDtoOutput> findAll() {
		List<ProductEntity> productsList = productRepository.findAll();
		List<ProductDtoOutput> ProductsDtoList = productsList.stream().map(productMapper::EntityToDtoProduct)
				.collect(Collectors.toList());
		if (ProductsDtoList.isEmpty()) {
			throw new EntityNotFoundException("Ops! Ainda não há produtos cadastradas");
		}
		return ProductsDtoList;
	}

	@Transactional
	public ProductDtoOutput findById(Long id) {
		Optional<ProductEntity> obj = productRepository.findById(id);
		if (obj.isEmpty())
			throw new EntityNotFoundException(
					"Desculpe, não foi possível encontrar um produto com este id. Verifique e tente novamente.");

		ProductDtoOutput ObjToDto = productMapper.EntityToDtoProduct(obj.get());
		return ObjToDto;

	}

	@Transactional
	public ProductDtoOutput findByName(String nome) {
		Optional<ProductEntity> opProductName = productRepository.findByNome(nome);
		if (opProductName.isEmpty())
			throw new EntityNotFoundException(
					"Não foi possível encontrar um produto com este Nome. Verifique e tente novamente.");

		ProductDtoOutput objDto = productMapper.EntityToDtoProduct(opProductName.get());
		return objDto;

	}

	@Transactional
	public ProductDtoOutput findBySku(Integer sku) {
		Optional<ProductEntity> opProductSku = productRepository.findBySku(sku);
		if (opProductSku.isEmpty())
			throw new EntityNotFoundException(
					"Não foi possível encontrar um produto com este SKU. Verifique e tente novamente.");

		ProductDtoOutput objDto = productMapper.EntityToDtoProduct(opProductSku.get());
		return objDto;

	}

}
