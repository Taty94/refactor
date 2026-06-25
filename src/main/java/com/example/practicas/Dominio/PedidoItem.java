package com.example.practicas.Dominio;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class PedidoItem {
    private final String nombre;
    private final double precio;
    private final int cantidad;
}

