package main;

import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class Main {

	/**
	 * Funcion principal del proyecto JuegoStore. Inicia el programa
	 * @param args Parametros de entrada cuando se lanza la aplicacion
	 */
	public static void main(String[] args) {
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL, null);
	}
        

}
