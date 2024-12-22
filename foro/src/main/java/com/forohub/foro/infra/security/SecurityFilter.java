package com.forohub.foro.infra.security;

import com.forohub.foro.dominio.usuario.Usuario;
import com.forohub.foro.dominio.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println("Request URI: " + path);

        if (path.startsWith("/v3/api-docs") || path.startsWith("/swagger-ui")) {
            // Permitir la solicitud sin procesar autenticación
            System.out.println("Ruta Swagger, saltando la autenticacion: " + path);
            filterChain.doFilter(request, response);
            return;
        }
        String token = resolveToken(request);
        if (token != null && validateToken(token)) {
            System.out.println("Token valido, configuracion de la autenticacion");
            setAuthentication(token);
        }
        filterChain.doFilter(request, response);
        System.out.println("Solicitud procesada: " + path);
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private boolean validateToken(String token) {
        try {
            String usuario = tokenService.getSubject(token);
            if (usuario != null) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("La validación de token ha fallado: " + e.getMessage());
            return false;
        }
        return false;
    }
    private void setAuthentication(String token) {
        String userEmail = tokenService.getSubject(token);
        Usuario usuario = (Usuario) usuarioRepository.findByEmail(userEmail);
        if (usuario != null) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }else { System.err.println("Usuario no encontrado para el email: " + userEmail);
        }
    }
}
