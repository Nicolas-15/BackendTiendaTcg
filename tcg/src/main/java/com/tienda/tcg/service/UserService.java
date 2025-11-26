package com.tienda.tcg.service;

import com.tienda.tcg.model.User;
import com.tienda.tcg.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    // ===================================================
    // 🔵 GUARDAR USUARIO (REGISTRO)
    // ===================================================
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // encriptar contraseña
        userRepository.save(user);
    }

    // ===================================================
    // 🔵 BUSCAR POR USERNAME
    // ===================================================
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // ===================================================
    // 🔵 VALIDAR CONTRASEÑA
    // ===================================================
    public boolean validarPassword(String rawPassword, String encryptedPassword) {
        return passwordEncoder.matches(rawPassword, encryptedPassword);
    }
}
