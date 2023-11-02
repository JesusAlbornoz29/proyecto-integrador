package com.registro.usuarios.servicio;


import com.registro.usuarios.exception.ResourceNotFoundException;
import com.registro.usuarios.modelo.MarcaProducto;

import java.util.List;

public interface IMarcaProductoService {
    void actualizar (MarcaProducto marcaProducto);

    MarcaProducto buscarPorId (Long id);

    List<MarcaProducto> buscarTodos();

    Long guardar (MarcaProducto marcaProducto);

    void eliminar (Long id) throws ResourceNotFoundException; // Que hace throws ResourceNotFoundException?
    // Es una excepcion que se lanza cuando no se encuentra un recurso, en este caso un MarcaProducto
}
