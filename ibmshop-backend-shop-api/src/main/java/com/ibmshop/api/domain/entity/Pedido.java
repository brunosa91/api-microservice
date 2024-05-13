package com.ibmshop.api.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Long userId;
	@Column(nullable = true, updatable = false)
	private LocalDateTime data_criacao;
	@Column
	private LocalDateTime data_modificacao;
	
	@Column
   @Enumerated(EnumType.STRING)
    private Status statusPedido = Status.AGPAGAMENTO;
    
    @Column
    private BigDecimal total;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetalhePedido> detalhesPedido = new ArrayList<>();
	

}
