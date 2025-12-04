package com.tienda.tcg.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PRODUCTOS")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Oracle 12c+ soporta IDENTITY. Si tu Oracle es más antiguo te hago versión con SEQUENCE.
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CATEGORY", length = 255)
    private String category;

    @Column(name = "IMG", length = 255)
    private String img;

    @Column(name = "PRICE")
    private Double price; 
    // FLOAT(53) → Double en Java, esto es correcto.

    @Column(name = "TITTLE", length = 255)
    private String tittle;
}
