package com.grupo3.digitalbook.demo.service;

import com.grupo3.digitalbook.demo.entity.Producto;
import com.grupo3.digitalbook.demo.exception.BadRequestException;
import com.grupo3.digitalbook.demo.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    List<Producto> traertodos();

    Optional<Producto> findProductoById(Long id) throws ResourceNotFoundException;

    Producto guardarProducto(Producto productoNew) throws BadRequestException;

    void eliminar(Long id) throws ResourceNotFoundException;

    Producto updateProducto(Producto productoNew,Long id) throws BadRequestException,ResourceNotFoundException;
}
