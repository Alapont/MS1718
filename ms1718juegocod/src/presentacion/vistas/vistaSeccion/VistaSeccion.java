package presentacion.vistas.vistaSeccion;

import presentacion.controlador.Contexto;

public abstract class VistaSeccion {
	private static VistaSeccion instance;

	public static synchronized VistaSeccion getInstance() {
		if (instance == null)
			instance = new VistaSeccionImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}