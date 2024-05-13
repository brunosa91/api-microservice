package com.ibmshopbackenddiscount.discount.domain.usecases;

import com.ibmshopbackenddiscount.discount.domain.gateway.CupomGateway;
import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SaveCupomImpl implements SaveCupom{
    private final CupomGateway cupomGateway;

    @Override
    public CupomModel save(CupomModel cupomModel) {
        return cupomGateway.saveCupomGateway(cupomModel);


    }
}
