package com.grupo3.digitalbook.demo.repository;

import com.grupo3.digitalbook.demo.entity.ImagenProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImagenProductoRepository extends JpaRepository<ImagenProducto, Long> {
}
