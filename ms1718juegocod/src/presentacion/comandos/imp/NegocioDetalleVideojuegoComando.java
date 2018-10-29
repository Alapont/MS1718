package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.videojuego.imp.TransferVideojuego;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioDetalleVideojuegoComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		TransferVideojuego tv = FactoriaServicioAplicacion.getInstance().createSAVideojuego().detalleVideojuego((int)datos);
		return new Contexto(ListaComandos.MOSTRAR_DETALLE_VIDEOJUEGO, tv);
	}

}
