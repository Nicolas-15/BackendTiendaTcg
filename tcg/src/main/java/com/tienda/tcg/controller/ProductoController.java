package com.tienda.tcg.controller;

import com.tienda.tcg.model.Producto;
import com.tienda.tcg.service.ProductoService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // Permite llamadas desde Postman y front-end
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return service.listaProductos();
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto p) {
        return service.guardar(p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
