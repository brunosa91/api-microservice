package com.ibmshopbackenddiscount.discount.service;

import com.ibmshopbackenddiscount.discount.app.dto.CupomResponse;
import com.ibmshopbackenddiscount.discount.app.mapper.CupomMapper;
import com.ibmshopbackenddiscount.discount.app.service.CupomService;
import com.ibmshopbackenddiscount.discount.app.service.CupomServiceImpl;
import com.ibmshopbackenddiscount.discount.domain.usecases.DesativarCupom;
import com.ibmshopbackenddiscount.discount.domain.usecases.FindCupomById;
import com.ibmshopbackenddiscount.discount.domain.usecases.SaveCupom;
import com.ibmshopbackenddiscount.discount.domain.usecases.UpdateCupom;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.ibmshopbackenddiscount.discount.constant.constantCupom.*;


import java.util.Optional;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ServiceCupomTest {

    @Mock
    private CupomMapper cupomMapper;

    @Mock
    private SaveCupom saveCupom;

    @Mock
    private UpdateCupom updateCupom;

    @Mock
    private DesativarCupom desativarCupom;

    @Mock
    private FindCupomById findCupomById;

    @InjectMocks
    private CupomServiceImpl cupomService;

    @Test
    public void createCupom(){


        when(cupomMapper.cupomModeltoDto(saveCupom.save(cupomMapper.dtoToCupomModel(CUPOM_REQUEST)))).thenReturn(CUPOM_RESPONSE);

        CupomResponse sut = cupomService.saveCupomService(CUPOM_REQUEST);
        Assertions.assertThat(sut).isEqualTo(CUPOM_RESPONSE);

    }

    @Test
    public void testFindById() {

        when(cupomMapper.cupomModeltoDto(findCupomById.findCupomById(1L))).thenReturn(CUPOM_RESPONSE);

         CupomResponse result = cupomService.findCupomById(1l);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo(CUPOM_RESPONSE);


    }

    @Test
    public void UpdateCupom_WithValidData(){

        when(cupomMapper.cupomModeltoDto(updateCupom.updateCupom(cupomMapper.dtoToCupomModel(CUPOM_REQUEST),1L))).thenReturn(CUPOM_RESPONSE)
        ;

       CupomResponse result = cupomService.updateCupom(CUPOM_REQUEST,1L);

        Assertions.assertThat(result).isNotNull();

        Assertions.assertThatNoException().isThrownBy(()->cupomService.updateCupom(CUPOM_REQUEST, 1l));

    }


    @Test
    public void UpdateIsActiveCupom_WithValidData(){

        when(cupomMapper.cupomModeltoDto(desativarCupom.desativarCupom(cupomMapper.dtoToCupomModel(CUPOM_REQUEST),1L))).thenReturn(CUPOM_RESPONSE)
        ;

        CupomResponse result = cupomService.desativarCupom(CUPOM_REQUEST,1L);

        Assertions.assertThat(result).isNotNull();

        Assertions.assertThatNoException().isThrownBy(()->cupomService.desativarCupom(CUPOM_REQUEST, 1l));

    }


}
