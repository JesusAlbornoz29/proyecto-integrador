package com.grupo3.digitalbook.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "ImagenProducto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ImagenProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String ruta;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
}
