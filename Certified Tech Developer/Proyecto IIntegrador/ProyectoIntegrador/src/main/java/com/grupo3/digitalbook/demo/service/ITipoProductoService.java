package com.grupo3.digitalbook.demo.service;

import com.grupo3.digitalbook.demo.entity.TipoProducto;
import com.grupo3.digitalbook.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface ITipoProductoService {

    void actualizar (TipoProducto tipoProducto);

    TipoProducto buscarPorId (Long id);

    List<TipoProducto> buscarTodos();

    Long guardar (TipoProducto tipoProducto);

    void eliminar (Long id) throws ResourceNotFoundException;
}
