package com.example.practicas;

import java.util.*;
import java.io.*;
import java.sql.*;
public class GestorPedidos{

    private final ClienteValidator validator;
    private final PedidoCalculator calculator;
    private final PedidoRepository pedidoRepository;

    ]
    public void procesarPedido(Pedido pedido) {

        validator.validarCliente(pedido.getNombreCliente(), pedido.getEmailCliente());
        ResultadoCalculo resultado = calculator.calcular(pedido);
        repository.guardar(pedido, resultado.getTotal());
        try {
            FileWriter writer = new FileWriter("factura_" + nombreCliente + ".txt");
            writer.write("FACTURA\n");
            writer.write("Cliente: " + nombreCliente + "\n");
            for (int i = 0; i < nombresProductos.size(); i++) {
                writer.write(nombresProductos.get(i) + " x" + cantidades.get(i)
                        + " = $" + (preciosProductos.get(i) * cantidades.get(i)) + "\n");
            }
            writer.write("Subtotal: $" + subtotal + "\n");
            writer.write("Descuento: $" + descuento + "\n");
            writer.write("Impuesto: $" + impuesto + "\n");
            writer.write("TOTAL: $" + total + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al generar la factura: " + e.getMessage());
        }
        System.out.println("Enviando correo a " + emailCliente + "...");
        System.out.println("Asunto: Confirmacion de pedido");
        System.out.println("Cuerpo: Estimado " + nombreCliente + ", su pedido por $"
                + total + " ha sido procesado.");
        System.out.println("[LOG] Pedido procesado para " + nombreCliente
                + " - Total: " + total);
    }
    public void cancelarPedido(String nombreCliente, String emailCliente, int idPedido) {
        validator.validarCliente(pedido.getNombreCliente(), pedido.getEmailCliente());
        repository.eliminar(idPedido);
        System.out.println("Enviando correo a " + emailCliente + "...");
        System.out.println("Asunto: Cancelacion de pedido");
        System.out.println("Cuerpo: Estimado " + nombreCliente + ", su pedido #"
                + idPedido + " ha sido cancelado.");
    }
}