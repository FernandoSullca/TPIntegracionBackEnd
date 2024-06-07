SELECT * FROM tpintegracion.venta;
ALTER TABLE lineadeventa DROP FOREIGN KEY FK_LDV_Venta;
ALTER TABLE `tpintegracion`.`venta` 
CHANGE COLUMN `id` `id` INT NOT NULL AUTO_INCREMENT ;
ALTER TABLE lineadeventa ADD CONSTRAINT FK_LDV_Venta FOREIGN KEY (ventaID) REFERENCES Venta(id);
