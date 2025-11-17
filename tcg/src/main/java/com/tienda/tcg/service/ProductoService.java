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

    public List<Producto> listaProductos() {
        return repository.findAll();
    }

    public Producto guardar(Producto p) {
        return repository.save(p);
    }

    public void eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("El producto con ID " + id + " no existe.");
        }
    }
}
