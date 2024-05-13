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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibmshop.productsapi.app.dto.input.SubCategoryDtoInsert;
import com.ibmshop.productsapi.app.dto.input.SubCategoryDtoUpdate;
import com.ibmshop.productsapi.app.dto.output.SubCategoryDtoOutput;
import com.ibmshop.productsapi.app.service.consultation.SubCategoryConsultationService;
import com.ibmshop.productsapi.app.service.manutencao.SubCategoryMaintenanceService;
import com.ibmshop.productsapi.domain.model.SubCategoryEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/sub")
public class SubCategoryController {

	@Autowired
	private SubCategoryConsultationService subCategoryConsultationService;

	@Autowired
	private SubCategoryMaintenanceService subCategoryMaintenanceService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SubCategoryDtoOutput>> findAll() {

		return ResponseEntity.ok(subCategoryConsultationService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<SubCategoryDtoOutput> findById(@PathVariable Long id) {
		;
		return ResponseEntity.ok().body(subCategoryConsultationService.findById(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody @Valid SubCategoryDtoInsert objDto) {
		SubCategoryEntity obj = subCategoryMaintenanceService.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody @Valid SubCategoryDtoUpdate objDto, @PathVariable Long id) {
		objDto.setId(id);
		subCategoryMaintenanceService.update(objDto, id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		subCategoryMaintenanceService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
