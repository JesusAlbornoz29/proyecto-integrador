package com.example.FinalDesdeCero.entity;

import jakarta.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer precio;

    private String descripcion;

    @Enumerated (EnumType.STRING)
    private Categoria categoria;

    @Enumerated (EnumType.STRING)
    private Marca marca;


    private boolean stock;

}
