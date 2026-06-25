package com.example.practicas.Notificacion;

import com.example.practicas.Dominio.Pedido;
import com.example.practicas.Dominio.ResultadoCalculo;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class GeneradorFactura  implements FacturaGenerator{

    public void generar(Pedido pedido, ResultadoCalculo resultado) {
        String nombreArchivo = "factura_" + pedido.getNombreCliente() + ".txt";
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("FACTURA\n");
            writer.write("Cliente: " + pedido.getNombreCliente() + "\n");
            writer.write("Email: " + pedido.getEmailCliente() + "\n");
            for (var item : pedido.getItems()) {
                writer.write(item.getNombre() + " x" + item.getCantidad()
                        + " = $" + item.getSubtotalLinea() + "\n");
            }
            writer.write("Subtotal: $" + resultado.getSubtotal() + "\n");
            writer.write("Descuento: $" + resultado.getDescuento() + "\n");
            writer.write("Impuesto: $" + resultado.getImpuesto() + "\n");
            writer.write("TOTAL: $" + resultado.getTotal() + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Error al generar la factura", e);
        }
    }
}