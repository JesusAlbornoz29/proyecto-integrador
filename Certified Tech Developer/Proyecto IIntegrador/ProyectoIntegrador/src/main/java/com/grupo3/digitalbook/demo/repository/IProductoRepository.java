package com.grupo3.digitalbook.demo.repository;

import com.grupo3.digitalbook.demo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
