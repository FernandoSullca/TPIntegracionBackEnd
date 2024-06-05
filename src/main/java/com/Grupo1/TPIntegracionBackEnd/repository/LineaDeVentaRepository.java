package com.Grupo1.TPIntegracionBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Grupo1.TPIntegracionBackEnd.model.LineaDeVenta;
import com.Grupo1.TPIntegracionBackEnd.model.LineaDeVentaId;

public interface LineaDeVentaRepository extends JpaRepository<LineaDeVenta,  LineaDeVentaId>{

	

}
