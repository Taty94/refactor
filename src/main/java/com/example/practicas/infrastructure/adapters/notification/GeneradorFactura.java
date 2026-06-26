package com.example.practicas.infrastructure.adapters.notification;

import com.example.practicas.application.usecases.notification.IFacturaGenerator;
import com.example.practicas.domain.model.Pedido;
import com.example.practicas.domain.model.ResultadoCalculo;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class GeneradorFactura  implements IFacturaGenerator {

    public void generar(Pedido pedido, ResultadoCalculo resultado) {
        String nombreArchivo = "factura_" + pedido.getNombre() + ".txt";
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("FACTURA\n");
            writer.write("Cliente: " + pedido.getNombre() + "\n");
            writer.write("Email: " + pedido.getEmail() + "\n");
            for (var item : pedido.getProductos()) {
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