package com.ibmshopbackenddiscount.discount.domain.usecases;

import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;

public interface DesativarCupom {

    CupomModel desativarCupom(CupomModel cupomModel, Long id);
}
