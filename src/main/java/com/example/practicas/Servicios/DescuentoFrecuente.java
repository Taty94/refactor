package com.example.practicas.Servicios;

public class DescuentoFrecuente implements DescuentoStrategy {
    @Override
    public double calcular(double subtotal) {
        return subtotal * 0.10;
    }
}