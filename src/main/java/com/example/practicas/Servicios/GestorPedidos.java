package com.example.practicas.Servicios;


import com.example.practicas.Dominio.Pedido;
import com.example.practicas.Dominio.ResultadoCalculo;
import com.example.practicas.Persistencia.PedidoRepository;
import lombok.RequiredArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;

@RequiredArgsConstructor

public class GestorPedidos{
    private final ClienteValidator validator;
    private final CalculadorPedidos calculator;
    private final PedidoRepository repository;

    public void procesarPedido(Pedido pedido) {

        validator.validar(pedido.getNombreCliente(), pedido.getEmailCliente());
        ResultadoCalculo resultado = calculator.calcular(pedido);
        repository.guardar(pedido, resultado.getTotal());
        try {
            FileWriter writer = new FileWriter("factura_" + pedido.getNombreCliente() + ".txt");
            writer.write("FACTURA\n");
            writer.write("Cliente: " + pedido.getNombreCliente() + "\n");
            writer.write("Subtotal: $" + resultado.getSubtotal() + "\n");
            writer.write("Descuento: $" + resultado.getDescuento() + "\n");
            writer.write("Impuesto: $" + resultado.getImpuesto() + "\n");
            writer.write("TOTAL: $" + resultado.getTotal() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al generar la factura: " + e.getMessage());
        }
        System.out.println("Enviando correo a " + pedido.getEmailCliente() + "...");
        System.out.println("Asunto: Confirmacion de pedido");
        System.out.println("Cuerpo: Estimado " + pedido.getNombreCliente() + ", su pedido por $"
                + resultado.getTotal() + " ha sido procesado.");
        System.out.println("[LOG] Pedido procesado para " + pedido.getNombreCliente()
                + " - Total: " + resultado.getTotal());
    }
    public void cancelarPedido(Pedido pedido, int idPedido) {
        validator.validar(pedido.getNombreCliente(), pedido.getEmailCliente());
        repository.eliminar(idPedido);
        System.out.println("Enviando correo a " + pedido.getEmailCliente() + "...");
        System.out.println("Asunto: Cancelacion de pedido");
        System.out.println("Cuerpo: Estimado " + pedido.getNombreCliente() + ", su pedido #"
                + idPedido + " ha sido cancelado.");
    }
}