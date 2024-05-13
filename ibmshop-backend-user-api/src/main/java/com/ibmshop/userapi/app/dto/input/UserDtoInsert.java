package com.ibmshop.userapi.app.dto.input;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ibmshop.userapi.app.dto.client.UserCredentialDtoInsert;
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
public class UserDtoInsert {



	private Long id;
	
	@NotNull(message = "O campo nome não pode ser null")
	@NotBlank(message = "Desculpe, não foi possível realizar a busca por nome. Digite um nome e tente novamente.")
	@Size(min = 2, max = 50, message = " Nomes menores do que 2 caracteres e maiores do que 50 caracteres são considerados inválidos\r\n")
	private String nome;
	
	@NotNull(message = "O campo Sobrenome Não pode ser null")
	@NotBlank(message = "O Sobrenome é obrigatório")
	@Size(min = 2, max = 255, message = " sobreNomes menores do que 2 caracteres e maiores do que 255 caracteres são considerados inválidos\r\n")
	private String sobrenome;
	
	@NotNull(message = "O campo cpf Não pode ser null")
	@NotBlank(message = "O CPF é obrigatório")
	@Size(min = 11, max = 11, message = "CPF inválido, por gentileza digitar  no formato: xxxxxxxxxxx ")
	@CPF(message = "CPF inválido ")
	private String cpf;

	private String email;

	private String senha;

	@NotNull(message = "O campo Telefone não pode ser null")
	@NotBlank(message = "O Telefone é obrigatório")
	@Pattern(regexp = "^\\([1-9]{2}\\)(?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", message = "Telefone inválido. (xx) xxxxx-xxxx")
	private String telefone;

	private Boolean ativo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime data_criacao;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime data_modificacao;

	
	@Valid
	@JsonProperty("endereco")
	//@NotNull(message = "O campo endereço não pode ser null")
	List<AddressDtoInsert> address = new ArrayList<>();

	
	

}
