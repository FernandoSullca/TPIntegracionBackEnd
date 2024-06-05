package com.Grupo1.TPIntegracionBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Grupo1.TPIntegracionBackEnd.model.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

}
