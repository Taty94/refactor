package com.example.practicas.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {
    private String nombreCliente;
    private String emailCliente;
    private PedidoItemRequest[] items;
    private String tipoCliente;
}
