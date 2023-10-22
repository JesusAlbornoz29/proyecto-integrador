package com.grupo3.digitalbook.demo.service;

import com.grupo3.digitalbook.demo.entity.ImagenProducto;
import com.grupo3.digitalbook.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface IImagenProductoService {
    void actualizar (ImagenProducto imagenProducto);

    ImagenProducto buscarPorId (Long id);

    List<ImagenProducto> buscarTodos();

    Long guardar (ImagenProducto imagenProducto);

    void eliminar (Long id) throws ResourceNotFoundException;
}
