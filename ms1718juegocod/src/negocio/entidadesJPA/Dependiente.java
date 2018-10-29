package negocio.entidadesJPA;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
	@NamedQuery(name = "negocio.entidadesJPA.Dependiente.findByid", query = "select obj from Dependiente obj where obj.id = :id"),
	@NamedQuery(name = "negocio.entidadesJPA.Dependiente.findByhorasTrabajadas", query = "select obj from Dependiente obj where obj.horasTrabajadas = :horasTrabajadas"),
	@NamedQuery(name = "negocio.entidadesJPA.Dependiente.findByproductividad", query = "select obj from Dependiente obj where obj.productividad = :productividad")
})
public class Dependiente extends Empleado implements Serializable {
	private static final long serialVersionUID = 0;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int horasTrabajadas;
	private int productividad;
	
	public Dependiente() {}
	
	public Dependiente(String nombre, String dni, int telefono, double sueldo, Seccion seccion, boolean activo, int productividad, int horasTrabajadas) {
		super(nombre, dni, telefono, sueldo, seccion, activo);
		this.productividad = productividad;
		this.horasTrabajadas = horasTrabajadas;
	}
	
	public Dependiente(int id, String nombre, String dni, int telefono, double sueldo, Seccion seccion, boolean activo, int productividad, int horasTrabajadas) {
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

	public double calcularSueldo() {
		return sueldo + (horasTrabajadas * productividad);
	}
}