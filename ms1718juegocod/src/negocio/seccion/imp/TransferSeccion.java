package negocio.seccion.imp;

public class TransferSeccion {
	private int id;
	private String nombre;
	private String descripcion;
	private boolean activo;
	
	public TransferSeccion (int id, String nombre, String descripcion, boolean activo)	{
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	public TransferSeccion (String nombre, String descripcion, boolean activo)	{
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String toString() {
		return "Id: " + id + " Nombre: " + nombre + " Descripcion: " + descripcion + " Activo: " + activo;
	}
}