package com.grupo3.digitalbook.demo.service.impl;

import com.grupo3.digitalbook.demo.entity.ImagenProducto;
import com.grupo3.digitalbook.demo.exception.ResourceNotFoundException;
import com.grupo3.digitalbook.demo.repository.IImagenProductoRepository;
import com.grupo3.digitalbook.demo.service.IImagenProductoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ImagenProductoService implements IImagenProductoService {

    private static final Logger logger = Logger.getLogger(ImagenProductoService.class); // Logger para mostrar mensajes en la consola

    private IImagenProductoRepository iImagenProductoRepository; // Repositorio de la entidad ImagenProducto para acceder a la base de datos

    public ImagenProductoService(IImagenProductoRepository iImagenProductoRepository) {
        this.iImagenProductoRepository = iImagenProductoRepository;
    }



    @Override
    public void actualizar(ImagenProducto imagenProducto) {
        logger.info("ImagenProducto - actualizar: Se va actualizar la imagenProducto");
        guardar(imagenProducto); // El método guardar() utiliza .save; este lo que hace es crear si el ID = 0 pero si ID!=0 actualiza los cambios.
    }

    @Override
    public ImagenProducto buscarPorId(Long id) {
        Optional<ImagenProducto> found = iImagenProductoRepository.findById(id); // Utilizo el objeto Optional que permite que "found" devuelva nulo o MarcaProducto
        logger.info("ImagenProducto - buscarPorId: Se ha actualizado la imagenProducto");
        return found.orElse(null); // Si found no tiene contenido devolvemos null
    }

    @Override
    public List<ImagenProducto> buscarTodos() {
        logger.info("ImagenProducto - buscarTodos: Se mostrara la lista de imagenProductos");
        return iImagenProductoRepository.findAll();
    }

    @Override
    public Long guardar(ImagenProducto imagenProducto) {
        logger.info("ImagenProducto - guardar: Se va guardar la imagenProducto");
        iImagenProductoRepository.save(imagenProducto);
        return imagenProducto.getId();
    }

    @Override
    public void eliminar(Long id) throws ResourceNotFoundException {
        Optional<ImagenProducto> found = iImagenProductoRepository.findById(id);
        if(found.isPresent()){
            iImagenProductoRepository.deleteById(id);
            logger.warn("ImagenProducto - eliminar: Se ha eliminado la imagenProducto");
        } else {
            throw new ResourceNotFoundException("No se encontro la imagenProducto con el id: " + id);
        }
    }
}
