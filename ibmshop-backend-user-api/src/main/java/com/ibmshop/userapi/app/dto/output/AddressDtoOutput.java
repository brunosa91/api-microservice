package com.ibmshop.userapi.app.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibmshop.userapi.app.dto.input.UserDtoInsert;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDtoOutput  {
	

	private Long id;
	
	@NotBlank(message = "Campo padrao é obrigatório")
	private Boolean padrao;
	
	@NotBlank(message = "Campo Apelido é obrigatório")
	@Size(min = 2, max = 45, message = "Máximo de caractes para apelido é 45")
	private String apelido;
	
	@NotBlank(message = "Campo rua é obrigatório")
	@Size(min = 2, max = 45, message = "Máximo de caractes para rua é 45")
	private String rua;

	@NotNull(message = "O campo Número é obrigatório")
	@Size(max = 10, message = "Máximo de caracteres para Número é 10")
	@Pattern(regexp = "^[0-9]{0,8}[a-zA-Z]{0,1}$", message = "Campo Número inválido")
	private String numero;

	@NotBlank(message = "O campo Cep é obrigatório")
	@Pattern(regexp = "(\\d{5})-?(\\d{3})", message = "campo cep deve seguir o formato  xxxxx-xxx")
	private String cep;

	private String complemento;

	@NotBlank(message = "O campo Bairro é obrigatório")
	@Size(min = 2, max = 45, message = "Máximo de caractes para bairro é 45")
	private String bairro;

	@NotBlank(message = "O campo Cidade é obrigatório")
	@Size(min = 2, max = 45, message = "Máximo de caractes para Cidade é 45")
	private String cidade;

	@NotBlank(message = "O campo estado é obrigatório")
	@Size(min = 2, max = 45, message = "Máximo de caractes para Estado é 45")

	private String estado;
	
	private Long idUser;

	private UserDtoOutput user;



	@JsonProperty("pais")
	CountryDtoOutput country;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AddressDtoOutput that = (AddressDtoOutput) o;
		return Objects.equals(id, that.id) && Objects.equals(padrao, that.padrao) && Objects.equals(apelido, that.apelido) && Objects.equals(rua, that.rua) && Objects.equals(numero, that.numero) && Objects.equals(cep, that.cep) && Objects.equals(complemento, that.complemento) && Objects.equals(bairro, that.bairro) && Objects.equals(cidade, that.cidade) && Objects.equals(estado, that.estado) && Objects.equals(idUser, that.idUser) && Objects.equals(user, that.user) && Objects.equals(country, that.country);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, padrao, apelido, rua, numero, cep, complemento, bairro, cidade, estado, idUser, user, country);
	}
}
