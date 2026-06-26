package com.example.practicas.application.usecases.notification;

import com.example.practicas.domain.model.Pedido;
import com.example.practicas.domain.model.ResultadoCalculo;

public interface IFacturaGenerator {
    void generar(Pedido pedido, ResultadoCalculo resultado);
}