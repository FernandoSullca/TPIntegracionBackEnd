package com.Grupo1.TPIntegracionBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo1.TPIntegracionBackEnd.model.Producto;
import com.Grupo1.TPIntegracionBackEnd.service.ProductoService;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	  @Autowired 
	    private ProductoService productoService;

	    @GetMapping
	    public List<Producto> getAllProductos() {
	        return productoService.getAllProductos();
	    }

	    @GetMapping("/{codigo}")
	    public ResponseEntity<Producto> getProductoById(@PathVariable String codigo) {
	        return productoService.getProductoById(codigo)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<?> createProducto(@RequestBody Producto producto) {
	    	   try {	
	    	if (producto.getCodigo() == null || producto.getCodigo().isEmpty()) {
	              throw new IllegalArgumentException("El campo 'codigo' no puede estar vacío.");
	          }
	    	  boolean existe=productoService.existe(producto.getCodigo());
	    	  if (existe) {
	    		  return ResponseEntity.status(HttpStatus.CONFLICT).body("El producto con el codigo ya existe");
	    	  }
	    
            Producto nuevoProducto = productoService.createProducto(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
            
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // Manejar cualquier otra excepción no controlada
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado.");
        }
	  }
	    

	    @DeleteMapping("/{codigo}")
	    public ResponseEntity<Void> deleteProducto(@PathVariable String codigo) {
	        productoService.deleteProducto(codigo);
	        return ResponseEntity.noContent().build();
	    }
	    
	    @PostMapping("/actualizarStock") 
	    public ResponseEntity<?> updateStockProducto(@RequestBody Producto producto) throws Exception {
	    	 Producto actualizado = productoService.updateStock(producto);
	         return ResponseEntity.ok(actualizado);
	  }
}
