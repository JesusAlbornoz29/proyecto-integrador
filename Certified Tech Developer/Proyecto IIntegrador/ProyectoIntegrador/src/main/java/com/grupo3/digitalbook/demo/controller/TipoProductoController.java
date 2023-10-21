package com.grupo3.digitalbook.demo.controller;


import com.grupo3.digitalbook.demo.entity.TipoProducto;
import com.grupo3.digitalbook.demo.exception.ResourceNotFoundException;
import com.grupo3.digitalbook.demo.service.impl.TipoProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoProducto")
public class TipoProductoController {

    TipoProductoService tipoProductoService;

    public  TipoProductoController ( TipoProductoService tipoProductoService){
        this.tipoProductoService = tipoProductoService;
    }

    @GetMapping("/listar")
    public List<TipoProducto> buscarTipoProducto(){
        List<TipoProducto> listarTipoProducto = tipoProductoService.buscarTodos();
        return listarTipoProducto;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoProducto> buscarTipoProducto(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(tipoProductoService.buscarPorId(id));
    }
    @PostMapping("/guardar")
    public ResponseEntity<?> guardarTipoProducto(@RequestBody TipoProducto tipoProducto){
        tipoProductoService.guardar(tipoProducto);
        Long tipoProdcutoId = tipoProducto.getId();
        return ResponseEntity.status(HttpStatus.OK).body(tipoProdcutoId);
    }


    @PostMapping("/modificar")
    public ResponseEntity<?> actualizarTipoProducto(@RequestBody TipoProducto tipoProducto){
        tipoProductoService.actualizar(tipoProducto);
        return ResponseEntity.ok().body("se modifico el tipo de producto");

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarTipoProducto(@PathVariable Long id) throws ResourceNotFoundException{
        ResponseEntity<?> response = null;
        tipoProductoService.eliminar(id);
        response = ResponseEntity.status(HttpStatus.OK).body("se elimino tipo de producto");
        return response;
    }
}