package com.ibmshopbackenddiscount.discount.infra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_cupom")
public class CupomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(unique = true,nullable = false)
    private String codigo;
    @Column
    private BigDecimal percentual;
    @Column
    private Integer qtdMinimaProdutos;
    @Column
    private BigDecimal valorMinimoPedido;
    @Column
    private BigDecimal descontoMaximo;
    @Column
    private LocalDate dataCriacao;
    @Column
    private LocalDate dataExpiracao;
    @Column
    private Boolean ativo;
}
