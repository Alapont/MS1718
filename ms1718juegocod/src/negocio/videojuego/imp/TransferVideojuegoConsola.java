package negocio.videojuego.imp;

/**
 * Clase de la capa Negocio que implementa Transfer de Videojuego de consola  
 */
public class TransferVideojuegoConsola extends TransferVideojuego{
	
	protected String MarcaConsola;
	
	/**
	 * Constructor con todos los parametros 
	 * @param id: identificador del videojuego
	 * @param nombre: nombre del videojuego
	 * @param desarrollador. desarrollador del videojuego
	 * @param precio: precio del videojuego
	 * @param marca: tipo de consola(Sony, Microsoft, ...)
	 * @param activo: repreesenta si el videojuego esta activo
	 */
	public TransferVideojuegoConsola(int id, String nombre, String desarrollador, double precio, String marca, boolean activo) {
		super(id, nombre, desarrollador, precio, activo);
		this.MarcaConsola = marca;
	}
	
	/**
	 * Constructor sin id 
	 * @param id: identificador del videojuego
	 * @param nombre: nombre del videojuego
	 * @param desarrollador. desarrollador del videojuego
	 * @param precio: precio del videojuego
	 * @param marca: tipo de consola(Sony, Microsoft, ...)
	 * @param activo: repreesenta si el videojuego esta activo
	 */
	public TransferVideojuegoConsola(String nombre, String desarrollador, double precio, String marca, boolean activo) {
		super(nombre, desarrollador, precio, activo);
		this.MarcaConsola = marca;
	}
	
	/**
	 * Getters y Setters
	 */
	public String getMarcaConsola() {
		return MarcaConsola;
	}

	public void setMarcaConsola(String marcaConsola) {
		MarcaConsola = marcaConsola;
	}
	
	public String toString (){
		return "Id: " + id + " Nombre: " + nombre + " Desarrollador: " + desarrollador + " Precio: " + precio + " MarcaConsola: " + MarcaConsola +  " Activo: " + activo;
	}
}
