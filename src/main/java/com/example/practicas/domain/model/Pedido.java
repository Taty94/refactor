package com.example.practicas.domain.model;

import com.example.practicas.domain.model.enums.TipoCliente;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Pedido {
    private  String nombreCliente;
    private  String emailCliente;
    private  List<PedidoItem> items;
    private  TipoCliente tipoCliente;
}