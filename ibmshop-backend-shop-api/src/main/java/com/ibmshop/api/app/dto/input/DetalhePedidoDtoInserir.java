package com.ibmshop.api.app.dto.input;



import java.math.BigDecimal;

import org.bouncycastle.util.test.FixedSecureRandom.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalhePedidoDtoInserir {

	



	private Long id;


	private Long idProduct;

//	private PedidoDtoInserir pedido;

	private Integer quantidade;
	
	 private BigDecimal sub_total;




}
