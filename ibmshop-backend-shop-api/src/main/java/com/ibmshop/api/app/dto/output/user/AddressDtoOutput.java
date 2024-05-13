package com.ibmshop.api.app.dto.output.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDtoOutput  {
	

	private Long id;
	
	private String rua;

	private String numero;

	private String cep;

	private String complemento;

	private String bairro;

	private String cidade;


	private String estado;

	@JsonProperty("pais")
	CountryDtoOutput country;

	
}
