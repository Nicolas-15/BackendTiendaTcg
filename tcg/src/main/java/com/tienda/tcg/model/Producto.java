package com.tienda.tcg.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PRODUCTOS")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITTLE")  // 👈 Debe coincidir con tu columna en Oracle
    private String title;

    private Double price;
    private String category;
    private String img;
}
