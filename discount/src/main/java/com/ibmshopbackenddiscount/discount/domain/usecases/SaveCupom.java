package com.ibmshopbackenddiscount.discount.domain.usecases;

import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;

public interface SaveCupom {

    CupomModel save(CupomModel cupomModel);
}
