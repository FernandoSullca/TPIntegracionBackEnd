package com.Grupo1.TPIntegracionBackEnd.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Grupo1.TPIntegracionBackEnd.model.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

	List<Venta> findByFechaBetween(LocalDateTime atStartOfDay, LocalDateTime atStartOfDay2);

}
