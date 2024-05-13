package com.ibmshop.api.app.dto.input;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ibmshop.api.domain.entity.DetalhePedido;
import com.ibmshop.api.domain.entity.Status;

import io.github.resilience4j.core.lang.NonNull;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDtoInserir {

	private Long id;

	private Long userId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime data_criacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime data_modificacao;

	private Status statusPedido = Status.AGPAGAMENTO;

	private BigDecimal total;

	@NonNull
	private List<DetalhePedidoDtoInserir> detalhesPedido = new ArrayList<>();

}
