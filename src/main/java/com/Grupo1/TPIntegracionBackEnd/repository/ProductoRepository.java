package com.Grupo1.TPIntegracionBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Grupo1.TPIntegracionBackEnd.model.Producto;
import com.Grupo1.TPIntegracionBackEnd.model.Usuario;

public interface ProductoRepository extends JpaRepository<Producto, String>{

}
