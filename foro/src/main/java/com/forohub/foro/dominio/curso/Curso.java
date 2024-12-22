package com.forohub.foro.dominio.curso;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;


@Table(name ="cursos")
@Entity(name ="Curso")
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    public Curso(DatosRegistroCurso datosRegistroCurso) {
         this.nombre = datosRegistroCurso.nombre();
    }

    public Curso(){}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
