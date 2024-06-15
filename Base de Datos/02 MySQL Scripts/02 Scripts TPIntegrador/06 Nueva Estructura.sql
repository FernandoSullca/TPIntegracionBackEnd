DROP TABLE `tpintegracion`.`lineadeventa`


CREATE TABLE Producto(
    codigo VARCHAR(20) PRIMARY KEY,
    descripcion VARCHAR(100),
    stock INT,
    activo BIT,
    precio DECIMAL(15,2)
);

CREATE TABLE Venta(
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME,
    cliente VARCHAR(200),
    total DECIMAL(15,2),
    rechazada BIT
);

CREATE TABLE LineaDeVenta(
    id INT AUTO_INCREMENT PRIMARY KEY,
    ventaID INT,
    codigoProducto VARCHAR(20),
    cantidad INT, 
    subtotal DECIMAL(15,2),
    precioUnitario DECIMAL(15,2),
    CONSTRAINT FK_LDV_Producto FOREIGN KEY (codigoProducto) REFERENCES Producto(codigo),
    CONSTRAINT FK_LDV_Venta FOREIGN KEY (ventaID) REFERENCES Venta(id)
);
