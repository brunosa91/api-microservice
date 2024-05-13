package com.ibmshop.api.app.dto.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ibmshop.api.app.dto.input.DetalhePedidoDtoInserir;
import com.ibmshop.api.domain.entity.DetalhePedido;
import com.ibmshop.api.domain.entity.Status;

import io.github.resilience4j.core.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDtoListar {

	private Long id;
	private Long userId;

	private LocalDateTime data_criacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")

	private LocalDateTime data_modificacao;
	private Status statusPedido = Status.AGPAGAMENTO;
	private BigDecimal total;
	private List<DetalhePedidoDtoListar> detalhesPedido;

}
