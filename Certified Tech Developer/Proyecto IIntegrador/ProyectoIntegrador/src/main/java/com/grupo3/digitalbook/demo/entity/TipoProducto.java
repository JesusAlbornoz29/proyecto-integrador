package com.grupo3.digitalbook.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private Long id;

    @NotBlank
    private String descripcion;


}
