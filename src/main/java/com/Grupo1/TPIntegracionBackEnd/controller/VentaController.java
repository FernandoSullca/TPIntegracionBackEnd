package com.Grupo1.TPIntegracionBackEnd.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo1.TPIntegracionBackEnd.model.Venta;
import com.Grupo1.TPIntegracionBackEnd.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;
    
    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.getAllVentas();
    }
    
    @PostMapping
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
    	
        Venta nuevavendta= ventaService.saveVenta(venta);
	    return ResponseEntity.status(HttpStatus.CREATED).body(nuevavendta);
    }
    
    @GetMapping("/reportes")
    public List<Venta> getVentasByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ventaService.getEntreFechas(startDate.atStartOfDay(), endDate.plusDays(1).atStartOfDay()); 
    }
}
