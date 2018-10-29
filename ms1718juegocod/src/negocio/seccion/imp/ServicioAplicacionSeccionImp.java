package negocio.seccion.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import negocio.entidadesJPA.Seccion;
import negocio.entidadesJPA.Empleado;
import negocio.entidadesJPA.Presupuesto;
import negocio.seccion.ServicioAplicacionSeccion;

public class ServicioAplicacionSeccionImp implements ServicioAplicacionSeccion {	
	public int altaSeccion(TransferSeccion t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		TypedQuery<Seccion> findByName = eM.createNamedQuery("negocio.entidadesJPA.Seccion.findBynombre", Seccion.class);
		findByName.setParameter("nombre", t.getNombre());
		findByName.setLockMode(LockModeType.OPTIMISTIC);
		
		if (findByName.getResultList().size() == 0)	{
			Seccion aux = new Seccion(t.getNombre(), t.getDescripcion(), true);
			eM.persist(aux);
			try	{
				eM.getTransaction().commit();
				result = aux.getId();
			}
			catch(Exception e) {
				eM.getTransaction().rollback();
				result = -10;
			}	
		}
		else {
			Seccion aux = findByName.getSingleResult();
			
			if(!aux.getActivo()) {
				aux.setActivo(true);
				try	{
					eM.getTransaction().commit();
					result = -2;
				}
				catch(Exception e) {
					eM.getTransaction().rollback();
					result = -10;
				}
				
			}
			else
				result = -1;
		}
		
		eM.close();
		
		return result;
	}

	public int bajaSeccion(int id) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		Seccion aux = eM.find(Seccion.class, id, LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if (aux.getActivo()) {				
				TypedQuery<Empleado> findBySeccionActivo = eM.createNamedQuery("negocio.entidadesJPA.Empleado.findByseccionActivo", Empleado.class);
				findBySeccionActivo.setParameter("seccion", aux);
				findBySeccionActivo.setParameter("activo", true);
				findBySeccionActivo.setLockMode(LockModeType.OPTIMISTIC);
				
				if(findBySeccionActivo.getResultList().size() == 0) {
					TypedQuery<Presupuesto> findBySeccionAsignado = eM.createNamedQuery("negocio.entidadesJPA.Presupuesto.findByseccionAsignado", Presupuesto.class);
					findBySeccionAsignado.setParameter("seccion", aux);
					findBySeccionAsignado.setParameter("activo", true);
					findBySeccionAsignado.setLockMode(LockModeType.OPTIMISTIC);
					
					if(findBySeccionAsignado.getResultList().size() == 0) {
						aux.setActivo(false);
						try {
							eM.getTransaction().commit();
							result = id;
						}
						catch(Exception e) {
							eM.getTransaction().rollback();
							result = -10;
						}
					}
					else
						result = -4;
				}
				else
					result = -3;
			}
			else 
				result = -2;
		}
		else 
			result = -1;
		
		eM.close();
		return result;
	}

	public TransferSeccion detalleSeccion(int id) {
		TransferSeccion result = null;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		Seccion aux = eM.find(Seccion.class, id);
		eM.getTransaction().commit();
		eM.close();
		
		if (aux != null) 
			result = new TransferSeccion(aux.getId(), aux.getNombre(), aux.getDescripcion(), aux.getActivo());
		return result;
	}

	public ArrayList<TransferSeccion> listaSeccion() {
		ArrayList<TransferSeccion> lista = new ArrayList<TransferSeccion> ();
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		
		List<Seccion> l = eM.createQuery("SELECT obj FROM Seccion obj", Seccion.class).getResultList();
		Seccion aux;
		
		for(int k = 0; k < l.size(); k++) {
			aux = l.get(k);
			lista.add(new TransferSeccion(aux.getId(), aux.getNombre(), aux.getDescripcion(), aux.getActivo()));
		}

		eM.getTransaction().commit();
		eM.close();
		return lista;
	}
	
	public int modificarSeccion(TransferSeccion t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		Seccion aux = eM.find(Seccion.class, t.getId(), LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if (aux.getActivo()) {
				TypedQuery<Seccion> findByName = eM.createNamedQuery("negocio.entidadesJPA.Seccion.findBynombre", Seccion.class);
				findByName.setParameter("nombre", t.getNombre());
				findByName.setLockMode(LockModeType.OPTIMISTIC);
				
				if (findByName.getResultList().size() == 0 || (aux.getId() == findByName.getSingleResult().getId())) {
					aux.setNombre(t.getNombre());
					aux.setDescripcion(t.getDescripcion());
					try {
						eM.getTransaction().commit();
						result = t.getId();
					}
					catch(Exception e) {
						eM.getTransaction().rollback();
						result = -1;
					}
				}
				else
					result = -3;
			}
			else 
				result = -2;
		}
		else 
			result = -1;
		
		eM.close();
		return result;
	}


	public double calcularNomina(int id) {
		double result = 0;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		Seccion aux = eM.find(Seccion.class, id, LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if(aux.getActivo())	{
				TypedQuery<Empleado> findBySeccion = eM.createNamedQuery("negocio.entidadesJPA.Empleado.findByseccionActivo", Empleado.class);
				findBySeccion.setParameter("seccion", aux);
				findBySeccion.setParameter("activo", true);
				findBySeccion.setLockMode(LockModeType.OPTIMISTIC);
				
				List<Empleado> l = findBySeccion.getResultList();
				
				for(int k=0; k<l.size(); k++) {
					Empleado auxEmpleado = l.get(k);
					eM.lock(auxEmpleado, LockModeType.OPTIMISTIC);
					result += auxEmpleado.calcularSueldo();
				}
				eM.getTransaction().commit();
			}
			else
				result = -2;
		}
		else
			result = -1;
		
		eM.close();
		return result;
	}
}