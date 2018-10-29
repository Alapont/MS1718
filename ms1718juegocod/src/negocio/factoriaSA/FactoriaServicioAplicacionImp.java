package negocio.factoriaSA;

import negocio.cliente.ServicioAplicacionCliente;
import negocio.cliente.imp.ServicioAplicacionClienteImp;
import negocio.compra.ServicioAplicacionCompra;
import negocio.compra.imp.ServicioAplicacionCompraImp;
import negocio.empleado.ServicioAplicacionEmpleado;
import negocio.empleado.imp.ServicioAplicacionEmpleadoImp;
import negocio.seccion.ServicioAplicacionSeccion;
import negocio.seccion.imp.ServicioAplicacionSeccionImp;
import negocio.tienda.ServicioAplicacionTienda;
import negocio.tienda.imp.ServicioAplicacionTiendaImp;
import negocio.videojuego.ServicioAplicacionVideojuego;
import negocio.videojuego.imp.ServicioAplicacionVideojuegoImp;

/**
 * Clase de la capa negocio que implemente La FactoriaServicioAplicacion y que llama a las implementaciones de los
 * distintos servicios de implementacion
 */
public class FactoriaServicioAplicacionImp extends FactoriaServicioAplicacion {
	
	/**
	 * Metodo que devuelve una instancia de la implementacion del SAVideojuego
	 */
	@Override
	public ServicioAplicacionVideojuego createSAVideojuego() {
		return new ServicioAplicacionVideojuegoImp();
	}

	/**
	 * Metodo que devuelve una instancia de la implementacion del SACliente
	 */
	@Override
	public ServicioAplicacionCliente createSACliente() {
		return new ServicioAplicacionClienteImp();
	}

	/**
	 * Metodo que devuelve una instancia de la implementacion del SACompra
	 */
	@Override
	public ServicioAplicacionCompra createSACompra() {
		return new ServicioAplicacionCompraImp();
	}
	
	@Override
	public ServicioAplicacionSeccion createSASeccion() {
		return new ServicioAplicacionSeccionImp();
	}
	
	@Override
	public ServicioAplicacionEmpleado createSAEmpleado() {
		return new ServicioAplicacionEmpleadoImp();
	}

	@Override
	public ServicioAplicacionTienda createSATienda() {
		return new ServicioAplicacionTiendaImp();
	}
}
