package negocio.empleado.imp;

public class TransferEspecialista extends TransferEmpleado {

	private String funcion;
	private double sueldoBase;

	public TransferEspecialista(String nombre, String dni, int telefono, double sueldo, int seccion, boolean activo, String funcion, Double sueldoBase) {
		super(nombre, dni, telefono, sueldo, seccion, activo);
		this.funcion = funcion;
		this.sueldoBase = sueldoBase;
	}
	
	public TransferEspecialista(int id, String nombre, String dni, int telefono, double sueldo, int seccion, boolean activo, String funcion, double sueldoBase) {
		super(id, nombre, dni, telefono, sueldo, seccion, activo);
		this.funcion = funcion;
		this.sueldoBase = sueldoBase;
	}

	public String getFuncion() {
		return funcion;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}	
	
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	public String toString() {
		return "Id: " + id + " Nombre: " + nombre + " Dni: " + dni + " Telefono: " + telefono + " Sueldo: "+ sueldo + " Seccion: " + seccion + " Funcion: " + funcion + " Sueldo base: " + sueldoBase + " Activo: " + activo;
	}
}