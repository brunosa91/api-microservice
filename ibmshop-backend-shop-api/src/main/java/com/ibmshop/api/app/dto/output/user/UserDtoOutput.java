package com.ibmshop.api.app.dto.output.user;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoOutput implements Serializable{




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	
	
	private String nome;
	
	private String sobrenome;
	
	private String cpf;
	
	private String telefone;

	private Boolean ativo;
	private LocalDateTime data_criacao;

	private LocalDateTime data_modificacao;
	
	@JsonProperty("endereco")
	List<AddressDtoOutput> address = new ArrayList<>();

	

}
