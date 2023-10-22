package com.grupo3.digitalbook.demo.controller;

import com.grupo3.digitalbook.demo.entity.ImagenProducto;
import com.grupo3.digitalbook.demo.service.impl.ImagenProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagenProducto")
public class ImagenProductoController {


    ImagenProductoService imagenProductoService;

    public ImagenProductoController(ImagenProductoService imagenProductoService){
        this.imagenProductoService = imagenProductoService;
    }



    @GetMapping("/listar")
    public List<ImagenProducto> listarImagenProducto(){
        List<ImagenProducto> listarImagenProducto = imagenProductoService.buscarTodos();
        return listarImagenProducto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenProducto> buscarImagenProducto(Long id) throws Exception {
        return ResponseEntity.ok(imagenProductoService.buscarPorId(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarImagenProducto(@RequestBody ImagenProducto imagenProducto){
        imagenProductoService.guardar(imagenProducto);
        Long imagenProductoId = imagenProducto.getId();
        return ResponseEntity.status(HttpStatus.OK).body(imagenProductoId);
    }


    @PostMapping("/modificar")
    public ResponseEntity<?> actualizarImagenProducto(@RequestBody ImagenProducto imagenProducto){
        imagenProductoService.actualizar(imagenProducto);
        return ResponseEntity.ok().body("Se modifico el imagenProducto.");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarImagenProducto(@PathVariable Long id) throws Exception {
        ResponseEntity<?>response = null;
        imagenProductoService.eliminar(id);
        response = ResponseEntity.status(HttpStatus.OK).body("ImagenProducto eliminado.");
        return response;
    }









}

