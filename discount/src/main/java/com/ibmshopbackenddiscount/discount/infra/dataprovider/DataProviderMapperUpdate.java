package com.ibmshopbackenddiscount.discount.infra.dataprovider;

import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;
import com.ibmshopbackenddiscount.discount.infra.entity.CupomEntity;
import org.springframework.stereotype.Component;

@Component
public class DataProviderMapperUpdate {

    public CupomEntity updateCupomMapper(CupomModel cupomModel, CupomEntity cupomEntity){
        cupomEntity.setCodigo(cupomModel.getCodigo());
        cupomEntity.setPercentual(cupomModel.getPercentual());
        cupomEntity.setQtdMinimaProdutos(cupomModel.getQtdMinimaProdutos());
        cupomEntity.setValorMinimoPedido(cupomModel.getValorMinimoPedido());
        cupomEntity.setDescontoMaximo(cupomModel.getDescontoMaximo());
        cupomEntity.setDataExpiracao(cupomModel.getDataExpiracao());
        return cupomEntity;







    }
}
