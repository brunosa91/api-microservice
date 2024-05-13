package com.ibmshopbackenddiscount.discount.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CupomResponse {

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
        return "CupomResponse{" +
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
