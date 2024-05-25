package com.Grupo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo1.model.Usuario;
import com.Grupo1.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // Endpoint usando Criteria API
    @PostMapping("/login/criteria")
    public ResponseEntity<?> loginByCriteria(@RequestParam String username, @RequestParam String password) {
        Usuario usuario = service.loginByCriteria(username, password);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nombre de usuario o contraseña incorrectos");
        }
    }

    // Endpoint usando JPQL
    @PostMapping("/login/jpql")
    public ResponseEntity<?> loginByJPQL(@RequestParam String username, @RequestParam String password) {
        Usuario usuario = service.loginByJPQL(username, password);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nombre de usuario o contraseña incorrectos");
        }
    }

    // Endpoint usando SQL nativo
    @PostMapping("/login/native")
    public ResponseEntity<?> loginByNativeQuery(@RequestParam String username, @RequestParam String password) {
        Usuario usuario = service.loginByNativeQuery(username, password);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nombre de usuario o contraseña incorrectos");
        }
    }
}
