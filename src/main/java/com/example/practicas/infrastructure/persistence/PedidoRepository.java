package com.example.practicas.core.repository;

import com.example.practicas.domain.model.Pedido;

public interface PedidoRepository {
    void guardar(Pedido pedido, double total);
    void eliminar(int idPedido);
}