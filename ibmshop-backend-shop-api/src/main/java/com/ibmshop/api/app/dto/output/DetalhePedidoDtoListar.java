package com.ibmshop.api.app.dto.output;


import java.math.BigDecimal;

import com.ibmshop.api.app.dto.input.PedidoDtoInserir;
import com.ibmshop.api.app.dto.output.product.ProductDtoOutput;

import org.bouncycastle.util.test.FixedSecureRandom.BigInteger;

import com.ibmshop.api.domain.entity.Pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalhePedidoDtoListar {

	



	private Long id;


	private ProductDtoOutput product;
	

	//private PedidoDtoListar pedido;

	private Integer quantidade;

	 private BigDecimal sub_total;



}
