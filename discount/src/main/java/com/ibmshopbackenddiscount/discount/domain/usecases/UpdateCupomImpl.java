package com.ibmshopbackenddiscount.discount.domain.usecases;

import com.ibmshopbackenddiscount.discount.domain.gateway.CupomGateway;
import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UpdateCupomImpl implements UpdateCupom {
    private final CupomGateway cupomGateway;

    @Override
    public CupomModel updateCupom(CupomModel cupomModel, Long id) {
        return cupomGateway.updateCupomGateway(cupomModel,id);
    }
}
