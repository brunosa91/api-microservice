package com.ibmshopbackenddiscount.discount.app.mapper;

import com.ibmshopbackenddiscount.discount.app.dto.CupomRequest;
import com.ibmshopbackenddiscount.discount.app.dto.CupomResponse;
import com.ibmshopbackenddiscount.discount.domain.model.CupomModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "Spring")
public interface CupomMapper {


    CupomModel dtoToCupomModel(CupomRequest cupomRequest);



    CupomResponse cupomModeltoDto(CupomModel cupomModel);
}
