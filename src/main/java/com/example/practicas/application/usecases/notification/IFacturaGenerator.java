package com.example.practicas.infrastructure.adapters.notification;

import com.example.practicas.domain.model.Pedido;
import com.example.practicas.domain.model.ResultadoCalculo;

public interface FacturaGenerator {
    void generar(Pedido pedido, ResultadoCalculo resultado);
}