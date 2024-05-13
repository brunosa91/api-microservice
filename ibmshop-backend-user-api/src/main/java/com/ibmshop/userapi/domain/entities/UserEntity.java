package com.ibmshop.userapi.domain.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "user_table")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = false)
	private String nome;

	@Column(nullable = false, unique = false)
	private String sobrenome;

	@Column(nullable = false, unique = true)
	private String cpf;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = false)
	private String telefone;

	@Column(nullable = true, updatable = true)
	private Boolean ativo;

	@Column(nullable = true, updatable = false)
	private LocalDateTime data_criacao;

	@Column(nullable = true)
	private LocalDateTime data_modificacao;

	@PrimaryKeyJoinColumn(name = "id_address")
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
	@JsonIgnore
	List<Address> address = new ArrayList<>();


}
