package com.example.practicas.infrastructure.rest.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItemRequest {
    private String nombre;
    private double precio;
    private int cantidad;
}
