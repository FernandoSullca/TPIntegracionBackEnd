package com.Grupo1.TPIntegracionBackEnd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo1.TPIntegracionBackEnd.model.LineaDeVenta;
import com.Grupo1.TPIntegracionBackEnd.model.LineaDeVentaId;
import com.Grupo1.TPIntegracionBackEnd.model.Usuario;
import com.Grupo1.TPIntegracionBackEnd.repository.LineaDeVentaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class LineaDeVentaService {

	   @Autowired
	    private LineaDeVentaRepository lineaDeVentaRepository;

	   
	   @PersistenceContext
	    private EntityManager entityManager;
	   
	    public List<LineaDeVenta> getAllLineasDeVenta() {
	        return lineaDeVentaRepository.findAll();
	    }
	    
	    public LineaDeVenta getLineaDeVentaById(LineaDeVentaId id) {
	        return lineaDeVentaRepository.findById(id).orElse(null);
	    }
	    
	    public void deleteLineaDeVenta(LineaDeVentaId id) {
	    	lineaDeVentaRepository.deleteById(id);	    }

	    public LineaDeVenta saveLineaDeVenta(LineaDeVenta lineaDeVenta) {
//	    	 if (lineaDeVenta.getVentaID() == null || lineaDeVenta.getNroLinea()==null) {
//	    		 lineaDeVenta.setNroLinea(10);
//	    		 lineaDeVenta.setVentaID(10);
//	         }
	        return lineaDeVentaRepository.save(lineaDeVenta);
	    }
	    private UUID generateUniqueCode() {
	        return UUID.randomUUID();
	    }

		public List<LineaDeVenta> getLineaDeVentaByVentaId(Integer ventaId) {
			List<LineaDeVenta> Lineas = new ArrayList<>();
			 String sql = "SELECT * FROM lineadeventa WHERE ventaid = :ventaID";
		        try {
					return (List<LineaDeVenta>) entityManager.createNativeQuery(sql, LineaDeVenta.class)
		                                .setParameter("ventaID", ventaId)
		                                .getResultList();
		        } catch (NoResultException e) {
		            return Lineas;
		        }
		}
}
