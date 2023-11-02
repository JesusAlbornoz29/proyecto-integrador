package com.registro.usuarios.repositorio;


import com.registro.usuarios.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
