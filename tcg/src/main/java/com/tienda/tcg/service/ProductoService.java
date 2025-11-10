package com.tienda.tcg.service;

import com.tienda.tcg.model.Producto;
import com.tienda.tcg.repository.ProductRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    private final ProductRepository repo;

    public ProductoService(ProductRepository repo){
        this.repo = repo;
    }

    public List<Producto> listaProductos(){
        return repo.findAll();
    }

    public Producto guardar(Producto p){
        return repo.save(p);
    }

    public void eliminar(Long id){
        repo.deleteById(id);
    }
}
