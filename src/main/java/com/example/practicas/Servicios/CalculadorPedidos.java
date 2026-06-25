package com.example.practicas.Servicios;

import com.example.practicas.Dominio.Pedido;
import com.example.practicas.Dominio.ResultadoCalculo;

public class CalculadorPedidos {
    private static final double TASA_IMPUESTO = 0.12;

    public ResultadoCalculo calcular(Pedido pedido) {
        // Calcular subtotal
        double subtotal = calcularSubtotal(pedido);
        
        // Obtener la estrategia de descuento según el tipo de cliente
        DescuentoStrategy estrategia = DescuentoFactory.crear(pedido.getTipoCliente());
        
        // Aplicar el descuento
        double descuento = estrategia.calcular(subtotal);
        
        // Calcular impuesto y total
        double impuesto = (subtotal - descuento) * TASA_IMPUESTO;
        double total = subtotal - descuento + impuesto;

        return new ResultadoCalculo(subtotal, descuento, impuesto, total);
    }

    private double calcularSubtotal(Pedido pedido) {
        return pedido.getItems().stream()
            .mapToDouble(item -> item.getPrecio() * item.getCantidad())
            .sum();
    }
}