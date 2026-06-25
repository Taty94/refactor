package com.example.practicas.Servicios;

public class DescuentoRegular implements DescuentoStrategy {
    @Override
    public double calcular(double subtotal) {
        return subtotal * 0.05;
    }
}