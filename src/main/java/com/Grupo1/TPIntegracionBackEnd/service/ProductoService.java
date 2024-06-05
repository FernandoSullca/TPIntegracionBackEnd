package com.Grupo1.TPIntegracionBackEnd.service;

import java.util.List;
import java.util.Optional;

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
        return productoRepository.save(producto);
    }

    public void deleteProducto(String codigo) {
        productoRepository.deleteById(codigo);
    }
}
