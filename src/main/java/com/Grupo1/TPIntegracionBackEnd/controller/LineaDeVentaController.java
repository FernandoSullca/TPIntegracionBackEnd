package com.Grupo1.TPIntegracionBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo1.TPIntegracionBackEnd.model.LineaDeVenta;
import com.Grupo1.TPIntegracionBackEnd.model.LineaDeVentaId;
import com.Grupo1.TPIntegracionBackEnd.service.LineaDeVentaService;

@RestController
@RequestMapping("/api/lineasdeventa")
public class LineaDeVentaController {

    @Autowired
    private LineaDeVentaService lineaDeVentaService;

    @GetMapping
    public List<LineaDeVenta> getAllLineasDeVenta() {
        return lineaDeVentaService.getAllLineasDeVenta();
    }
    
    @GetMapping("/{ventaID}/{nroLinea}")
    public ResponseEntity<LineaDeVenta> getLineaDeVentaById(@PathVariable Integer ventaID, @PathVariable Integer nroLinea) {
        LineaDeVentaId id = new LineaDeVentaId(ventaID, nroLinea);
        LineaDeVenta lineaDeVenta = lineaDeVentaService.getLineaDeVentaById(id);
        if (lineaDeVenta != null) {
            return ResponseEntity.ok(lineaDeVenta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{ventaID}/{nroLinea}")
    public ResponseEntity<Void> deleteLineaDeVenta(@PathVariable Integer ventaID, @PathVariable Integer nroLinea) {
        LineaDeVentaId id = new LineaDeVentaId(ventaID, nroLinea);
        lineaDeVentaService.deleteLineaDeVenta(id);
        return ResponseEntity.noContent().build();
    }

}
