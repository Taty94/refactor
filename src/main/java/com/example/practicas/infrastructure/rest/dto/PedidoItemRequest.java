package com.example.practicas.infrastructure.rest.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItemRequest {
    private String nombreProducto;
    private double precioProducto;
    private int cantidad;
}
