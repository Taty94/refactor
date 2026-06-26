package com.example.practicas.application.usecases;

import org.springframework.stereotype.Service;

@Service
public class ClienteValidator {
    public void validar(String nombre, String email) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre de cliente invalido");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email invalido");
        }
    }
}