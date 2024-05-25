package com.Grupo1.TPIntegracionBackEnd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Grupo1.TPIntegracionBackEnd.model.Usuario;

@Service
public interface UsuarioService {

	Usuario loginByCriteria(String username, String password);

	Usuario loginByJPQL(String username, String password);

	Usuario loginByNativeQuery(String username, String password);

	List<Usuario> getAllUsuarios();

	Usuario getUsuarioById(Long id);

}
