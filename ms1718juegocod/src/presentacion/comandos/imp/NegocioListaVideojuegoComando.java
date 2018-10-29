package presentacion.comandos.imp;

import java.util.ArrayList;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.videojuego.imp.TransferVideojuego;

import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioListaVideojuegoComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferVideojuego> lista = FactoriaServicioAplicacion.getInstance().createSAVideojuego().listaVideojuego();
		return new Contexto(ListaComandos.MOSTRAR_LISTA_VIDEOJUEGO, lista);
	}

}
