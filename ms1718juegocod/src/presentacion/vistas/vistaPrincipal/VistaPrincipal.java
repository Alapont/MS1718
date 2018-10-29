package presentacion.vistas.vistaPrincipal;

import presentacion.controlador.Contexto;

/**
 * Clase abstracta de la capa presentacion que define los metodos de la vista principal
 */
public abstract class VistaPrincipal{
	private static VistaPrincipal instance;
	
	/**
	 * Devuelve la instancia, en este caso su implementacion
	 */
	public static VistaPrincipal getInstance(){
		if(instance == null)
			instance = new VistaPrincipalImp();
		return instance;
	}
	
	public abstract void update(Contexto contexto);
}