package com.tienda.tcg.controller;

import com.tienda.tcg.model.User;
import com.tienda.tcg.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public User obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public User guardar(@RequestBody User u) {
        return service.guardar(u);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
