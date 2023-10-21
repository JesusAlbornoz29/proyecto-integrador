package com.grupo3.digitalbook.demo.controller;


import com.grupo3.digitalbook.demo.entity.Producto;
import com.grupo3.digitalbook.demo.exception.BadRequestException;
import com.grupo3.digitalbook.demo.exception.ResourceNotFoundException;
import com.grupo3.digitalbook.demo.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoContoller {

    @Autowired
    private IProductoService iProductoService;

    public ProductoContoller(IProductoService iProductoService){
        this.iProductoService = iProductoService;
    }

    @PostMapping("/crearProducto")
    public ResponseEntity<?> guardarProducto(@RequestBody Producto producto) throws BadRequestException, ResourceNotFoundException{
        return ResponseEntity.status(HttpStatus.CREATED).body(iProductoService.guardarProducto(producto));
    }

    @GetMapping
    public ResponseEntity<List<Producto>>listProducto(){
        return ResponseEntity.ok(iProductoService.traertodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) throws ResourceNotFoundException{
        iProductoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable Long id)throws ResourceNotFoundException{
        Optional<Producto> producto = iProductoService.findProductoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity <?> updateProducto(@RequestBody Producto productoNew,@PathVariable Long id)throws BadRequestException,ResourceNotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(iProductoService.updateProducto(productoNew,id));
    }

}
