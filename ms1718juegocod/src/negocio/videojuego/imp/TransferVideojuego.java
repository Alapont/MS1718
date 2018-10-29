package negocio.videojuego.imp;

/**
 * Clase de la capa Negocio que implementa el Transfer de Videojuego
 */
public class TransferVideojuego {
	protected int id;
	protected String nombre;
	protected String desarrollador;
	protected double precio;
	protected boolean activo;
	
	/**
	 * Constructor vacio
	 */
	public TransferVideojuego(){}
	
	/**
	 * Constructor sin id (se usa al crear un videojuego)
	 * @param nombre: nombre del videojuego
	 * @param desarrollador: desarrollador del videojuego
	 * @param precio: precio del videojuego
	 * @param activo: representa si el videojuego esta activo
	 */
	public TransferVideojuego(String nombre, String desarrollador, double precio, boolean activo){
		this.nombre = nombre;
		this.desarrollador = desarrollador;
		this.precio = precio;
		this.activo = activo;
	}
	
	/**
	 * Constructor con todos los parametros
	 * @param id: identificador videojuego
	 * @param nombre: nombre videojuego
	 * @param desarrollador: desarrollador del videojuego
	 * @param precio: precio del videojuego
	 * @param activo: representa si el videojuego esta activo
	 */
	public TransferVideojuego(int id, String nombre, String desarrollador, double precio, boolean activo){
		this.id = id;
		this.nombre = nombre;
		this.desarrollador = desarrollador;
		this.precio = precio;
		this.activo = activo;
	}
	
	/**
	 * Getters y Setters
	 */
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getDesarrollador() {
		return desarrollador;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public boolean getActivo() {
		return activo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	

	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}	

	public void setPrecio(double precio) {
		this.precio = precio;
	}	

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
