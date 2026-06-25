package com.example.practicas.Notificacion;

import com.example.practicas.Dominio.Pedido;

public interface Notificador {
    void enviarConfirmacion(Pedido pedido, double total);
    void enviarCancelacion(Pedido pedido, int idPedido);
}