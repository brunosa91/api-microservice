package com.ibmshop.productsapi.app.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryDtoInsert {

	private Long id;

	@NotBlank(message = "O campo nome da sub categoria é obrigatório")
	@Size(min = 2, max = 45, message = "Nome da sub categoria deve ter entre 2 e 45 caracteres")
	private String nome_sub_categoria;

	@Size(min = 2, max = 255, message = "descricao da sub categoria deve ter entre 15 e 255 caracteres")
	private String descricao;

	private Long id_category;

}
