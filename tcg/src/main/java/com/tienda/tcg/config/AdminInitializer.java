package com.tienda.tcg.config;

import com.tienda.tcg.model.User;
import com.tienda.tcg.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {

    @Bean
    CommandLineRunner initAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            // Si YA existe admin, no hace nada
            if (userRepository.findByUsername("admin1").isPresent()) {
                System.out.println("🔵 Admin ya existe, no se creará uno nuevo.");
                return;
            }

            System.out.println("🟣 Creando ADMIN por defecto...");

            User admin = new User();
            admin.setUsername("admin1");
            admin.setPassword(passwordEncoder.encode("admin123"));  // CONTRASEÑA
            admin.setRole("ADMIN");

            userRepository.save(admin);

            System.out.println("🟢 ADMIN creado correctamente: admin1 / admin123");
        };
    }
}
