package com.ibmshop.api.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.bouncycastle.util.test.FixedSecureRandom.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ibmshop.api.app.dto.output.product.ProductDtoOutput;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class DetalhePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id_detalhes_pedido")
	private Long id;

	@Column(name = "id_produto")
	private Long idProduct;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	@Column
	private Integer quantidade;

	@Column
	 private BigDecimal sub_total;

}
