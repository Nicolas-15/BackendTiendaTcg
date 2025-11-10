package com.tienda.tcg.controller;

import com.tienda.tcg.model.Producto;
import com.tienda.tcg.service.ProductoService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // GET -> listar todos
    @GetMapping
    public List<Producto> listarProductos() {
        return service.listaProductos();
    }


    // POST -> crear producto
    @PostMapping
    public Producto guardar(@RequestBody Producto p) {
        return service.guardar(p);
    }

    // DELETE -> eliminar por id
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
