package com.forohub.foro.controller;

import com.forohub.foro.dominio.usuario.DatosAutenticacionUsuario;
import com.forohub.foro.dominio.usuario.Usuario;
import com.forohub.foro.infra.security.DatosJWTtoken;
import com.forohub.foro.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Autowired
    public AutenticacionController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<?> autenticacionUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        System.out.println("Iniciando autenticación para login: " + datosAutenticacionUsuario.email());
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                datosAutenticacionUsuario.email(),
                datosAutenticacionUsuario.clave());
        try {
            System.out.println("Antes de authenticationManager.authenticate");
            var usuarioAutenticado = authenticationManager.authenticate(authToken);
            System.out.println("Después de authenticationManager.authenticate");

            System.out.println("Antes de generar token");
            var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
            System.out.println("Después de generar token");

            System.out.println("Autenticación exitosa para login: " + datosAutenticacionUsuario.email());
            return ResponseEntity.ok(new DatosJWTtoken(jwtToken));
        } catch (BadCredentialsException e) {
            System.out.println("Error de autenticación: Contraseña incorrecta");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error de autenticación: Contraseña incorrecta");
        }
    }
}
