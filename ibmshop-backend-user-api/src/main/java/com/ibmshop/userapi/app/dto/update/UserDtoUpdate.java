package com.ibmshop.userapi.app.dto.update;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ibmshop.userapi.domain.entities.Address;
import com.ibmshop.userapi.domain.entities.UserEntity;

import jakarta.validation.Valid;
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
public class UserDtoUpdate {

	private Long id;
	
	@Size(min = 2, max = 50, message = " Nomes menores do que 2 caracteres e maiores do que 50 caracteres são considerados inválidos\r\n")
	private String nome;
	
	
	@Size(min = 2, max = 255, message = " sobreNomes menores do que 2 caracteres e maiores do que 255 caracteres são considerados inválidos\r\n")
	private String sobrenome;
	
	
	@Size(min = 11, max = 11, message = "CPF inválido, por gentileza digitar  no formato: xxxxxxxxxxx ")
	@CPF(message = "CPF inválido ")
	private String cpf;

	private String email;

	@Pattern(regexp = "^\\([1-9]{2}\\)(?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", message = "Telefone inválido. (xx) xxxxx-xxxx")
	private String telefone;

	private Boolean ativo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime data_criacao;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime data_modificacao;
	
	@Valid
	@JsonAlias("endereco")
	List<AddressDtoUpdate> address = new ArrayList<>();

	

}
