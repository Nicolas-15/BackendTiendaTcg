package com.tienda.tcg.controller;

import com.tienda.tcg.model.Producto;
import com.tienda.tcg.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
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
    public ResponseEntity<List<Producto>> listarProductos() {
        List<Producto> productos = service.listaProductos();
        return ResponseEntity.ok(productos);
    }

    // ============================
    // 🔵 OBTENER POR ID
    // ============================
    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID", description = "Busca un producto por su ID")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        try {
            Producto producto = service.obtenerPorId(id);
            return ResponseEntity.ok(producto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    // ============================
    // 🔵 GUARDAR NUEVO
    // ============================
    @PostMapping
    @Operation(summary = "Guardar producto", description = "Crea un nuevo producto")
    public ResponseEntity<?> guardar(@RequestBody Producto p) {
        try {
            Producto creado = service.guardar(p);
            return ResponseEntity.ok(creado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ============================
    // 🔵 ACTUALIZAR
    // ============================
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto", description = "Actualiza un producto según su ID")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Producto p) {
        try {
            Producto actualizado = service.actualizar(id, p);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    // ============================
    // 🔵 ELIMINAR
    // ============================
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar producto", description = "Elimina un producto por ID")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
