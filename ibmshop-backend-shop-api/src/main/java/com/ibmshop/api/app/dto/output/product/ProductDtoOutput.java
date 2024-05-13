package com.ibmshop.api.app.dto.output.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.bouncycastle.util.test.FixedSecureRandom.BigInteger;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoOutput {

	private Long id;

	private String nome_produto;

	private String descricao;

	private Integer sku;

	private Integer estoque;

	private  BigDecimal valor_unitario;



}
