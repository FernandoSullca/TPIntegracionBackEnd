package com.Grupo1.TPIntegracionBackEnd.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "cliente", length = 200)
    private String cliente;

    @Column(name = "total", precision = 15, scale = 2)
    private BigDecimal total;

    @Column(name = "rechazada")
    private Boolean rechazada;

//    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<LineaDeVenta> lineasDeVenta;
//    
    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getRechazada() {
        return rechazada;
    }

    public void setRechazada(Boolean rechazada) {
        this.rechazada = rechazada;
    }

//    public List<LineaDeVenta> getLineasDeVenta() {
//        return lineasDeVenta;
//    }
//
//    public void setLineasDeVenta(List<LineaDeVenta> lineasDeVenta) {
//        this.lineasDeVenta = lineasDeVenta;
//    }
}

