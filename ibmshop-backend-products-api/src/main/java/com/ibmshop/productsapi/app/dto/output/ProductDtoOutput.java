package com.ibmshop.productsapi.app.dto.output;

import java.time.LocalDateTime;

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

	@NotBlank(message = "O campo nome_produto é obrigatório")
	@Size(min = 2, max = 45, message = "Nome do produto deve ter entre 2 e 45 caracteres")
	private String nome_produto;

	@Size(min = 15, max = 255, message = "Poxa vida! A descrição fora do tamanho esperado. Digite de 15 a 255 \r\n"
			+ "caracteres.")
	private String descricao;

	@Max(value = 999, message = "Ops! Quantidade inválida, digite um número que não seja maior do que 999. ")
	@Min(value = 111, message = "O valor mínimo \r\n" + "para esse campo é 1.")
	@NotNull(message = "O campo valor_unitário é obrigatório")
	private Integer sku;

	@Min(value = 0, message = "Ops! Quantidade inválida, digite um número que não seja negativo. ")
	@NotNull(message = "O campo estoque é obrigatório")
	private Integer estoque;

	@Min(value = 1, message = "O \r\n" + "O valor não \r\n" + "pode ser igual ou inferior a R$ 0,00.")
	@NotNull(message = "O campo valor_unitário é obrigatório")
	private Float valor_unitario;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime data_criacao;

	@NotNull(message = "id inválido")
	@Min(value = 1, message = "Ops! Quantidade inválida, digite um número que não seja negativo. .")
	private Long id_sub_category;

}
