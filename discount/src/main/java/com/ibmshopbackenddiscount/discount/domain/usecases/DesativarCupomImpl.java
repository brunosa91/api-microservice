package com.ibmshopbackenddiscount.discount.domain.usecases;

import com.ibmshopbackenddiscount.discount.domain.gateway.CupomGateway;
import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DesativarCupomImpl implements DesativarCupom {

    private final CupomGateway cupomGateway;
    @Override
    public CupomModel desativarCupom(CupomModel cupomModel, Long id) {
        return cupomGateway.desativarCupomGateway(cupomModel,id);
    }
}
