package com.forohub.foro.dominio.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DatosRespuestaTopico(

        @NotBlank String titulo,
        @NotBlank String mensaje,
        LocalDate fechaCreacion,
        @NotBlank String curso,
        @NotBlank String status,
        @NotBlank String autor ) {

}