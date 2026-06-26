package com.example.practicas.infrastructure.rest;

import com.example.practicas.application.usecases.GestorPedidos;
import com.example.practicas.domain.model.Pedido;
import com.example.practicas.infrastructure.rest.dto.PedidoRequest;
import com.example.practicas.infrastructure.rest.mapper.PedidoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final GestorPedidos gestor;
    private final PedidoMapper mapper;

    @PostMapping("/procesar")
    public ResponseEntity<String> procesar(@RequestBody PedidoRequest request) {
        Pedido pedido = mapper.toDomain(request);
        gestor.procesarPedido(pedido);
        return ResponseEntity.ok("Pedido procesado");
    }
}