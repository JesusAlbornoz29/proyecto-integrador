package com.registro.usuarios.repositorio;


import com.registro.usuarios.modelo.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoProductoRepository extends JpaRepository<TipoProducto,Long> {
}