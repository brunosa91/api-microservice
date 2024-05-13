package com.ibmshopbackenddiscount.discount.domain.usecases;

import com.ibmshopbackenddiscount.discount.domain.gateway.CupomGateway;
import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindCupomByIdImpl implements FindCupomById{
    private final CupomGateway cupomGateway;
    @Override
    public CupomModel findCupomById(Long id) {
        return  cupomGateway.findCumpomGatewayById(id);
    }
}
