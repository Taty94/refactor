package com.example.practicas.Controller;

import com.example.practicas.Dominio.Pedido;
import com.example.practicas.Servicios.GestorPedidos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final GestorPedidos gestor;

    public PedidoController(GestorPedidos gestor) {
        this.gestor = gestor;
    }

    @PostMapping("/procesar")
    public ResponseEntity<String> procesar(@RequestBody Pedido request) {
        gestor.procesarPedido(request);
        return ResponseEntity.ok("Pedido procesado");
    }
}