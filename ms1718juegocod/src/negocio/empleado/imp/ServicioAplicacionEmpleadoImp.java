package negocio.empleado.imp;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import negocio.empleado.ServicioAplicacionEmpleado;
import negocio.entidadesJPA.Seccion;
import negocio.entidadesJPA.Dependiente;
import negocio.entidadesJPA.Especialista;
import negocio.entidadesJPA.Empleado;

public class ServicioAplicacionEmpleadoImp implements ServicioAplicacionEmpleado {
	@Override
	public int altaEmpleado(TransferEmpleado t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		
		Seccion auxSeccion = eM.find(Seccion.class, t.getSeccion(), LockModeType.OPTIMISTIC);
		
		if(auxSeccion != null)	{
			if(auxSeccion.getActivo())	{
				TypedQuery<Empleado> findByDni = eM.createNamedQuery("negocio.entidadesJPA.Empleado.findBydni", Empleado.class);
				findByDni.setParameter("dni", t.getDni());
				findByDni.setLockMode(LockModeType.OPTIMISTIC);
				
				if (findByDni.getResultList().size() == 0) {
					Empleado aux = null;
					if (t instanceof TransferDependiente)
						aux = new Dependiente(t.getNombre(), t.getDni(), t.getTelefono(), t.getSueldo(), auxSeccion, true, ((TransferDependiente) t).getProductividad(), ((TransferDependiente) t).getHorasTrabajadas());
					else
						aux = new Especialista(t.getNombre(), t.getDni(), t.getTelefono(), t.getSueldo(), auxSeccion, true, ((TransferEspecialista) t).getFuncion(), ((TransferEspecialista) t).getSueldoBase());
					
					eM.persist(aux);
					try {
						eM.getTransaction().commit();
						result = aux.getId();
					}
					catch(Exception e) {
						eM.getTransaction().rollback();
						result = -10;
					}
				}
				else {
					Empleado aux = findByDni.getSingleResult();
					
					if(!aux.getActivo()) {
						aux.setActivo(true);
						try {
							eM.getTransaction().commit();
							result = -4;
						}
						catch(Exception e) {
							eM.getTransaction().rollback();
							result = -10;
						}
					}
					else
						result = -3;
				}
			}
			else
				result = -2;
		}
		else
			result = -1;
		
		eM.close();
		return result;
	}

	@Override
	public int bajaEmpleado(int id) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		Empleado aux = eM.find(Empleado.class, id, LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if (aux.getActivo()) {
				aux.setActivo(false);
				try	{
					eM.getTransaction().commit();
					result = id;
				}
				catch(Exception e) {
					eM.getTransaction().rollback();
					result = -10;
				}
			}
			else 
				result = -2;
		}
		else 
			result = -1;
		
		eM.close();
		return result;
	}

	@Override
	public TransferEmpleado detalleEmpleado(int id) {
		TransferEmpleado result = null;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		Empleado aux = eM.find(Empleado.class, id);
		eM.getTransaction().commit();
		eM.close();
		
		if (aux != null) {
			if (aux instanceof Dependiente)
				result = new TransferDependiente(aux.getId(), aux.getNombre(), aux.getDni(), aux.getTelefono(), aux.getSueldo(), aux.getSeccion().getId(), aux.getActivo(), ((Dependiente) aux).getProductividad(), ((Dependiente) aux).getHorasTrabajadas());
			else
				result = new TransferEspecialista(aux.getId(), aux.getNombre(), aux.getDni(), aux.getTelefono(), aux.getSueldo(), aux.getSeccion().getId(), aux.getActivo(), ((Especialista) aux).getFuncion(), ((Especialista) aux).getSueldoBase());
		}
		return result;
	}

	@Override
	public ArrayList<TransferEmpleado> listaEmpleado() {
		ArrayList<TransferEmpleado> lista = new ArrayList<TransferEmpleado> ();
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		
		List<Empleado> l = eM.createQuery("SELECT obj FROM Empleado obj", Empleado.class).getResultList();
		Empleado aux;
		
		for(int k = 0; k < l.size(); k++) {
			aux = l.get(k);
			
			if (aux instanceof Dependiente)
				lista.add(new TransferDependiente(aux.getId(), aux.getNombre(), aux.getDni(), aux.getTelefono(), aux.getSueldo(), aux.getSeccion().getId(), aux.getActivo(), ((Dependiente) aux).getProductividad(), ((Dependiente) aux).getHorasTrabajadas()));
			else
				lista.add(new TransferEspecialista(aux.getId(), aux.getNombre(), aux.getDni(), aux.getTelefono(), aux.getSueldo(), aux.getSeccion().getId(), aux.getActivo(), ((Especialista) aux).getFuncion(), ((Especialista) aux).getSueldoBase()));			
		}

		eM.getTransaction().commit();
		eM.close();
		return lista;
	}
	
	@Override
	public int modificarEmpleado(TransferEmpleado t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		Empleado aux = eM.find(Empleado.class, t.getId(), LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if (aux.getActivo()) {
				Seccion auxSeccion = eM.find(Seccion.class, t.getSeccion(), LockModeType.OPTIMISTIC);
				
				if(auxSeccion != null)	{
					if(auxSeccion.getActivo())	{
						TypedQuery<Empleado> findByDni = eM.createNamedQuery("negocio.entidadesJPA.Empleado.findBydni", Empleado.class);
						findByDni.setParameter("dni", t.getDni());
						findByDni.setLockMode(LockModeType.OPTIMISTIC);
						
						if (findByDni.getResultList().size() == 0 || (aux.getId() == findByDni.getSingleResult().getId())) {
							if((t instanceof TransferDependiente && aux instanceof Dependiente) || (t instanceof TransferEspecialista && aux instanceof Especialista)) {
								aux.setNombre(t.getNombre());
								aux.setDni(t.getDni());
								aux.setTelefono(t.getTelefono());
								aux.setSueldo(t.getSueldo());
								aux.setSeccion(auxSeccion);
			
								if (aux instanceof Dependiente) {
									((Dependiente) aux).setProductividad(((TransferDependiente) t).getProductividad());
									((Dependiente) aux).setHorasTrabajadas(((TransferDependiente) t).getHorasTrabajadas());
								}
								else {
									((Especialista) aux).setFuncion(((TransferEspecialista) t).getFuncion());
									((Especialista) aux).setSueldoBase(((TransferEspecialista) t).getSueldoBase());
								}
								
								try {
									eM.getTransaction().commit();
									result = t.getId();
								}
								catch(Exception e) {
									eM.getTransaction().rollback();
									result = -10;
								}
							}
							else
								result = -6;
						}
						else
							result = -5;
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
}