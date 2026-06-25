package com.example.practicas.Notificacion;

import com.example.practicas.Dominio.Pedido;
import org.springframework.stereotype.Service;

@Service
public class NotificadorCorreo {

    public void enviarConfirmacion(Pedido pedido, double total) {
        System.out.println("Enviando correo a " + pedido.getEmailCliente());
        System.out.println("Asunto: Confirmacion de pedido");
        System.out.println("Cuerpo: Estimado " + pedido.getNombreCliente()
                + ", su pedido por $" + total + " ha sido procesado.");
    }

    public void enviarCancelacion(Pedido pedido, int idPedido) {
        System.out.println("Enviando correo a " + pedido.getEmailCliente());
        System.out.println("Asunto: Cancelacion de pedido");
        System.out.println("Cuerpo: Estimado " + pedido.getNombreCliente()
                + ", su pedido #" + idPedido + " ha sido cancelado.");
    }
}