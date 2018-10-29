package presentacion.comandos.imp;

import negocio.compra.imp.TransferCompra;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioGestionCarritoCompraComando implements Comando {

	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		TransferCompra t = FactoriaServicioAplicacion.getInstance().createSACompra().iniciarCompra((int)datos);
		return new Contexto (ListaComandos.MOSTRAR_GESTION_CARRITO_COMPRA, t);
	}
		

}
