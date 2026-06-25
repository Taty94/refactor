package com.example.practicas.Notificacion;

import com.example.practicas.Dominio.Pedido;
import com.example.practicas.Dominio.ResultadoCalculo;

public interface FacturaGenerator {
    void generar(Pedido pedido, ResultadoCalculo resultado);
}