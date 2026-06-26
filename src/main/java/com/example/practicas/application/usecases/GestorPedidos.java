package com.example.practicas.application.usecases;

import com.example.practicas.application.usecases.notification.IFacturaGenerator;
import com.example.practicas.application.usecases.notification.INotificador;
import com.example.practicas.domain.model.Pedido;
import com.example.practicas.domain.model.ResultadoCalculo;
import com.example.practicas.domain.repository.IPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GestorPedidos{
    private final ClienteValidator validator;
    private final CalculadorPedidos calculator;
    private final IPedidoRepository repository;
    private final IFacturaGenerator facturaGenerator;
    private final INotificador notificador;

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