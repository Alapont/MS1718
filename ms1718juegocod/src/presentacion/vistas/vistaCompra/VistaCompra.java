package presentacion.vistas.vistaCompra;

import presentacion.controlador.Contexto;

/**
 * Clase abstracta de la capa presentacion que define los metodos de la Vista de Compra
 */
public abstract class VistaCompra {
	private static VistaCompra instance;
	
	/**
	 * Metodo que te devuelve la instancia, en este caso su implementacion
	 */
	public static VistaCompra getInstance() {
		if(instance == null)
			instance = new VistaCompraImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}