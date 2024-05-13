package com.ibmshopbackenddiscount.discount.domain.usecases;

import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;

public interface UpdateCupom {
    CupomModel updateCupom(CupomModel cupomModel, Long id);
}
