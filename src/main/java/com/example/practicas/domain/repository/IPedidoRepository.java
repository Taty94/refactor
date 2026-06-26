package com.example.practicas.domain.repository;

import com.example.practicas.domain.model.Pedido;

public interface IPedidoRepository {
    void guardar(Pedido pedido, double total);
    void eliminar(int idPedido);
}