package negocio.tienda.imp;

public class TransferTienda {
	private int id;
	private String nombre;
	private String direccion;
	private boolean activo;

	public TransferTienda(String nombre, String direccion, boolean activo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.activo = activo;
	}
	
	public TransferTienda(int id, String nombre, String direccion, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.activo = activo;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String toString() {
		return "Id: " + id + " Nombre: " + nombre + " Direccion: " + direccion + " Activo: " + activo;
	}
}