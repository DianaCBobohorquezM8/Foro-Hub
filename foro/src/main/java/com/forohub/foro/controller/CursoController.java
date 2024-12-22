package com.forohub.foro.controller;

import com.forohub.foro.dominio.curso.Curso;
import com.forohub.foro.dominio.curso.CursoRepository;
import com.forohub.foro.dominio.curso.DatosRegistroCurso;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
@SecurityRequirement(name = "bearer-key")
public class CursoController {


    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping("/registrar")
    public void registrarTopico(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso){
        cursoRepository.save(new Curso(datosRegistroCurso));
    }
}
