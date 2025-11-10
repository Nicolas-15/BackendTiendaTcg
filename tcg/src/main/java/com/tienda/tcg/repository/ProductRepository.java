package com.tienda.tcg.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.tcg.model.Producto;

public interface ProductRepository extends JpaRepository<Producto, Long> {
    
}
