package com.Grupo1.TPIntegracionBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo1.TPIntegracionBackEnd.model.Producto;
import com.Grupo1.TPIntegracionBackEnd.service.ProductoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
	    public Producto createProducto(@RequestBody Producto producto) {
	        return productoService.createProducto(producto);
	    }

	    @DeleteMapping("/{codigo}")
	    public ResponseEntity<Void> deleteProducto(@PathVariable String codigo) {
	        productoService.deleteProducto(codigo);
	        return ResponseEntity.noContent().build();
	    }
}
