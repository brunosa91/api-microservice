package com.ibmshop.productsapi.app.service.manutencao;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibmshop.productsapi.app.dto.input.ProductDtoInsert;
import com.ibmshop.productsapi.app.dto.input.ProductDtoUpdate;
import com.ibmshop.productsapi.app.dto.output.ProductDtoOutput;
import com.ibmshop.productsapi.app.mapper.ProductMapperImpl;
import com.ibmshop.productsapi.app.service.consultation.ProductConsultationService;
import com.ibmshop.productsapi.cross.ValidationItemExist;
import com.ibmshop.productsapi.domain.model.ProductEntity;
import com.ibmshop.productsapi.domain.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductMaintenanceService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductConsultationService productConsultationService;
	@Autowired
	private ProductMapperImpl productMapper;

	@Transactional
	public ProductEntity insert(ProductDtoInsert obj) {

		Optional<ProductEntity> opProductInsert = productRepository.findBySku(obj.getSku());
		if (opProductInsert.isPresent()) {
			throw new ValidationItemExist("SKU",
					"Não foi possível cadastrar um SKU. Já existe um SKU cadastrado no sistema. Verifique e tente novamente");
		}
		obj.setData_criacao(LocalDateTime.now());
		ProductEntity productEntity = productMapper.DtotoEntityProduct(obj);

		return productRepository.save(productEntity);
	}

	@Transactional
	public void update(ProductDtoUpdate obj, Long id) {

		ProductDtoOutput newObj = productConsultationService.findById(obj.getId());

		updateData(newObj, obj);

		ProductEntity ObjDtoToEntity = productMapper.DtotoEntityProductUpdate(newObj);

		productRepository.save(ObjDtoToEntity);

	}

	@Transactional
	private void updateData(ProductDtoOutput newObj, ProductDtoUpdate obj) {
		newObj.setNome_produto(obj.getNome_produto());
		newObj.setDescricao(obj.getDescricao());
		newObj.setSku(obj.getSku());
		newObj.setEstoque(obj.getEstoque());
		newObj.setValor_unitario(obj.getValor_unitario());

	}

	public void delete(Long id) {
		ProductDtoOutput ObjProduct = productConsultationService.findById(id);

		ProductEntity ObjDtoToEntity = productMapper.DtotoEntityProductUpdate(ObjProduct);

		productRepository.delete(ObjDtoToEntity);

	}

}
