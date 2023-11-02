package com.registro.usuarios.servicio;


import com.registro.usuarios.exception.BadRequestException;
import com.registro.usuarios.exception.ResourceNotFoundException;
import com.registro.usuarios.modelo.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {


    List<Producto> traertodos();

    Optional<Producto> findProductoById(Long id) throws ResourceNotFoundException;

    Producto guardarProducto(Producto productoNew) throws BadRequestException;

    void eliminar(Long id) throws ResourceNotFoundException;

    Producto updateProducto(Producto productoNew,Long id) throws BadRequestException,ResourceNotFoundException;
}
