package com.grupo3.digitalbook.demo.service.impl;

import com.grupo3.digitalbook.demo.entity.MarcaProducto;
import com.grupo3.digitalbook.demo.exception.ResourceNotFoundException;
import com.grupo3.digitalbook.demo.repository.IMarcaProductoRepository;
import com.grupo3.digitalbook.demo.service.IMarcaProductoService;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;


@Service
public class MarcaProductoService implements IMarcaProductoService {
    private static final Logger logger = Logger.getLogger(MarcaProductoService.class);

    // Repositorio de la entidad MarcaProducto para acceder a la base de datos
    private IMarcaProductoRepository iMarcaProductoRepository;

    // Constructor de la clase MarcaProductoService que permite la inyección de dependencias
    public MarcaProductoService(IMarcaProductoRepository iMarcaProductoRepository) {
        this.iMarcaProductoRepository = iMarcaProductoRepository;
    }

    // Actualizo una MarcaProducto en la base de datos
    @Override
    public void actualizar(MarcaProducto marcaProducto) {
        logger.info("MarcaProducto - actualizar: Se va actualizar la marcaProducto");
        guardar(marcaProducto); // El método guardar() utiliza .save; este lo que hace es crear si el ID = 0 pero si ID!=0 actualiza los cambios.
    }

    // Busco una MarcaProducto por su Id, si lo encuentro retorno la MarcaProducto, sino muestro null
    @Override
    public MarcaProducto buscarPorId(Long id) {
        Optional<MarcaProducto> found = iMarcaProductoRepository.findById(id); // Utilizo el objeto Optional que permite que "found" devuelva nulo o MarcaProducto
        logger.info("MarcaProducto - buscarPorId: Se ha actualizado la marcaProducto");
        return found.orElse(null); // Si found no tiene contenido devolvemos null
    }


    @Override
    public List<MarcaProducto> buscarTodos(){
        logger.info("MarcaProducto - buscarTodos: Se mostrara la lista de marcaProductos");
        return iMarcaProductoRepository.findAll();
    }

    // Guardo una MarcaProducto en la base de datos y retorno el ID de la MarcaProducto guardada
    public Long guardar(MarcaProducto marcaProducto){
        logger.info("MarcaProducto - guardar: Se va guardar la marcaProducto");
        iMarcaProductoRepository.save(marcaProducto);
        return marcaProducto.getId();
    }

    public void eliminar(Long id) throws ResourceNotFoundException {
        Optional<MarcaProducto> found = iMarcaProductoRepository.findById(id);
        if(found.isPresent()){
            iMarcaProductoRepository.deleteById(id);
            logger.warn("MarcaProducto - eliminar: Se ha eliminado la marcaProducto");
        } else {
            logger.error("MarcaProducto - eliminar: No se ha encontrado la marcaProducto"+id);
            throw new ResourceNotFoundException("No se ha encontrado la marcaProducto");
        }
    }

    public MarcaProducto buscarPorDescripcion(String descripcion) throws ResourceNotFoundException {
        MarcaProducto marcaProducto = iMarcaProductoRepository.findByDescripcion(descripcion);
        if(marcaProducto != null){
            logger.info("MarcaProducto - buscarPorDescripcion: Se ha encontrado la marcaProducto");
            return marcaProducto;
        } else {
            logger.error("MarcaProducto - buscarPorDescripcion: No se ha encontrado la marcaProducto");
            throw new ResourceNotFoundException("No se ha encontrado la marcaProducto");
        }
    }

}
