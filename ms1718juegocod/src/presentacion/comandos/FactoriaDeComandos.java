package presentacion.comandos;

import presentacion.comandos.Comando;
import presentacion.comandos.FactoriaDeComandos;
import presentacion.comandos.FactoriaDeComandosImp;

/**
 * Clase abstracta de la capa presentacion que define la factoria de comandos
 */
public abstract class FactoriaDeComandos {
	
	private static FactoriaDeComandos instancia;

	/**
	 * La funcion getInstance devuelve la instancia de la clase, en este caso su implementación.
	 * @return Instancia de la clase ControladorImp
	 */
	public static FactoriaDeComandos getInstance() {
		if(instancia == null)
			instancia = new FactoriaDeComandosImp();
		return instancia;
	}

	public abstract Comando getComando(int event);

}
