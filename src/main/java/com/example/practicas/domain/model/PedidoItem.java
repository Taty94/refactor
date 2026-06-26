package com.example.practicas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class PedidoItem {
    private String nombre;
    private double precio;
    private int cantidad;

    public double getSubtotalLinea() {
        return precio * cantidad;
    }
}

