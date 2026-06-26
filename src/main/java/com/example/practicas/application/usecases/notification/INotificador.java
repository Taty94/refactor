package com.example.practicas.infrastructure.adapters.notification;

import com.example.practicas.domain.model.Pedido;

public interface Notificador {
    void enviarConfirmacion(Pedido pedido, double total);
    void enviarCancelacion(Pedido pedido, int idPedido);
}