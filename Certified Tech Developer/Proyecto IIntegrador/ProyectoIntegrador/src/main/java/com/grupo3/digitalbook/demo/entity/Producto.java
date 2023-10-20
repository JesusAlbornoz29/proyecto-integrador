package com.grupo3.digitalbook.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Productos")
@Getter @Setter
@NoArgsConstructor // Constructor sin parámetros
@AllArgsConstructor // Constructor con todos los parámetros
@ToString

public class Producto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank()
    private String nombre;

    @NotNull
    private Integer precio;

    @NotBlank()
    private String descripcion;

    @NotBlank()
    private String imagen;

    @NotNull
    private boolean stock;

    @OneToOne
    @JoinColumn(name = "id_tipo_producto", referencedColumnName = "id")
    private TipoProducto tipoProducto;

    @OneToOne
    @JoinColumn(name = "id_marca_producto", referencedColumnName = "id")
    private MarcaProducto marcaProducto;
}
