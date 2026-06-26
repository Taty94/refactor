package com.example.practicas.application.usecases;

import com.example.practicas.domain.model.Pedido;
import com.example.practicas.domain.model.ResultadoCalculo;
import org.springframework.stereotype.Service;

@Service
public class CalculadorPedidos {

    private static final double TASA_IMPUESTO = 0.12;

    public ResultadoCalculo calcular(Pedido pedido) {
        double subtotal = pedido.getProductos().stream()
                .mapToDouble(item -> item.getPrecio() * item.getCantidad())
                .sum();

        double descuento = DescuentoFactory.crear(pedido.getTipoCliente()).calcular(subtotal);
        double impuesto = (subtotal - descuento) * TASA_IMPUESTO;
        double total = subtotal - descuento + impuesto;

        return new ResultadoCalculo(subtotal, descuento, impuesto, total);
    }
}