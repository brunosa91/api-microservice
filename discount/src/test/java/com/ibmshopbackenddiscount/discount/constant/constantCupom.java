package com.ibmshopbackenddiscount.discount.constant;

import com.ibmshopbackenddiscount.discount.app.dto.CupomRequest;
import com.ibmshopbackenddiscount.discount.app.dto.CupomResponse;
import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;
import com.ibmshopbackenddiscount.discount.infra.entity.CupomEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class  constantCupom {

    private static final LocalDate DATA_CRIACAO = LocalDate.of(2023, 7, 23);

    private static final LocalDate DATA_ATUALIZACAO = LocalDate.of(2023, 9, 23);


    public static final CupomRequest CUPOM_REQUEST = new CupomRequest(1L,"1LL", BigDecimal.valueOf(1.2),5,BigDecimal.valueOf(2),BigDecimal.valueOf(2),DATA_CRIACAO,true);
    public static final CupomResponse CUPOM_RESPONSE = new CupomResponse(1l,"1LL", BigDecimal.valueOf(1.2),5,BigDecimal.valueOf(2),BigDecimal.valueOf(2),DATA_CRIACAO,DATA_ATUALIZACAO,true);

    public static final CupomModel CUPOM_MODEL = new CupomModel(1l,"1LL", BigDecimal.valueOf(1.2),5,BigDecimal.valueOf(2),BigDecimal.valueOf(2),DATA_CRIACAO,DATA_ATUALIZACAO,true);
    public static final CupomEntity CUPOM_ENTITY = new CupomEntity(1l,"1LL", BigDecimal.valueOf(1.2),5,BigDecimal.valueOf(2),BigDecimal.valueOf(2),DATA_CRIACAO,DATA_ATUALIZACAO,true);

}
