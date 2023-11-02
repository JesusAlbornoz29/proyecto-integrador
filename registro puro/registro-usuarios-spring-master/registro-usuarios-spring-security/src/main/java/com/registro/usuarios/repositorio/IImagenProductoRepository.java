package com.registro.usuarios.repositorio;


import com.registro.usuarios.modelo.ImagenProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImagenProductoRepository extends JpaRepository<ImagenProducto, Long> {
}
