package com.example.practicas.application.usecases.notification;

import com.example.practicas.domain.model.Pedido;

public interface INotificador {
    void enviarConfirmacion(Pedido pedido, double total);
    void enviarCancelacion(Pedido pedido, int idPedido);
}