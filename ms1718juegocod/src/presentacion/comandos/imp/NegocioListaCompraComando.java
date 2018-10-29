package presentacion.comandos.imp;

import java.util.ArrayList;

import negocio.compra.imp.TransferCompra;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioListaCompraComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferCompra> lista = FactoriaServicioAplicacion.getInstance().createSACompra().listaCompra();
		return new Contexto (ListaComandos.NEGOCIO_LISTA_COMPRA , lista);
	}

}
