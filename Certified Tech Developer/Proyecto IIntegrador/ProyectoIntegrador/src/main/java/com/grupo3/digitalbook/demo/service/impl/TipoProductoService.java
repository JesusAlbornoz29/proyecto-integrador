package com.grupo3.digitalbook.demo.service.impl;


import com.grupo3.digitalbook.demo.entity.TipoProducto;
import com.grupo3.digitalbook.demo.exception.ResourceNotFoundException;
import com.grupo3.digitalbook.demo.repository.ITipoProductoRepository;
import com.grupo3.digitalbook.demo.service.ITipoProductoService;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

@Service
public class TipoProductoService implements ITipoProductoService {
    private static final Logger logger = Logger.getLogger(TipoProductoService.class);

    private ITipoProductoRepository iTipoProdcutoRepository;


    public TipoProductoService(ITipoProductoRepository iTipoProdcutoRepository){
        this.iTipoProdcutoRepository = iTipoProdcutoRepository;
    }

    @Override
    public void actualizar(TipoProducto tipoProducto){
        logger.info("se actualizara el tipo de producto");
        guardar(tipoProducto);
    }

    @Override
    public TipoProducto buscarPorId(Long id){
        Optional<TipoProducto> found = iTipoProdcutoRepository.findById(id);
        logger.info("se encontro el tipo de producto");
        return found.orElse(null);
    }


    @Override
    public List<TipoProducto> buscarTodos(){
        logger.info("se encontro los tipo de productos: ");
        return iTipoProdcutoRepository.findAll();
    }

    public Long guardar(TipoProducto tipoProducto){
        logger.info("se guardo el tipo de producto");
        iTipoProdcutoRepository.save(tipoProducto);
        return tipoProducto.getId();
    }


    @Override
    public void eliminar(Long id) throws ResourceNotFoundException {
        Optional<TipoProducto> found = iTipoProdcutoRepository.findById(id);
        if (found.isPresent()){
            iTipoProdcutoRepository.deleteById(id);
            logger.warn("se va a eliminar el tipo de producto"+id);
        }else {
            logger.error("no existe el tipo de producto"+id);
            throw new ResourceNotFoundException("no se encontro el producto");
        }
    }

    public TipoProducto buscarPorDescripcion(String descripcion){
        logger.info("se encontro el tipo de producto");
        return iTipoProdcutoRepository.findByDescripcion(descripcion);
    }

}