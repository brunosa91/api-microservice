package com.ibmshop.productsapi.app.dto.output;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDtoOutput {

	private Long id;

	@NotBlank(message = "O campo nome da categoria é obrigatório")
	@Size(min = 2, max = 45, message = "Nome da categoria deve ter entre 2 e 45 caracteres")
	private String nome_categoria;

	private List<SubCategoryDtoOutput> subCategory = new ArrayList<>();

}
