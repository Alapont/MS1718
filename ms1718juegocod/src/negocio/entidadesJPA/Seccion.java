package negocio.entidadesJPA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
@NamedQueries({
	@NamedQuery(name = "negocio.entidadesJPA.Seccion.findByid", query = "select obj from Seccion obj where obj.id = :id"),
	@NamedQuery(name = "negocio.entidadesJPA.Seccion.findByempleado", query = "select obj from Seccion obj where obj.empleado = :empleado"),
	@NamedQuery(name = "negocio.entidadesJPA.Seccion.findBynombre", query = "select obj from Seccion obj where obj.nombre = :nombre"),
	@NamedQuery(name = "negocio.entidadesJPA.Seccion.findBydescripcion", query = "select obj from Seccion obj where obj.descripcion = :descripcion"),
	@NamedQuery(name = "negocio.entidadesJPA.Seccion.findByactivo", query = "select obj from Seccion obj where obj.activo = :activo"),
	@NamedQuery(name = "negocio.entidadesJPA.Seccion.findBypresupuesto", query = "select obj from Seccion obj where obj.presupuesto = :presupuesto"),
	@NamedQuery(name = "negocio.entidadesJPA.Seccion.findByintversion", query = "select obj from Seccion obj where obj.version = :version")
})
public class Seccion implements Serializable {
	private static final long serialVersionUID = 0;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
	@OneToMany(mappedBy = "seccion")
	private List<Empleado> empleado;
	private String nombre;
	private String descripcion;
	private boolean activo;
	@OneToMany(mappedBy = "seccion") 
	private List<Presupuesto> presupuesto;
	@Version private int version;
	
	public Seccion() {}
	
	public Seccion (int id, String nombre, String descripcion, boolean activo)	{
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	public Seccion (String nombre, String descripcion, boolean activo)	{
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
}