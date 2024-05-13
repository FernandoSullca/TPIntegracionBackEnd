# Verificar con select database(); que base de datos esta en uso
# de otra manera, usar use tpintegrador; para usar esta base
create table Producto(
	codigo varchar(20),
    descripcion varchar(100),
    stock int,
    activo bit,
    precio decimal(15,2),
    CONSTRAINT PK_Producto PRIMARY KEY (codigo)
    );
    
    create table Venta(
		id int,
        fecha datetime,
        cliente varchar(200),
        total decimal(15,2),
        rechazada bit, #Este es un agregado que no esta en el DER, pero por lo charlado lo agrego de prepo, 0=valida, 1=no valida
        CONSTRAINT PK_Venta PRIMARY KEY (id)
    );
    
    create table LineaDeVenta(
		ventaID int,
        nroLinea int,
        codigoProducto varchar(20),
        cantidad int, 
        subtotal decimal(15,2),
        CONSTRAINT PK_LineaDeVenta PRIMARY KEY (ventaID,nroLinea),
		CONSTRAINT FK_LDV_Producto FOREIGN KEY (codigoProducto) REFERENCES Producto(codigo),
        CONSTRAINT FK_LDV_Venta FOREIGN KEY (ventaID) REFERENCES Venta(id)
    );