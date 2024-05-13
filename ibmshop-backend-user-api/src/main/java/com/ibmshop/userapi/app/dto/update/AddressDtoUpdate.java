package com.ibmshop.userapi.app.dto.update;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.ibmshop.userapi.app.dto.input.UserDtoInsert;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AddressDtoUpdate  {

	private Long id;

	//@NotBlank(message = "Campo padrao é obrigatório")
	private Boolean padrao;

	@NotBlank(message = "Campo Apelido é obrigatório")
	@Size(min = 2, max = 45, message = "Máximo de caractes para apelido é 45")
	private String apelido;


	@Size(min = 2, max = 45, message = "Máximo de caractes para rua é 45")
	private String rua;

	@Size(max = 10, message = "Máximo de caracteres para Número é 10")
	// @Pattern(regexp = "(\\\\d{5})-?(\\\\d{3})", message = "campo Número
	// inválido")
	private String numero;

	@Pattern(regexp = "(\\d{5})-?(\\d{3})", message = "campo cep deve seguir o formato  xxxxx-xxx")
	private String cep;

	private String complemento;

	@Size(min = 2, max = 45, message = "Máximo de caractes para bairro é 45")
	private String bairro;

	@Size(min = 2, max = 45, message = "Máximo de caractes para Cidade é 45")
	private String cidade;

	@Size(min = 2, max = 45, message = "Máximo de caractes para Estado é 45")

	private String estado;

	private Long idUser;

	private UserDtoUpdate user;


	private  Long idCountry;




}
