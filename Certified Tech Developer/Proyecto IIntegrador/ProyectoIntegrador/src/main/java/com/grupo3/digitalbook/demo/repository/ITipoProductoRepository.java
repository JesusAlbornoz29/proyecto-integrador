package com.grupo3.digitalbook.demo.repository;

import com.grupo3.digitalbook.demo.entity.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoProductoRepository extends JpaRepository<TipoProducto,Long> {
    TipoProducto findByDescripcion(String descripcion);
}