package com.Grupo1.TPIntegracionBackEnd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "lineadeventa")
//@IdClass(LineaDeVentaId.class)//Para solucionar la serializacion de la clave compuesta...
public class LineaDeVenta {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    private Integer id;
	  
//	@Id
//    @Column(name = "ventaID", nullable = false)
//    private Integer ventaID;
//
//    @Id
//    @Column(name = "nroLinea", nullable = false)
//    private Integer nroLinea;

    @ManyToOne 
    @JoinColumn(name = "codigoProducto", referencedColumnName = "codigo")
    private Producto producto;


	@Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal", precision = 15, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "precioUnitario", precision = 15, scale = 2)
    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name = "ventaID")
//    @JsonBackReference
    @JsonIgnore
    private Venta venta;

    // Getters and Setters

    public Integer getId() {
  		return id;
  	}

  	public void setId(Integer id) {
  		this.id = id;
  	}
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
