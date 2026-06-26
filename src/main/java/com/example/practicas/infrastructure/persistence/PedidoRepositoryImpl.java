package com.example.practicas.infrastructure.persistence;

import com.example.practicas.domain.model.Pedido;
import com.example.practicas.domain.repository.IPedidoRepository;
import com.example.practicas.infrastructure.persistence.entity.PedidoEntity;
import org.springframework.stereotype.Component;

@Component
public class PedidoRepositoryImpl implements IPedidoRepository {

    private final PedidoJpaRepository jpaRepository;

    public PedidoRepositoryImpl(PedidoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void guardar(Pedido pedido, double total) {
        PedidoEntity entity = new PedidoEntity(
                pedido.getNombre(),
                pedido.getEmail(),
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