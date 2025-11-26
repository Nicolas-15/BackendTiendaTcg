package com.tienda.tcg.controller;

import com.tienda.tcg.model.User;
import com.tienda.tcg.security.JwtUtil;
import com.tienda.tcg.service.UserService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // =======================================================
    // 🔵 REGISTRO
    // =======================================================
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        // Validar si el usuario ya existe
        if (userService.findByUsername(request.getUsername()) != null) {
            return ResponseEntity.status(409).body("El usuario ya existe");
        }

        // Crear usuario y guardarlo
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole("USER");

        userService.save(user);

        return ResponseEntity.ok("Usuario registrado correctamente");
    }

    // =======================================================
    // 🔵 LOGIN
    // =======================================================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = userService.findByUsername(request.getUsername());

        if (user == null) {
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }

        if (!userService.validarPassword(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());

        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setRole(user.getRole());
        response.setUsername(user.getUsername());

        return ResponseEntity.ok(response);
    }
}

// ==========================================
// 🔵 Clases auxiliares
// ==========================================

@Data
class RegisterRequest {
    private String username;
    private String password;
}

@Data
class LoginRequest {
    private String username;
    private String password;
}

@Data
class LoginResponse {
    private String token;
    private String role;
    private String username;
}
