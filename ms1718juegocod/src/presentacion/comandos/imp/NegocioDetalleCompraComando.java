package presentacion.comandos.imp;

import negocio.compra.imp.TransferCompra;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioDetalleCompraComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		TransferCompra id = FactoriaServicioAplicacion.getInstance().createSACompra().detalleCompra((int) datos);
		return new Contexto (ListaComandos.MOSTRAR_DETALLE_COMPRA, id);
	}

}
