package presentacion.controlador;

import presentacion.controlador.Controlador;
import presentacion.controlador.ControladorImp;

/**
 * Clase abstracta de la capa Presentación que permite instanciar a la clase ControladorImp
 */
public abstract class Controlador {
	private static Controlador instancia;	
	
	/**
	 * La funcion getInstance devuelve la instancia de la clase, en este caso su implementación.
	 * @return Instancia de la clase ControladorImp
	 */
	public static Controlador getInstance()	{
		if(instancia == null)
			instancia = new ControladorImp();
		return instancia;
	}
	
	public abstract void accion(int event, Object datos);
}