package com.Grupo1.TPIntegracionBackEnd.service;

import java.util.List;
import java.util.UUID;

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

	    public LineaDeVenta saveLineaDeVenta(LineaDeVenta lineaDeVenta) {
	    	 if (lineaDeVenta.getVentaID() == null || lineaDeVenta.getNroLinea()==null) {
	    		 lineaDeVenta.setNroLinea(10);
	    		 lineaDeVenta.setVentaID(10);
	         }
	        return lineaDeVentaRepository.save(lineaDeVenta);
	    }
	    private UUID generateUniqueCode() {
	        return UUID.randomUUID();
	    }
}
