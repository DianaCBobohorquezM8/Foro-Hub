package com.forohub.foro.dominio.topico;

import java.time.LocalDate;

public record DatosListadoTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fechaCreacion,
        String status,
        String autor,
        String curso) {

    public DatosListadoTopicos(Topico topico){
        this(   topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso());
    }
}
