package com.Grupo1.TPIntegracionBackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo1.TPIntegracionBackEnd.model.Venta;
import com.Grupo1.TPIntegracionBackEnd.repository.VentaRepository;

@Service
public class VentaService {

	@Autowired
    private VentaRepository ventaRepository;

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

	public Venta saveVenta(Venta venta) {
		// TODO Auto-generated method stub
	    return ventaRepository.save(venta);
	}
}
