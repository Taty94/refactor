package com.example.practicas.domain.model;

import com.example.practicas.domain.model.enums.TipoCliente;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Pedido {
    private final String nombreCliente;
    private final String emailCliente;
    private final List<PedidoItem> items;
    private final TipoCliente tipoCliente;
}