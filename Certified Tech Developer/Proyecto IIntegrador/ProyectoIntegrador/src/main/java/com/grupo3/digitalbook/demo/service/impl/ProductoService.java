package com.grupo3.digitalbook.demo.service.impl;

import com.grupo3.digitalbook.demo.entity.Producto;
import com.grupo3.digitalbook.demo.exception.BadRequestException;
import com.grupo3.digitalbook.demo.exception.ResourceNotFoundException;
import com.grupo3.digitalbook.demo.repository.IProductoRepository;
import com.grupo3.digitalbook.demo.service.IProductoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {
    private final static Logger LOGGER = Logger.getLogger(ProductoService.class);

    @Autowired
    IProductoRepository iProductoRepository;


    public Producto guardarProducto(Producto productoNew) throws BadRequestException{
        if(productoNew.getTipoProducto() != null & productoNew.getMarcaProducto() !=null){
            LOGGER.info("se guardo el producto con exito");
            return iProductoRepository.save(productoNew);
        } else {
            LOGGER.warn("no se guardo el producto");
            throw new BadRequestException("no se guardo el producto");
        }
    }





    public Optional<Producto> findProductoById(Long id) throws ResourceNotFoundException{

        Optional<Producto> producto = iProductoRepository.findById(id);
        if (producto.isPresent()){
            LOGGER.info("se encontro el producto");
            return producto;
        }else {
            LOGGER.error("no existe este producto");
            throw new ResourceNotFoundException("no existe este producto");
        }
    }

    public List<Producto> traertodos(){
        return iProductoRepository.findAll();
    }

    public Producto updateProducto(Producto productoNew,Long id)throws BadRequestException, ResourceNotFoundException{
        return iProductoRepository.findById(id).map(
                producto -> {
                    producto.setId(productoNew.getId());
                    producto.setNombre(productoNew.getNombre());
                    producto.setDescripcion(productoNew.getDescripcion());
                    producto.setPrecio(productoNew.getPrecio());
                    producto.setImagen(productoNew.getImagen());
                    producto.setMarcaProducto(productoNew.getMarcaProducto());
                    producto.setTipoProducto(productoNew.getTipoProducto());
                    LOGGER.info("se actualizo el producto");
                    return iProductoRepository.save(producto);
                }
        ).get();
    }

    public void eliminar(Long id) throws ResourceNotFoundException{
        if(iProductoRepository.existsById(id)){
            iProductoRepository.deleteById(id);
            LOGGER.info("se elimino correctamente");
        }else {
            LOGGER.error("no se pudo eliminar el producto");
            throw new ResourceNotFoundException("no se elimino el producto");
        }
    }
}
