package com.ibmshopbackenddiscount.discount.app.service;

import com.ibmshopbackenddiscount.discount.app.dto.CupomRequest;
import com.ibmshopbackenddiscount.discount.app.dto.CupomResponse;

public interface CupomService {

    CupomResponse saveCupomService (CupomRequest dto);

    CupomResponse findCupomById (Long id);

    CupomResponse updateCupom( CupomRequest cupomRequest,Long id);

    CupomResponse desativarCupom(CupomRequest cupomRequest, Long id);





}
