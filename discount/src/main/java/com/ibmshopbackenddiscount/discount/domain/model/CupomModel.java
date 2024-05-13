package com.ibmshopbackenddiscount.discount.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CupomModel {
    private Long id;
    private String codigo;
    private BigDecimal percentual;
    private Integer qtdMinimaProdutos;
    private BigDecimal valorMinimoPedido;
    private BigDecimal descontoMaximo;
    private LocalDate dataCriacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private LocalDate dataExpiracao;
    private Boolean ativo;

    @Override
    public String toString() {
        return "CupomModel{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", percentual=" + percentual +
                ", qtdMinimaProdutos=" + qtdMinimaProdutos +
                ", valorMinimoPedido=" + valorMinimoPedido +
                ", descontoMaximo=" + descontoMaximo +
                ", dataCriacao=" + dataCriacao +
                ", dataExpiracao=" + dataExpiracao +
                ", ativo=" + ativo +
                '}';
    }
}
