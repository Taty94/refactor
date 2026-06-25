package com.example.practicas.Servicios;

import com.example.practicas.Dominio.Pedido;
import com.example.practicas.Dominio.ResultadoCalculo;
import com.example.practicas.Notificacion.GeneradorFactura;
import com.example.practicas.Notificacion.NotificadorCorreo;
import com.example.practicas.Persistencia.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GestorPedidos{
    private final ClienteValidator validator;
    private final CalculadorPedidos calculator;
    private final PedidoRepository repository;
    private final GeneradorFactura facturaGenerator;
    private final NotificadorCorreo notificador;

    public void procesarPedido(Pedido pedido) {

        validator.validar(pedido.getNombreCliente(), pedido.getEmailCliente());
        ResultadoCalculo resultado = calculator.calcular(pedido);
        repository.guardar(pedido, resultado.getTotal());
        facturaGenerator.generar(pedido, resultado);
        notificador.enviarConfirmacion(pedido, resultado.getTotal());
    }
    public void cancelarPedido(Pedido pedido, int idPedido) {
        validator.validar(pedido.getNombreCliente(), pedido.getEmailCliente());
        repository.eliminar(idPedido);
        notificador.enviarCancelacion(pedido, idPedido);
    }
}