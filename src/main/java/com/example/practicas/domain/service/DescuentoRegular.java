package com.example.practicas.domain.service;

import com.example.practicas.domain.IDescuentoStrategy;

public class DescuentoRegular implements IDescuentoStrategy {
    @Override
    public double calcular(double subtotal) {
        return subtotal * 0.05;
    }
}