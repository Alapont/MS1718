package presentacion.controlador;

/**
 * Clase de la capa presentación que permite transmitir unos datos por esta capa
 */
public class Contexto {
	private int evento;
	private Object datos;

	public Contexto(int evento, Object datos) {
		this.evento = evento;
		this.datos = datos;
	}
	
	public int getEvento() {
		return evento;
	}
	
	public Object getDatos() {
		return datos;
	}
}
