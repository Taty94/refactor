package com.example.practicas.Persistencia;

import com.example.practicas.Dominio.Pedido;

public interface PedidoRepository {
    void guardar(Pedido pedido, double total);
    void eliminar(int idPedido);
}