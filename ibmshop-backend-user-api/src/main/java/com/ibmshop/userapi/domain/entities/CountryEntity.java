package com.ibmshop.userapi.domain.entities;

import java.util.ArrayList;
import java.util.List;
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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "country_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class CountryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = false)
	private String nome;

	@Column
	private Integer codigo;

	@PrimaryKeyJoinColumn(name = "id_address_country")
	@JsonIgnore
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "country")
	private List<Address> addressEntity = new ArrayList<>();

    public CountryEntity(long id, String nome, int codigo) {
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;

    }

    @Override
	public String toString() {
		return "CountryEntity{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", codigo=" + codigo +
				", addressEntity=" + addressEntity +
				'}';
	}
}
