package presentacion.comandos.imp;

import java.util.ArrayList;

import negocio.cliente.imp.TransferCliente;
import negocio.factoriaSA.FactoriaServicioAplicacion;

import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioListaClienteComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferCliente> lista = FactoriaServicioAplicacion.getInstance().createSACliente().listaCliente();
		return new Contexto (ListaComandos.MOSTRAR_LISTA_CLIENTE, lista);
	}

}
