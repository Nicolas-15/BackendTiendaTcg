package com.tienda.tcg.service;

import com.tienda.tcg.model.Producto;
import com.tienda.tcg.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    // ============================
    // 🔵 LISTAR TODOS
    // ============================
    public List<Producto> listaProductos() {
        return repository.findAll();
    }

    // ============================
    // 🔵 GUARDAR NUEVO PRODUCTO
    // ============================
    public Producto guardar(Producto p) {

        // Validación básica
        if (p.getTittle() == null || p.getTittle().isEmpty()) {
            throw new RuntimeException("El campo 'tittle' no puede estar vacío.");
        }

        if (p.getPrice() == null || p.getPrice() < 0) {
            throw new RuntimeException("El precio es inválido.");
        }

        return repository.save(p);
    }

    // ============================
    // 🔵 OBTENER POR ID
    // ============================
    public Producto obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("El producto con ID " + id + " no existe."));
    }

    // ============================
    // 🔵 ACTUALIZAR PRODUCTO
    // ============================
    public Producto actualizar(Long id, Producto p) {

        Producto existente = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("El producto con ID " + id + " no existe."));

        // Validaciones
        if (p.getTittle() == null || p.getTittle().isEmpty()) {
            throw new RuntimeException("El título no puede estar vacío.");
        }
        if (p.getPrice() == null || p.getPrice() < 0) {
            throw new RuntimeException("El precio es inválido.");
        }

        // Solo actualizamos los campos editables
        existente.setCategory(p.getCategory());
        existente.setImg(p.getImg());
        existente.setPrice(p.getPrice());
        existente.setTittle(p.getTittle());

        return repository.save(existente);
    }

    // ============================
    // 🔵 ELIMINAR PRODUCTO
    // ============================
    public void eliminar(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("El producto con ID " + id + " no existe.");
        }

        repository.deleteById(id);
    }
}
