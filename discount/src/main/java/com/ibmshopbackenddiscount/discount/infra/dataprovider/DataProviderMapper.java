package com.ibmshopbackenddiscount.discount.infra.dataprovider;

import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;
import com.ibmshopbackenddiscount.discount.infra.entity.CupomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "Spring")
public interface DataProviderMapper {

    @Mapping(constant = "true", target = "ativo")
    @Mapping(expression = "java(java.time.LocalDate.now())", target = "dataCriacao")
    CupomEntity cupomModelToCupomEntity(CupomModel cupomModel);

    CupomModel cupomEntityToCupomModel(CupomEntity cupomEntity);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "qtdMinimaProdutos", ignore = true)
    @Mapping(target = "valorMinimoPedido", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    void cupomModelToCupomEntityUpdate(@MappingTarget CupomEntity cupomEntity, CupomModel cupomModel);


}
