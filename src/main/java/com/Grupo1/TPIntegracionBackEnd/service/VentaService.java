package com.Grupo1.TPIntegracionBackEnd.service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Grupo1.TPIntegracionBackEnd.model.Venta;
import com.Grupo1.TPIntegracionBackEnd.repository.VentaRepository;

@Service
public class VentaService {

	@Autowired
    private VentaRepository ventaRepository;

	public Venta getVenta(Integer idventa) {
        return ventaRepository.getById(idventa);
    }
	
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

	public Venta saveVenta(Venta venta) {
		return ventaRepository.save(venta);
	}

	public List<Venta> getEntreFechas(LocalDateTime atStartOfDay, LocalDateTime atStartOfDay2) {
		// TODO Auto-generated method stub
		 return ventaRepository.findByFechaBetween(atStartOfDay, atStartOfDay2);
	}

	public Optional<Venta> getVentaById(Integer codigo) {
		// TODO Auto-generated method stub
		return ventaRepository.findById(codigo);
	}
}
