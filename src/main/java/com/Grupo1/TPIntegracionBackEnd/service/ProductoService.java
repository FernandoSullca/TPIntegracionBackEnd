package com.Grupo1.TPIntegracionBackEnd.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo1.TPIntegracionBackEnd.model.Producto;
import com.Grupo1.TPIntegracionBackEnd.repository.ProductoRepository;

@Service
public class ProductoService {


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

    public void deleteProducto(String codigo) {
        productoRepository.deleteById(codigo);
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
}
