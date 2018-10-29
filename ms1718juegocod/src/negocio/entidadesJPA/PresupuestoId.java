package negocio.entidadesJPA;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class PresupuestoId implements Serializable {
	private static final long serialVersionUID = 0;
	private int seccion;
	private int tienda;
	
	public PresupuestoId() {}
	
	public PresupuestoId(int seccion, int tienda) {
		this.seccion = seccion;
		this.tienda = tienda;
	}
	
	public int getSeccion() {
		return seccion;
	}

	public int getTienda() {
		return tienda;
	}
	
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof PresupuestoId))
			return false;
		PresupuestoId pk = (PresupuestoId) obj;
		if (!(seccion == pk.seccion))
			return false;
		if (!(tienda == pk.tienda))
			return false;
		return true;
	}

	public int hashCode() {
		int hashcode = 0;
		hashcode += seccion;
		hashcode += tienda;
		return hashcode;
	}
}