package presentacion.vistas.vistaVideojuego;

import presentacion.controlador.Contexto;

/**
 * Clase abstracta de la capa presentacion que define los metodos de la vista del videojuego
 */
public abstract class VistaVideojuego 
{
	private static VistaVideojuego instance;
	
	/**
	 * Devuelve la instancia, en este caso su implementacion
	 * @return instancia
	 */
	public static VistaVideojuego getInstance() 
	{
		if(instance == null)
			instance = new VistaVideojuegoImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}