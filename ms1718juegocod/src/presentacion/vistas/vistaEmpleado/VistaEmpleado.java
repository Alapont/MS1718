package presentacion.vistas.vistaEmpleado;

import presentacion.controlador.Contexto;

public abstract class VistaEmpleado {
	private static VistaEmpleado instance;
	
	public static synchronized VistaEmpleado getInstance() 	{
		if (instance == null)
			instance = new VistaEmpleadoImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}