package negocio.entidadesJPA;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

@Entity 
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name = "negocio.entidadesJPA.Empleado.findByid", query = "select obj from Empleado obj where obj.id = :id"),
	@NamedQuery(name = "negocio.entidadesJPA.Empleado.findBynombre", query = "select obj from Empleado obj where obj.nombre = :nombre"),
	@NamedQuery(name = "negocio.entidadesJPA.Empleado.findBydni", query = "select obj from Empleado obj where obj.dni = :dni"),
	@NamedQuery(name = "negocio.entidadesJPA.Empleado.findBytelefono", query = "select obj from Empleado obj where obj.telefono = :telefono"),
	@NamedQuery(name = "negocio.entidadesJPA.Empleado.findByactivo", query = "select obj from Empleado obj where obj.activo = :activo"),
	@NamedQuery(name = "negocio.entidadesJPA.Empleado.findByseccion", query = "select obj from Empleado obj where obj.seccion = :seccion"),
	@NamedQuery(name="negocio.entidadesJPA.Empleado.findByseccionActivo", query="select obj from Empleado obj where obj.seccion = :seccion AND obj.activo = :activo"),
	@NamedQuery(name = "negocio.entidadesJPA.Empleado.findBysueldo", query = "select obj from Empleado obj where obj.sueldo = :sueldo"),
	@NamedQuery(name = "negocio.entidadesJPA.Empleado.findByversion", query = "select obj from Empleado obj where obj.version = :version")
})
public abstract class Empleado implements Serializable {
	private static final long serialVersionUID = 0;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) protected int id;
	protected String nombre;
	protected String dni;
	private int telefono;
	protected double sueldo;
	protected boolean activo;
	@ManyToOne @JoinColumn(name="seccion")	protected Seccion seccion;
	@Version protected int version;

	public Empleado() {}
	
	public Empleado (String nombre, String dni, int telefono, double sueldo, Seccion seccion, boolean activo) {
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.sueldo = sueldo;
		this.seccion = seccion;
		this.activo = activo;
	}
	
	public Empleado (int id, String nombre, String dni, int telefono, double sueldo, Seccion seccion, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.sueldo = sueldo;
		this.seccion = seccion;
		this.activo = activo;
	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public int getTelefono() {
		return telefono;
	}
	
	public double getSueldo() {
		return sueldo;
	}
	
	public Seccion getSeccion() {
		return seccion;
	}
	
	public boolean getActivo() {
		return activo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public abstract double calcularSueldo();
}