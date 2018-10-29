package presentacion.dispatcher;

import presentacion.controlador.Contexto;

/**
 * Clase abstracta de la capa presentacion que define los metodos del dispatcher
 */
public abstract class Dispatcher {
	private static Dispatcher instancia;
	
	/**
	 *Metodo que te devuelve la instancia, en este caso su implementacion 
	 * @return instancia
	 */
	public static Dispatcher getInstance() {
		if (instancia == null)
			instancia = new DispatcherImp();
		return instancia;
	}

	public abstract void accion(Contexto contexto);
}
