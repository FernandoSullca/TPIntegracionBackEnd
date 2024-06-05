package com.Grupo1.TPIntegracionBackEnd.model;

import java.io.Serializable;
import java.util.Objects;

public class LineaDeVentaId  implements Serializable{
	 
	public LineaDeVentaId( ) {
	
	}
	public LineaDeVentaId(Integer ventaID, Integer nroLinea) {
//		super();
		this.ventaID = ventaID;
		this.nroLinea = nroLinea;
	}
	private Integer ventaID;
	    private Integer nroLinea;
		public Integer getVentaID() {
			return ventaID;
		}
		public void setVentaID(Integer ventaID) {
			this.ventaID = ventaID;
		}
		public Integer getNroLinea() {
			return nroLinea;
		}
		public void setNroLinea(Integer nroLinea) {
			this.nroLinea = nroLinea;
		}
		@Override
		public int hashCode() {
			return Objects.hash(nroLinea, ventaID);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LineaDeVentaId other = (LineaDeVentaId) obj;
			return Objects.equals(nroLinea, other.nroLinea) && Objects.equals(ventaID, other.ventaID);
		}
		@Override
		public String toString() {
			return "LineaDeVentaId [ventaID=" + ventaID + ", nroLinea=" + nroLinea + "]";
		}

}
