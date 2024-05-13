package com.ibmshopbackenddiscount.discount.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CupomRequest {

private Long id;
    @NotBlank(message = "Preencha corretamente o campo codigo")
    private String codigo;

    @NotNull(message = "Necessário preencher o campo percentual")
    private BigDecimal percentual;
    private Integer qtdMinimaProdutos;

    private BigDecimal valorMinimoPedido;

    private BigDecimal descontoMaximo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private LocalDate dataExpiracao;

    private Boolean ativo;


    @Override
    public String toString() {
        return "CupomRequest{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", percentual=" + percentual +
                ", qtdMinimaProdutos=" + qtdMinimaProdutos +
                ", valorMinimoPedido=" + valorMinimoPedido +
                ", descontoMaximo=" + descontoMaximo +
                ", dataExpiracao=" + dataExpiracao +
                ", ativo=" + ativo +
                '}';
    }
}
