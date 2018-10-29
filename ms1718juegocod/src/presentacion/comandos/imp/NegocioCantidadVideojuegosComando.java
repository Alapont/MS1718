package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;
import presentacion.controlador.PareadoQuery;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioCantidadVideojuegosComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		int ejecucion = FactoriaServicioAplicacion.getInstance().createSAVideojuego().numeroVideojuegos((PareadoQuery)datos);
		return new Contexto(ListaComandos.MOSTRAR_CANTIDAD_VIDEOJUEGOS_QUERY, ejecucion);
	}

}
