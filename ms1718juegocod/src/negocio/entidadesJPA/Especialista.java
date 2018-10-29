package negocio.entidadesJPA;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
	@NamedQuery(name = "negocio.entidadesJPA.Especialista.findByid", query = "select obj from Especialista obj where obj.id = :id"),
	@NamedQuery(name = "negocio.entidadesJPA.Especialista.findByfuncion", query = "select obj from Especialista obj where obj.funcion = :funcion"),
	@NamedQuery(name = "negocio.entidadesJPA.Especialista.findBysueldoBase", query = "select obj from Especialista obj where obj.sueldoBase = :sueldoBase")
})
public class Especialista extends Empleado implements Serializable {
	private static final long serialVersionUID = 0;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String funcion;
	private double sueldoBase;
	
	public Especialista() {}
	
	public Especialista(String nombre, String dni, int telefono, double sueldo, Seccion seccion, boolean activo, String funcion, double sueldoBase) {
		super(nombre, dni, telefono, sueldo, seccion, activo);
		this.funcion = funcion;
		this.sueldoBase = sueldoBase;
	}	
	
	public Especialista(int id, String nombre, String dni, int telefono, double sueldo, Seccion seccion, boolean activo, String funcion, double sueldoBase) {
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

	public double calcularSueldo() {
		return (sueldoBase * 5) + sueldo;
	}
}