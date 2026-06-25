package com.example.practicas.Servicios;

import com.example.practicas.Dominio.Enums.TipoCliente;

public class DescuentoFactory {
    
    public static DescuentoStrategy crear(TipoCliente tipoCliente) {
        return switch (tipoCliente) {
            case VIP -> new DescuentoVip();
            case FRECUENTE -> new DescuentoFrecuente();
            case REGULAR -> new DescuentoRegular();
            case NUEVO -> new DescuentoNuevo();
        };
    }
}