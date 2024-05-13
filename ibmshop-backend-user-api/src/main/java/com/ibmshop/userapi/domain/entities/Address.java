package com.ibmshop.userapi.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "address_table")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false)
    private Boolean padrao;

    @Column(unique = false)
    private String apelido;

    @Column(unique = false)
    private String rua;

    @Column(unique = false)
    private String numero;

    @Column(unique = false)
    private String cep;

    @Column(unique = false)
    private String complemento;

    @Column(unique = false)
    private String bairro;

    @Column(unique = false)
    private String cidade;

    @Column(unique = false)
    private String estado;



    @JoinColumn(name = "idUser")
    @ManyToOne
    UserEntity user;

    @JoinColumn(name = "id_country")
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    CountryEntity country;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", padrao=" + padrao +
                ", apelido='" + apelido + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", cep='" + cep + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", user=" + user +
                ", country=" + country +
                '}';
    }
}
