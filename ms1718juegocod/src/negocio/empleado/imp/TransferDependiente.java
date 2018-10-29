package negocio.empleado.imp;

public class TransferDependiente extends TransferEmpleado {
	private int productividad;
	private int horasTrabajadas;
	
	public TransferDependiente(String nombre, String dni, int telefono, double sueldo, int seccion, boolean activo, int productividad, int horasTrabajadas) {
		super(nombre, dni, telefono, sueldo, seccion, activo);
		this.productividad = productividad;
		this.horasTrabajadas = horasTrabajadas;
	}
	
	public TransferDependiente(int id, String nombre, String dni, int telefono, double sueldo, int seccion, boolean activo, int productividad, int horasTrabajadas) {
		super(id, nombre, dni, telefono, sueldo, seccion, activo);
		this.productividad = productividad;
		this.horasTrabajadas = horasTrabajadas;
	}

	public int getProductividad() {
		return productividad;
	}
	
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}	

	public void setProductividad(int productividad) {
		this.productividad = productividad;
	}
	
	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	
	public String toString() {
		return "Id: " + id + " Nombre: " + nombre + " Dni: " + dni + " Telefono: " + telefono + " Sueldo: "+ sueldo + " Seccion: " + seccion + " Productividad: " + productividad + " Horas trabajadas: " + horasTrabajadas + " Activo: " + activo;
	}
}