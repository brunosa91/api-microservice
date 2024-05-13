package com.ibmshopbackenddiscount.discount.infra.dataprovider;

import com.ibmshopbackenddiscount.discount.cross.ValidationItemExist;
import com.ibmshopbackenddiscount.discount.domain.gateway.CupomGateway;
import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;
import com.ibmshopbackenddiscount.discount.infra.entity.CupomEntity;
import com.ibmshopbackenddiscount.discount.infra.repository.CupomRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
@Slf4j
public class DataproviderCupom implements CupomGateway {

    private final DataProviderMapper dataProviderMapper;


    private final CupomRepository cupomRepository;

    @Override
    public CupomModel saveCupomGateway(CupomModel cupomModel) {

        Optional<CupomEntity>OpCupomEntity = cupomRepository.findCupomByCodigo(cupomModel.getCodigo());

        if(OpCupomEntity.isPresent())
            throw new ValidationItemExist("CÓDIGO","Já existe na base de dados");

        CupomEntity cupomEntity = dataProviderMapper.cupomModelToCupomEntity(cupomModel);





        return  dataProviderMapper.cupomEntityToCupomModel
                (cupomRepository.save(cupomEntity)
                );

    }

    @Override
    public CupomModel findCumpomGatewayById(Long id) {

        CupomEntity cupomEntity = cupomRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return dataProviderMapper.cupomEntityToCupomModel(cupomEntity);
    }

    @Override
    public CupomModel updateCupomGateway(CupomModel cupomModel, Long id) {
        CupomEntity cupomEntity = cupomRepository.findById(id).orElseThrow(EntityNotFoundException::new);


        dataProviderMapper.cupomModelToCupomEntityUpdate(cupomEntity, cupomModel);

        return dataProviderMapper.cupomEntityToCupomModel(cupomRepository.save(cupomEntity));
    }

    @Override
    public CupomModel desativarCupomGateway(CupomModel cupomModel, Long id) {
        CupomEntity cupomEntity = cupomRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        cupomEntity.setAtivo(cupomModel.getAtivo());

        return dataProviderMapper.cupomEntityToCupomModel(cupomEntity);
    }
}
