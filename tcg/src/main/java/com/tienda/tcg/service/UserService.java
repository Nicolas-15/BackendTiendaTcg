package com.tienda.tcg.service;

import com.tienda.tcg.model.User;
import com.tienda.tcg.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    // ===================================================
    // 🔵 LISTAR TODOS LOS USUARIOS
    // ===================================================
    public List<User> listar() {
        return userRepository.findAll();
    }

    // ===================================================
    // 🔵 BUSCAR POR ID
    // ===================================================
    public User buscarPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // ===================================================
    // 🔵 GUARDAR / CREAR USUARIO (POST /usuarios)
    // ===================================================
    public User guardar(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // ===================================================
    // 🔵 MÉTODO COMPATIBLE CON CONTROLADORES ANTIGUOS
    //     (Ejemplo: /auth/register)
    // ===================================================
    public void save(User user) {
        guardar(user);
    }

    // ===================================================
    // 🔵 LOGIN: Buscar usuario por username
    // ===================================================
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    // ===================================================
    // 🔵 VALIDAR CONTRASEÑA (LOGIN)
    // ===================================================
    public boolean validarPassword(String rawPassword, String encryptedPassword) {
        return passwordEncoder.matches(rawPassword, encryptedPassword);
    }

    // ===================================================
    // 🔵 ELIMINAR USUARIO
    // ===================================================
    public void eliminar(Long id) {
        userRepository.deleteById(id);
    }
}
