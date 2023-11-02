package com.registro.usuarios.repositorio;


import com.registro.usuarios.modelo.MarcaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMarcaProductoRepository extends JpaRepository<MarcaProducto, Long> {
}
