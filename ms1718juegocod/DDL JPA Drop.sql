ALTER TABLE EMPLEADO DROP FOREIGN KEY FK_EMPLEADO_seccion
ALTER TABLE ESPECIALISTA DROP FOREIGN KEY FK_ESPECIALISTA_ID
ALTER TABLE PRESUPUESTO DROP FOREIGN KEY FK_PRESUPUESTO_TIENDA_ID
ALTER TABLE PRESUPUESTO DROP FOREIGN KEY FK_PRESUPUESTO_SECCION_ID
ALTER TABLE DEPENDIENTE DROP FOREIGN KEY FK_DEPENDIENTE_ID
DROP TABLE TIENDA
DROP TABLE EMPLEADO
DROP TABLE ESPECIALISTA
DROP TABLE SECCION
DROP TABLE PRESUPUESTO
DROP TABLE DEPENDIENTE
