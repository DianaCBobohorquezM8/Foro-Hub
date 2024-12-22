package com.forohub.foro.controller;

import com.forohub.foro.dominio.usuario.DatosRegistroUsuario;
import com.forohub.foro.dominio.usuario.Usuario;
import com.forohub.foro.dominio.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registrar")
    public void registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario){
        usuarioRepository.save(new Usuario(datosRegistroUsuario));
    }
}
