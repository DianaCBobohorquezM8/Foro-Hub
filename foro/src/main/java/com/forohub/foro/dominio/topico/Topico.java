package com.forohub.foro.dominio.topico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;


@Table(name ="topicos")
@Entity(name ="Topico")
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String mensaje;

    private LocalDate fechaCreacion;

    @NotBlank
    private String curso;
    @NotBlank
    private String status;

    @NotBlank
    private String autor;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDate.now();
    }

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.curso = datosRegistroTopico.curso();
        this.autor = datosRegistroTopico.emailAutor();
        this.status = "abierto";
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.curso() != null){
            this.curso = datosActualizarTopico.curso();
        }
        if (datosActualizarTopico.status() != null){
            this.status = datosActualizarTopico.status();
        }




    }


    public Topico() { }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public String getCurso() {
        return curso;
    }

    public String getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }


}
