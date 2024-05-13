package com.ibmshop.api.app.mapper;

import com.ibmshop.api.app.dto.input.PedidoDtoInserir;
import com.ibmshop.api.app.dto.output.PedidoDtoListar;
import com.ibmshop.api.domain.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidosMapper {

    PedidoDtoListar entityToDtoPedido(Pedido pedido);

   // @Mapping(target = "detalhesPedido.pedido", ignore = true)
    Pedido DtoToEntityPedido(PedidoDtoInserir pedidoDtoInserir);

    Pedido DtoToEntityUpdatePedido(PedidoDtoListar pedidoDtoInserir);

}
