package com.example.practicas.Persistencia;

import com.example.practicas.Dominio.Pedido;
import com.example.practicas.Persistencia.Entity.PedidoEntity;
import org.springframework.stereotype.Component;

@Component
public class PedidoRepositoryImpl implements PedidoRepository {

    private final PedidoJpaRepository jpaRepository;

    public PedidoRepositoryImpl(PedidoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void guardar(Pedido pedido, double total) {
        PedidoEntity entity = new PedidoEntity(
                pedido.getNombreCliente(),
                pedido.getEmailCliente(),
                total,
                pedido.getTipoCliente().name()
        );
        jpaRepository.save(entity);
    }

    @Override
    public void eliminar(int idPedido) {
        jpaRepository.deleteById(idPedido);
    }
}