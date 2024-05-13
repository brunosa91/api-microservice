package com.ibmshop.api.app.dto.output.product;

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


	private String nome_categoria;

	private List<SubCategoryDtoOutput> subCategory = new ArrayList<>();

}
