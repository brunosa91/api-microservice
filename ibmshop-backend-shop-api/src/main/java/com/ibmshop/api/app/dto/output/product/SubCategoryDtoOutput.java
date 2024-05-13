package com.ibmshop.api.app.dto.output.product;

import java.util.ArrayList;
import java.util.List;

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
public class SubCategoryDtoOutput {

	private Long id;

	private String nome_sub_categoria;

	private String descricao;

	private List<ProductDtoOutput> productEntity = new ArrayList<>();

	private Long id_category;

}
