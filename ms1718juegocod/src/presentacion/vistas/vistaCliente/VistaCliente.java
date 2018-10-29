package presentacion.vistas.vistaCliente;

import presentacion.controlador.Contexto;

/**
 * Clase abstracta de la capa presentacion que define los metodos de la Vista del cliente
 */
public abstract class VistaCliente{
	private static VistaCliente instance;
	
	/**
	 * Metodo que te devuelve la instacia, en este caso su implementacion
	 * @return instancia
	 */
	public static VistaCliente getInstance(){
		if(instance == null)
			instance = new VistaClienteImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}