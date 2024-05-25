package com.Grupo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo1.model.Usuario;
import com.Grupo1.repository.UsuarioRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    // Método usando Criteria API
    public Usuario loginByCriteria(String username, String password) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);
        Root<Usuario> root = query.from(Usuario.class);
        
        Predicate usernamePredicate = cb.equal(root.get("username"), username);
        Predicate passwordPredicate = cb.equal(root.get("password"), password);
        Predicate loginPredicate = cb.and(usernamePredicate, passwordPredicate);
        
        query.select(root).where(loginPredicate);
        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    // Método usando JPQL
    public Usuario loginByJPQL(String username, String password) {
        String jpql = "SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password";
        try {
            return entityManager.createQuery(jpql, Usuario.class)
                                .setParameter("username", username)
                                .setParameter("password", password)
                                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    // Método usando SQL nativo
    public Usuario loginByNativeQuery(String username, String password) {
        String sql = "SELECT * FROM usuario WHERE username = :username AND password = :password";
        try {
            return (Usuario) entityManager.createNativeQuery(sql, Usuario.class)
                                .setParameter("username", username)
                                .setParameter("password", password)
                                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
