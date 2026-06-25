package com.example.practicas.Persistencia;

import com.example.practicas.Persistencia.Entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Integer> {
    // Spring Data genera automáticamente save(), delete(), findById(), etc.
}