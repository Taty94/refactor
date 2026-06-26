package com.example.practicas.Servicios;

public class DescuentoVip implements DescuentoStrategy {
    @Override
    public double calcular(double subtotal) {
        return subtotal * 0.20;
    }
}