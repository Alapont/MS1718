package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioAgregarArticuloCompraComando implements Comando{
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		datos = FactoriaServicioAplicacion.getInstance().createSACompra().agregarArticulo((Contexto) datos);
		return new Contexto(ListaComandos.MOSTRAR_AGREGAR_ARTICULO_COMPRA, datos);
		}

}
