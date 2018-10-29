package negocio.factoriaSA;

import negocio.cliente.ServicioAplicacionCliente;
import negocio.compra.ServicioAplicacionCompra;
import negocio.empleado.ServicioAplicacionEmpleado;
import negocio.seccion.ServicioAplicacionSeccion;
import negocio.tienda.ServicioAplicacionTienda;
import negocio.videojuego.ServicioAplicacionVideojuego;

/**
 * Clase abstracta de la capa negocio que define una factoria de SA, que permite crear los
 * SA de videojuego, compra y cliente
 */
public abstract class FactoriaServicioAplicacion {
	private static FactoriaServicioAplicacion factoriaSA;

	public static FactoriaServicioAplicacion getInstance(){
		if (factoriaSA == null)
			factoriaSA = new FactoriaServicioAplicacionImp();
		return factoriaSA;
	}

	public abstract ServicioAplicacionVideojuego createSAVideojuego();
	public abstract ServicioAplicacionCliente createSACliente();
	public abstract ServicioAplicacionCompra createSACompra();
	public abstract ServicioAplicacionEmpleado createSAEmpleado();
	public abstract ServicioAplicacionSeccion createSASeccion();
	public abstract ServicioAplicacionTienda createSATienda();
}
