package com.ibmshopbackenddiscount.discount.domain.usecases;

import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;

public interface FindCupomById {
    CupomModel findCupomById(Long id);
}
