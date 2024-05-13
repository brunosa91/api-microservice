package com.ibmshop.productsapi.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibmshop.productsapi.app.dto.input.CategoryDtoInsert;
import com.ibmshop.productsapi.app.dto.input.CategoryDtoUpdate;
import com.ibmshop.productsapi.app.dto.output.CategoryDtoOutput;
import com.ibmshop.productsapi.app.mapper.CategoriesMapperImpl;
import com.ibmshop.productsapi.app.service.consultation.CategoryConsultationService;
import com.ibmshop.productsapi.app.service.manutencao.CategoryMaintenanceService;
import com.ibmshop.productsapi.domain.model.CategoryEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryConsultationService categoryConsultationService;

	@Autowired
	private CategoryMaintenanceService categoryMaintenanceService;

	@Autowired
	private CategoriesMapperImpl categoryMapper;

	@GetMapping
	public ResponseEntity<List<CategoryDtoOutput>> findAll() {

		return ResponseEntity.ok(categoryConsultationService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDtoOutput> findById(@PathVariable Long id) {

		return ResponseEntity.ok().body(categoryConsultationService.findById(id));
	}

	@GetMapping("/nome{nome}")
	public ResponseEntity<CategoryDtoOutput> SearchName(@RequestParam String nome) {

		return ResponseEntity.ok(categoryConsultationService.findByName(nome));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody @Valid CategoryDtoInsert objDto) {
		CategoryEntity obj = categoryMapper.DtoToEntityCategory(objDto);
		obj = categoryMaintenanceService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody @Valid CategoryDtoUpdate objDto, @PathVariable Long id) {
		objDto.setId(id);
		categoryMaintenanceService.update(objDto, id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		categoryMaintenanceService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
