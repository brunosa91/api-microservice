package com.ibmshopbackenddiscount.discount.domain.gateway;

import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;

public interface CupomGateway {

    CupomModel saveCupomGateway(CupomModel cupomModel);

    CupomModel findCumpomGatewayById(Long id);

    CupomModel updateCupomGateway(CupomModel cupomModel, Long id);

    CupomModel desativarCupomGateway(CupomModel cupomModel, Long id);
}
