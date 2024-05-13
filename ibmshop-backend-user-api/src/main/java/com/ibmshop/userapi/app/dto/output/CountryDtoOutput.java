package com.ibmshop.userapi.app.dto.output;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CountryDtoOutput {

	private Long id;

	//@NotBlank(message = "Campo País é obrigatório")
	@Size(min = 2, max = 50, message = " Nomes menores do que 2 caracteres e maiores do que 50 caracteres são considerados inválidos\r\n")
	private String nome;

	@Min(value = 2, message = " Obrigatório inserir um código do país de até 3 números ")
	@Max(value = 3, message = " Obrigatório inserir um código do país de até 3 números ")
	//@NotNull(message = "Campo código é obrigatório")
	private int codigo;




}
