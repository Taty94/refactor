package com.example.practicas.infrastructure.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class PedidoItemRequest {
    private String nombreProducto;
    private double precioProducto;
    private int cantidad;

}
