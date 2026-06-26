package com.example.practicas.domain.service;

import com.example.practicas.domain.IDescuentoStrategy;

public class DescuentoNuevo implements IDescuentoStrategy {
    @Override
    public double calcular(double subtotal) {
        return 0;
    }
}