package com.Grupo1.TPIntegracionBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo1.TPIntegracionBackEnd.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	  Usuario findByUsername(String username);
}
