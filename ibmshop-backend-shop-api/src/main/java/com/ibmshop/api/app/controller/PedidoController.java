package com.ibmshop.api.app.controller;

import java.net.URI;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibmshop.api.app.dto.input.PedidoDtoInserir;
import com.ibmshop.api.app.dto.output.PedidoDtoListar;
import com.ibmshop.api.app.service.consultation.PedidoServiceConsultation;
import com.ibmshop.api.app.service.maintenance.PedidoServiceManitenane;
import com.ibmshop.api.cross.StandarError;
import com.ibmshop.api.domain.entity.Pedido;
import com.ibmshop.api.domain.entity.Status;

import feign.Feign;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	PedidoServiceConsultation consultation;
	@Autowired
	PedidoServiceManitenane pedidoServiceManitenane;
	
	
	@CircuitBreaker(name = "findAll", fallbackMethod = "returnFallback")
	@GetMapping
	public ResponseEntity<List<PedidoDtoListar>> findAll() {
		return ResponseEntity.ok(consultation.findAll());
	}


	@CircuitBreaker(name = "findById", fallbackMethod = "returnFallback")
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDtoListar> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(consultation.findById(id));
	}

	@GetMapping("/status{status}")
	public ResponseEntity<PedidoDtoListar> findByStatus(@RequestParam Status status) {
		// Status statusPedido = Status.valueOfInt(status);
		return ResponseEntity.ok().body(consultation.findByStatus(status));
	}

	@CircuitBreaker(name = "insert", fallbackMethod = "returnFallback")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PedidoDtoInserir> insert(@RequestBody @Valid PedidoDtoInserir objDto) {

		Pedido obj = pedidoServiceManitenane.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CircuitBreaker(name = "updateUserActive", fallbackMethod = "returnFallback")
	@PutMapping("/cancelar/{id}")
	public ResponseEntity<String> updateUserActive(@RequestBody PedidoDtoListar objDto, @PathVariable Long id) {
		objDto.setId(id);
		consultation.cancelarPedido(objDto);
		return ResponseEntity.ok().body("pedido alterado com sucesso");
	}
	
	public ResponseEntity<String> returnFallback(FeignException e) {
		log.debug(MessageFormat.format("Erro ao tentar acessar a API de usuario: id :{0} {1}", e));
		return ResponseEntity.ok("Serviço de usuário ou de produto está fora do Ar, tente mais tarde");
	}

}
