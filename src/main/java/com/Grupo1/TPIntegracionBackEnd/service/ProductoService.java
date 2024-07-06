package com.Grupo1.TPIntegracionBackEnd.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Grupo1.TPIntegracionBackEnd.model.Producto;
import com.Grupo1.TPIntegracionBackEnd.model.Usuario;
import com.Grupo1.TPIntegracionBackEnd.repository.ProductoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class ProductoService {

	@PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(String codigo) {
    	
        return productoRepository.findById(codigo);
    }

    public Producto createProducto(Producto producto) {
    	 if (producto.getCodigo() == null || producto.getCodigo().isEmpty()) {
             producto.setCodigo(generateUniqueCode());
         }
        return productoRepository.save(producto);
    }

    public Producto deleteProducto(String codigo) throws Exception {
    	
    	    Optional<Producto> productoExistente =null;
    		productoExistente = productoRepository.findById(codigo);
    	        if (productoExistente != null ||productoExistente.isPresent()) {
    	        	boolean estado=productoExistente.get().getActivo();
    	            productoExistente.get().setActivo(!estado);
    	            return productoRepository.save(productoExistente.get());
    	        } else {
    	            throw new Exception("Producto no encontrado");
    	        }   
    	//productoRepository.deleteById(codigo);
    }
    
    private String generateUniqueCode() {
        return UUID.randomUUID().toString();
    }

	public boolean existe(String codigo) {
		// TODO Auto-generated method stub
		 return productoRepository.existsById(codigo);
		
	}
	public Producto updateStock(Producto productoUpdate) throws Exception {
		 Optional<Producto> productoExistente =null;
		productoExistente = productoRepository.findById(productoUpdate.getCodigo());
	        if (productoExistente != null ||productoExistente.isPresent()) {
	            productoExistente.get().setStock(productoUpdate.getStock());
	            return productoRepository.save(productoExistente.get());
	        } else {
	            throw new Exception("Producto no encontrado");
	        }
	}

	public Producto updateProducto(Producto productoUpdate) throws Exception {
		 Optional<Producto> productoExistente =null;
			productoExistente = productoRepository.findById(productoUpdate.getCodigo());
		        if (productoExistente != null ||productoExistente.isPresent()) {
		            productoExistente.get().setStock(productoUpdate.getStock());
		            productoExistente.get().setDescripcion(productoUpdate.getDescripcion());
		            productoExistente.get().setPrecio(productoUpdate.getPrecio());
		            return productoRepository.save(productoExistente.get());
		        } else {
		            throw new Exception("Producto no encontrado");
		        }
	}
}
