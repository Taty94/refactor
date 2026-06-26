package com.example.practicas.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "cliente", nullable = false)
    private String cliente;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "total", nullable = false)
    private Double total;
    
    @Column(name = "tipo_cliente")
    private String tipoCliente;

    public PedidoEntity(String cliente, String email, Double total, String tipoCliente) {
        this.cliente = cliente;
        this.email = email;
        this.total = total;
        this.tipoCliente = tipoCliente;
    }
}