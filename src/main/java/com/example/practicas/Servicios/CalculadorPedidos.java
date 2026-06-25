package com.example.practicas.Servicios;

import com.example.practicas.Dominio.Pedido;
import com.example.practicas.Dominio.ResultadoCalculo;
import org.springframework.stereotype.Service;

@Service
public class CalculadorPedidos {

    private static final double TASA_IMPUESTO = 0.12;

    public ResultadoCalculo calcular(Pedido pedido) {
        double subtotal = pedido.getItems().stream()
                .mapToDouble(item -> item.getPrecio() * item.getCantidad())
                .sum();

        double descuento = DescuentoFactory.crear(pedido.getTipoCliente()).calcular(subtotal);
        double impuesto = (subtotal - descuento) * TASA_IMPUESTO;
        double total = subtotal - descuento + impuesto;

        return new ResultadoCalculo(subtotal, descuento, impuesto, total);
    }
}