/*
	Normalmente esto tendría alrededor un drop if exists, pero MySQL es un dolor de cabeza en terminos de chequeo, por lo que 
    usar este script SOLO SI ES NECESARIO, y con mucho cuidado
*/
use tpintegracion; #Para setear bien la base
select * from lineadeventa; #Verificar PRIMERO antes de hacer cualquier DROP, y ejecutar con conciencia
#Camino 1: DROPs directos
#Asumo que las columnas nuevas no tienen ninguna referencia de PK/FK, por ende este sería el camino ideal.
/*WARNING ZONE: DROPS*/
ALTER TABLE lineadeventa DROP COLUMN nro_linea; 
ALTER TABLE lineadeventa DROP COLUMN precio_unitario;
ALTER TABLE lineadeventa DROP COLUMN codigo_producto;
#Camino 2: Las columnas nuevas tienen referencias 
#Asumo que las columnas nuevas estan referenciadas, por lo que esto es más para limpiar y reconstruir la tabla original
ALTER TABLE lineadeventa DROP FOREIGN KEY FK_LDV_Venta; #Esto es para liberar a la tabla de la referencia Venta <-> Linea de Venta
ALTER TABLE lineadeventa DROP FOREIGN KEY FK_LDV_Producto; #Esto es para liberar a la tabla de la referencia Linea de venta <-> Producto
ALTER TABLE lineadeventa DROP PRIMARY KEY; #Esto es para liberar a la tabla de las PKs
/*WARNING ZONE: DROPS*/
ALTER TABLE lineadeventa DROP COLUMN nro_linea; 
ALTER TABLE lineadeventa DROP COLUMN precio_unitario;
ALTER TABLE lineadeventa DROP COLUMN codigo_producto;
/*Rconstruyo las referencias originales*/
ALTER TABLE lineadeventa ADD CONSTRAINT PK_LineaDeVenta PRIMARY KEY (ventaID,nroLinea);
ALTER TABLE lineadeventa ADD CONSTRAINT FK_LDV_Venta FOREIGN KEY (ventaID) REFERENCES Venta(id);
ALTER TABLE lineadeventa ADD CONSTRAINT FK_LDV_Producto FOREIGN KEY (codigoProducto) REFERENCES Producto(codigo);

/*********alternativa 4 segun worbench***/
ALTER TABLE `tpintegracion`.`lineadeventa` 
DROP FOREIGN KEY `FK6kuty0i83fj4my3rguacjbg0m`;
ALTER TABLE `tpintegracion`.`lineadeventa` 
DROP COLUMN `codigo_producto`,
DROP INDEX `FK6kuty0i83fj4my3rguacjbg0m` ;

