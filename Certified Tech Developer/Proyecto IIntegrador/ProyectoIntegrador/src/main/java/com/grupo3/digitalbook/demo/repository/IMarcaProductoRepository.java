package com.grupo3.digitalbook.demo.repository;

import com.grupo3.digitalbook.demo.entity.MarcaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMarcaProductoRepository extends JpaRepository<MarcaProducto, Long> {
    MarcaProducto findByDescripcion(String descripcion);
}
