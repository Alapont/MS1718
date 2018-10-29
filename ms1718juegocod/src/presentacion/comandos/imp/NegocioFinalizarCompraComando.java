package presentacion.comandos.imp;

import negocio.compra.imp.TransferCompra;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioFinalizarCompraComando implements Comando {

	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		TransferCompra resultado = FactoriaServicioAplicacion.getInstance().createSACompra().finalizarCompra((TransferCompra) datos);
		return new Contexto (ListaComandos.NEGOCIO_FINALIZAR_COMPRA, resultado);
	}

}
