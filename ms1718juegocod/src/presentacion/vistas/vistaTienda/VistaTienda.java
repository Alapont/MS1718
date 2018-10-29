package presentacion.vistas.vistaTienda;

import presentacion.controlador.Contexto;

public abstract class VistaTienda {
	private static VistaTienda instance;
	
	public static synchronized VistaTienda getInstance() {
		if (instance == null)
			instance = new VistaTiendaImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}