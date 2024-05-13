package com.ibmshop.productsapi.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sub_category")

public class SubCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true, unique = false)
	private String nome_sub_categoria;

	@Column(nullable = true, unique = false)
	private String descricao;
	@Column(nullable = true, unique = false)
	private Long id_category;

	@ManyToOne
	@JoinColumn(name = "categoryEntity_id")
	CategoryEntity categoryEntity;

	@PrimaryKeyJoinColumn(name = "id_product")
	@JsonIgnore
	@OneToMany(mappedBy = "subCategoryEntity", cascade = CascadeType.PERSIST)
	private List<ProductEntity> productEntity = new ArrayList<>();

}
