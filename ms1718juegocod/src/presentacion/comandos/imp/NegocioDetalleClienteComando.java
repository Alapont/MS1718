package presentacion.comandos.imp;

import negocio.cliente.imp.TransferCliente;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioDetalleClienteComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		TransferCliente id = FactoriaServicioAplicacion.getInstance().createSACliente().detalleCliente((int) datos);
		return new Contexto (ListaComandos.MOSTRAR_DETALLE_CLIENTE, id);
	}

}
