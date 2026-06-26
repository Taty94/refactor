package com.example.practicas.infra.persistence;

import com.example.practicas.core.entity.Pedido;
import com.example.practicas.core.repository.PedidoRepository;
import com.example.practicas.infra.persistence.entity.PedidoEntity;
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