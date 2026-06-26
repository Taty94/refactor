package com.example.practicas.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {
    private String nombre;
    private String email;
    private List<PedidoItemRequest> productos;
    private String tipoCliente;
}
