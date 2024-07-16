package com.alura.forohub.controllers;

import com.alura.forohub.dto.usuario.UsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
@AllArgsConstructor
public class AutenticacionController {

    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody UsuarioDTO usuario) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(usuario.username(), usuario.password());
        authenticationManager.authenticate(authentication);
        return ResponseEntity.ok().body(usuario);
    }
}
