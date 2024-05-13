package com.ibmshopbackenddiscount.discount.infra;

import com.ibmshopbackenddiscount.discount.app.dto.CupomResponse;
import com.ibmshopbackenddiscount.discount.app.mapper.CupomMapper;
import com.ibmshopbackenddiscount.discount.app.mapper.CupomMapperImpl;
import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;
import com.ibmshopbackenddiscount.discount.infra.dataprovider.DataProviderMapper;
import com.ibmshopbackenddiscount.discount.infra.dataprovider.DataproviderCupom;
import com.ibmshopbackenddiscount.discount.infra.repository.CupomRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.ibmshopbackenddiscount.discount.constant.constantCupom.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class DataProviderTest {

    @Mock
    private CupomRepository cupomRepository;

    @Mock
    private DataProviderMapper cupomMapper;

    @InjectMocks
    private DataproviderCupom dataproviderCupom;

    @Test
    public void createCupom() {


        when(cupomMapper.cupomEntityToCupomModel(cupomRepository.save(cupomMapper.cupomModelToCupomEntity(CUPOM_MODEL)))).thenReturn(CUPOM_MODEL);

        CupomModel sut = dataproviderCupom.saveCupomGateway(CUPOM_MODEL);
        Assertions.assertThat(sut).isEqualTo(CUPOM_MODEL);

    }

    @Test
    public void findByIdCupom() {


        when(cupomRepository.findById(1l)).thenReturn(Optional.of(CUPOM_ENTITY));

        when(cupomMapper.cupomEntityToCupomModel(CUPOM_ENTITY)).thenReturn(CUPOM_MODEL);


        CupomModel sut = dataproviderCupom.findCumpomGatewayById(1L);
        Assertions.assertThat(sut).isNotNull();
        Assertions.assertThat(sut).isEqualTo(CUPOM_MODEL);


    }

    @Test
    public void updateCupom() {


        when(cupomRepository.findById(1l)).thenReturn(Optional.of(CUPOM_ENTITY));


        CupomModel sut = dataproviderCupom.findCumpomGatewayById(1L);
        Assertions.assertThat(sut).isNull();
        Assertions.assertThatNoException().isThrownBy(() -> dataproviderCupom.updateCupomGateway(CUPOM_MODEL, 1l));


    }

    @Test
    public void isActiveCupom() {


        when(cupomRepository.findById(1l)).thenReturn(Optional.of(CUPOM_ENTITY));


        CupomModel sut = dataproviderCupom.findCumpomGatewayById(1L);
        Assertions.assertThat(sut).isNull();
        Assertions.assertThatNoException().isThrownBy(() -> dataproviderCupom.desativarCupomGateway(CUPOM_MODEL, 1l));


    }
}