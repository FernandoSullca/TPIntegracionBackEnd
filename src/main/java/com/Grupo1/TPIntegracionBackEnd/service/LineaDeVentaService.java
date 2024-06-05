package com.Grupo1.TPIntegracionBackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo1.TPIntegracionBackEnd.model.LineaDeVenta;
import com.Grupo1.TPIntegracionBackEnd.model.LineaDeVentaId;
import com.Grupo1.TPIntegracionBackEnd.repository.LineaDeVentaRepository;

@Service
public class LineaDeVentaService {

	   @Autowired
	    private LineaDeVentaRepository lineaDeVentaRepository;

	    public List<LineaDeVenta> getAllLineasDeVenta() {
	        return lineaDeVentaRepository.findAll();
	    }
	    
	    public LineaDeVenta getLineaDeVentaById(LineaDeVentaId id) {
	        return lineaDeVentaRepository.findById(id).orElse(null);
	    }
	    
	    public void deleteLineaDeVenta(LineaDeVentaId id) {
	    	lineaDeVentaRepository.deleteById(id);	    }
}
