package com.example.practicas.application.usecases;

import com.example.practicas.domain.IDescuentoStrategy;
import com.example.practicas.domain.model.enums.TipoCliente;
import com.example.practicas.domain.service.DescuentoFrecuente;
import com.example.practicas.domain.service.DescuentoNuevo;
import com.example.practicas.domain.service.DescuentoRegular;
import com.example.practicas.domain.service.DescuentoVip;

public class DescuentoFactory {
    
    public static IDescuentoStrategy crear(TipoCliente tipoCliente) {
        return switch (tipoCliente) {
            case VIP -> new DescuentoVip();
            case FRECUENTE -> new DescuentoFrecuente();
            case REGULAR -> new DescuentoRegular();
            case NUEVO -> new DescuentoNuevo();
        };
    }
}