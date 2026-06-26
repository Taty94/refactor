package com.example.practicas.core.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResultadoCalculo {
    private final double subtotal;
    private final double descuento;
    private final double impuesto;
    private final double total;
}