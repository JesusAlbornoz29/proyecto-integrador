package com.registro.usuarios.servicio;


import com.registro.usuarios.exception.ResourceNotFoundException;
import com.registro.usuarios.modelo.ImagenProducto;

import java.util.List;

public interface IImagenProductoService {

    void actualizar(ImagenProducto imagenProducto);

    ImagenProducto buscarPorId (Long id);

    List<ImagenProducto> buscarTodos();

    Long guardar (ImagenProducto imagenProducto);

    void eliminar (Long id) throws ResourceNotFoundException;
}
