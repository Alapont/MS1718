package presentacion.controlador;

import presentacion.comandos.Comando;
import presentacion.comandos.FactoriaDeComandos;
import presentacion.dispatcher.Dispatcher;

/**
 * Clase de la capa Presenatcion que implementa al Controlador
 */
public class ControladorImp extends Controlador {
	
	/**
	 * Metodo que se encarga de realizar la accion necesaria en funcion del evento
	 * @param event: evento
	 * @param datos: Transfer
	 */
	@Override
	public void accion(int event, Object datos){
		FactoriaDeComandos factoriaComandos = FactoriaDeComandos.getInstance();
		Comando comando = factoriaComandos.getComando(event);
		Contexto contexto = comando.execute(datos);
		Dispatcher dispatcher = Dispatcher.getInstance();
		dispatcher.accion(contexto);
	}
}