package com.ibmshopbackenddiscount.discount.app.service;

import com.ibmshopbackenddiscount.discount.app.dto.CupomRequest;
import com.ibmshopbackenddiscount.discount.app.dto.CupomResponse;
import com.ibmshopbackenddiscount.discount.app.mapper.CupomMapper;
import com.ibmshopbackenddiscount.discount.cross.ValidationBadRequest;
import com.ibmshopbackenddiscount.discount.cross.ValidationItemExist;


import com.ibmshopbackenddiscount.discount.domain.usecases.DesativarCupom;
import com.ibmshopbackenddiscount.discount.domain.usecases.FindCupomById;
import com.ibmshopbackenddiscount.discount.domain.usecases.SaveCupom;
import com.ibmshopbackenddiscount.discount.domain.usecases.UpdateCupom;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class CupomServiceImpl implements CupomService {
    private final CupomMapper cupomMapper;

    private final SaveCupom saveCupom;

    private final UpdateCupom updateCupom;

    private final DesativarCupom desativarCupom;

    private final FindCupomById findCupomById;

    @Override
    public CupomResponse saveCupomService(CupomRequest dto) {

        log.info(String.format("ENTRADA  CUPOM REQUEST SAVE NA SERVICE  %s,",dto));

        if(dto.getAtivo() == null  ) {
            throw new ValidationBadRequest("ATIVO","Necessário preencher corretamente o campo ativo");

        }

        CupomResponse cupomResponse = cupomMapper.cupomModeltoDto(saveCupom.save(cupomMapper.dtoToCupomModel(dto)));

        log.info(String.format("RETORNO MAPEADO CUPOM RESPONSE SAVE NA SERVICE  %s,",cupomResponse));




        return cupomResponse;
    }

    @Override
    public CupomResponse findCupomById(Long id) {


        CupomResponse cupomResponse = cupomMapper.cupomModeltoDto(findCupomById.findCupomById(id));

        log.info(String.format("RETORNO MAPEADO CUPOM RESPONSE FIND CUPOM BY ID NA SERVICE  %s,",cupomResponse));

        return cupomResponse;
    }

    @Override
    public CupomResponse updateCupom( CupomRequest cupomRequest,Long id) {
        log.info(String.format("ENTRADA  CUPOM REQUEST UPDATE CUPOM NA SERVICE  %s E O ID %s",cupomRequest,id));

        CupomResponse cupomResponse = cupomMapper.cupomModeltoDto(updateCupom.updateCupom(cupomMapper.dtoToCupomModel(cupomRequest),id));
        log.info(String.format("RETORNO MAPEADO CUPOM RESPONSE UPDATE CUPOM NA SERVICE  %s,",cupomResponse));


        return cupomResponse;
    }

    @Override
    public CupomResponse desativarCupom(CupomRequest cupomRequest, Long id) {
        log.info(String.format("ENTRADA  CUPOM REQUEST DESATIVAR CUPOM NA SERVICE  %s E O ID  %s",cupomRequest,id));

        CupomResponse cupomResponse = cupomMapper.cupomModeltoDto(desativarCupom.desativarCupom(cupomMapper.dtoToCupomModel(cupomRequest),id));
        log.info(String.format("RETORNO MAPEADO CUPOM RESPONSE DESATIVAR CUPOM NA SERVICE  %s,",cupomResponse));

        return cupomResponse;
    }


}
