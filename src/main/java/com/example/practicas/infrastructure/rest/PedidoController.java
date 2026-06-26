package com.example.practicas.infrastructure.rest;

import com.example.practicas.application.usecases.GestorPedidos;
import com.example.practicas.domain.model.Pedido;
import com.example.practicas.infrastructure.rest.dto.PedidoRequest;
import com.example.practicas.infrastructure.rest.mapper.PedidoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{idPedido}")
    public ResponseEntity<String> cancelar(@PathVariable int idPedido,
                                           @RequestBody PedidoRequest request) {
        Pedido pedido = mapper.toDomain(request);
        gestor.cancelarPedido(pedido, idPedido);
        return ResponseEntity.ok("Pedido cancelado");
    }
}