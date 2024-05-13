package com.ibmshop.productsapi.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibmshop.productsapi.app.dto.input.ProductDtoInsert;
import com.ibmshop.productsapi.app.dto.input.ProductDtoUpdate;
import com.ibmshop.productsapi.app.dto.output.ProductDtoOutput;
import com.ibmshop.productsapi.app.service.consultation.ProductConsultationService;
import com.ibmshop.productsapi.app.service.manutencao.ProductMaintenanceService;
import com.ibmshop.productsapi.domain.model.ProductEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductConsultationService productConsultationService;

	@Autowired
	private ProductMaintenanceService productMaintenanceService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductDtoOutput>> findAll() {
		return ResponseEntity.ok(productConsultationService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDtoOutput> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productConsultationService.findById(id));
	}

	@GetMapping("/nome{nome}")
	public ResponseEntity<ProductDtoOutput> SearchName(@RequestParam String nome) {
		return ResponseEntity.ok(productConsultationService.findByName(nome));
	}

	@GetMapping("/sku{sku}")
	public ResponseEntity<ProductDtoOutput> SearchSku(@RequestParam Integer sku) {
		return ResponseEntity.ok(productConsultationService.findBySku(sku));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody @Valid ProductDtoInsert objDto) {

		ProductEntity obj = productMaintenanceService.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody @Valid ProductDtoUpdate objDto, @PathVariable Long id) {
		objDto.setId(id);
		productMaintenanceService.update(objDto, id);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		productMaintenanceService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
