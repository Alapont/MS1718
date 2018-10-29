package negocio.videojuego.imp;

/**
 * Clase de la capa Negocio que implementa Transfer de Videojuego de ordenador  
 */
public class TransferVideojuegoPC extends TransferVideojuego {
	
	protected String sistema;
	
	/**
	 * Constructor sin id 
	 * @param id: identificador del videojuego
	 * @param nombre: nombre del videojuego
	 * @param desarrollador. desarrollador del videojuego
	 * @param precio: precio del videojuego
	 * @param marca: sistema del ordenador(Linux, Windows, ...)
	 * @param activo: repreesenta si el videojuego esta activo
	 */
	public TransferVideojuegoPC(String nombre, String desarrollador, double precio, String sistema, boolean activo) {
		super(nombre, desarrollador, precio, activo);
		this.sistema = sistema;
	}
	
	/**
	 * Constructor con todos los parametros 
	 * @param id: identificador del videojuego
	 * @param nombre: nombre del videojuego
	 * @param desarrollador. desarrollador del videojuego
	 * @param precio: precio del videojuego
	 * @param marca: sistema del ordenador(Linux, Windows, ...)
	 * @param activo: repreesenta si el videojuego esta activo
	 */
	public TransferVideojuegoPC(int id, String nombre, String desarrollador, double precio, String sistema, boolean activo) {
		super(id, nombre, desarrollador, precio, activo);
		this.sistema = sistema;
	}
	
	/**
	 * Getters y Setters
	 */
	public String getSistema() {
		return this.sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String toString (){
		return "Id: " + id + " Nombre: " + nombre + " Desarrollador: " + desarrollador + " Precio: " + precio + " Sistema: " + sistema +  " Activo: " + activo;
	}
}
