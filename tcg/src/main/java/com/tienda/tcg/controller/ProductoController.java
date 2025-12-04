package com.tienda.tcg.controller;

import com.tienda.tcg.model.Producto;
import com.tienda.tcg.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")   // 🔥 AHORA SÍ RUTA CORRECTA
@CrossOrigin(origins = "*")
@Tag(name = "Productos", description = "CRUD de productos de la tienda TCG")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // ============================
    // 🔵 LISTAR TODOS
    // ============================
    @GetMapping
    @Operation(summary = "Listar productos", description = "Obtiene todos los productos disponibles")
    public List<Producto> listarProductos() {
        return service.listaProductos();
    }

    // ============================
    // 🔵 OBTENER POR ID
    // ============================
    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID", description = "Busca un producto por su ID")
    public Producto obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    // ============================
    // 🔵 GUARDAR NUEVO
    // ============================
    @PostMapping
    @Operation(summary = "Guardar producto", description = "Crea un nuevo producto")
    public Producto guardar(@RequestBody Producto p) {
        return service.guardar(p);
    }

    // ============================
    // 🔵 ACTUALIZAR
    // ============================
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto", description = "Actualiza un producto según su ID")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto p) {
        return service.actualizar(id, p);
    }

    // ============================
    // 🔵 ELIMINAR
    // ============================
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar producto", description = "Elimina un producto por ID")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
