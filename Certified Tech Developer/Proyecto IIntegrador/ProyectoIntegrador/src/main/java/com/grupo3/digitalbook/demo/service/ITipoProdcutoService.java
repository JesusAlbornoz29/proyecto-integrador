package com.grupo3.digitalbook.demo.service;

import com.grupo3.digitalbook.demo.entity.MarcaProducto;
import com.grupo3.digitalbook.demo.entity.TipoProducto;
import com.grupo3.digitalbook.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface ITipoProdcutoService {

    void actualizar (TipoProducto tipoProducto);

    TipoProducto buscarPorId(Long id);

    List<TipoProducto> buscarTodos();

    Long guardar (TipoProducto tipoProducto);

    void eliminar (long id) throws ResourceNotFoundException;
}
