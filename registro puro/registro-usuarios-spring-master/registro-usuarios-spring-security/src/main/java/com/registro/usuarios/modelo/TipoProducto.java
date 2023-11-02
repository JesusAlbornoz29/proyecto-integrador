package com.registro.usuarios.modelo;

import lombok.*;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TipoProducto")
@Getter
@Setter
@NoArgsConstructor // Constructor sin parámetros
@AllArgsConstructor // Constructor con todos los parámetros
@ToString


public class TipoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String descripcion;



}
