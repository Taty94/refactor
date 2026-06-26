package com.example.practicas.infrastructure.rest.mapper;

import com.example.practicas.domain.model.Pedido;
import com.example.practicas.domain.model.PedidoItem;
import com.example.practicas.infrastructure.rest.dto.PedidoItemRequest;
import com.example.practicas.infrastructure.rest.dto.PedidoRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {


    PedidoItem toDomain(PedidoItemRequest dto);

    List<PedidoItem> toDomain(List<PedidoItemRequest> dto);

    Pedido toDomain(PedidoRequest dto);
}
