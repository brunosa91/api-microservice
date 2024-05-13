package com.ibmshop.productsapi.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_table")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true, unique = false)
	private String nome_produto;

	@Column(nullable = true, unique = false)
	private String descricao;

	@Column(nullable = true, unique = false)
	private Integer sku;

	@Column(nullable = true, unique = false)
	private Integer estoque;

	@Column(nullable = true, unique = false)
	private Float valor_unitario;

	@Column(nullable = true, updatable = false)
	private LocalDateTime data_criacao;

	@JoinColumn(name = "id_sub_category")
	@ManyToOne
	SubCategoryEntity subCategoryEntity;


}
