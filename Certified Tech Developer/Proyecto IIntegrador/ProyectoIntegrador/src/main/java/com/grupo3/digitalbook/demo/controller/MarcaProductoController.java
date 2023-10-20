package com.grupo3.digitalbook.demo.controller;


import com.grupo3.digitalbook.demo.entity.MarcaProducto;
import com.grupo3.digitalbook.demo.exception.ResourceNotFoundException;
import com.grupo3.digitalbook.demo.service.impl.MarcaProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/marcaProducto")
public class MarcaProductoController {

    MarcaProductoService marcaProductoService;

    //Constructor
    public MarcaProductoController(MarcaProductoService marcaProductoService){
        this.marcaProductoService = marcaProductoService;
    }


    // En la url /marcaProducto/listar se listan todos los marcaProductos
    @GetMapping("/listar")
    public List<MarcaProducto>  buscarMarcaProducto(){
        List<MarcaProducto> listarMarcaProductos = marcaProductoService.buscarTodos();
        return listarMarcaProductos;
    }

    // En la url /marcaProducto/{id} se busca un marcaProducto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<MarcaProducto> buscarMarcaProducto(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(marcaProductoService.buscarPorId(id));
    }

    // En la url /marcaProducto/guardar se guarda un marcaProducto POST
    @PostMapping("/guardar")
    public ResponseEntity<?> guardarMarcaProducto(@RequestBody MarcaProducto marcaProducto){
        marcaProductoService.guardar(marcaProducto);
        Long marcaProductoId = marcaProducto.getId();
        return ResponseEntity.status(HttpStatus.OK).body(marcaProductoId);
    }

    // En la url /marcaProducto/modificar se modifica un marcaProducto PUT
    @PostMapping("/modificar")
    public ResponseEntity<?> actualizarMarcaProducto(@RequestBody MarcaProducto marcaProducto){
        marcaProductoService.actualizar(marcaProducto);
        return ResponseEntity.ok().body("Se modifico el marcaProducto.");
    }

    // En la url /marcaProducto/eliminar/{id} se elimina un marcaProducto DELETE
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarMarcaProducto(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<?>response = null;
        marcaProductoService.eliminar(id);
        response = ResponseEntity.status(HttpStatus.OK).body("MarcaProducto eliminado.");
        return response;
    }


}
