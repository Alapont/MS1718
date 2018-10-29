package negocio.cliente.imp;

/**
 * Clase de la capa Negocio que implementa el Transfer de cliente
 */
public class TransferCliente {
	private int id;
	private String nombre;
	private String dni;
	private String tarjetaDePago;
	private boolean activo;	

	 /**
	  *  Constructor TransferCliente sin id
	 */
	public TransferCliente(String nombre, String dni, String tarjetaDePago, boolean activo){
		this.nombre = nombre;
		this.dni = dni;
		this.tarjetaDePago = tarjetaDePago;
		this.activo = activo;		
	}
	
	/**
	 * Constructor TransferCliente con id
	 */
	public TransferCliente(int id, String nombre, String dni, String tarjetaDePago, boolean activo){
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.tarjetaDePago = tarjetaDePago;
		this.activo = activo;
	}
	

	// getters

	public int getId() {
		return this.id;
	}
		
	public String getNombre(){
		return this.nombre;
	}
	
	public String getDNI() {
		return dni;
	}
	
	public String getTarjetaDeCredito() {
		return this.tarjetaDePago;
	}

	public boolean getActivo() {
		return this.activo;
	}	

	//setters
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDNI(String dni) {
		this.dni = dni;
	}
	
	public void setTarjetaDeCredito(String tarjeta) {
		this.tarjetaDePago = tarjeta;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	//toString del transfer
	public String toString (){
		return "Id: " + id + " Nombre: " + nombre + " DNI: " + dni + " Tarjeta de credito: " + tarjetaDePago + " Activo: " + activo;
	}
}