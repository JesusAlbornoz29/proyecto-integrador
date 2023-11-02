package com.registro.usuarios.servicio;


import com.registro.usuarios.exception.ResourceNotFoundException;
import com.registro.usuarios.modelo.TipoProducto;

import java.util.List;

public interface ITipoProductoService {

    void actualizar (TipoProducto tipoProducto);

    TipoProducto buscarPorId (Long id);

    List<TipoProducto> buscarTodos();

    Long guardar (TipoProducto tipoProducto);

    void eliminar (Long id) throws ResourceNotFoundException;
}
