package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioBajaVideojuegoComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		int ejecucion = FactoriaServicioAplicacion.getInstance().createSAVideojuego().bajaVideojuego((int)datos);
		return new Contexto(ListaComandos.MOSTRAR_BAJA_VIDEOJUEGO, ejecucion);
	}

}
