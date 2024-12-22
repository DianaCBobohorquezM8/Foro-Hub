package com.forohub.foro.dominio.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        String email,
        @NotBlank
        String clave) {
}
