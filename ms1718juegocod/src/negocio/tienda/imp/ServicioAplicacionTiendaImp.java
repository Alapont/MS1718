package negocio.tienda.imp;

import negocio.entidadesJPA.Seccion;
import negocio.entidadesJPA.Presupuesto;
import negocio.entidadesJPA.PresupuestoId;
import negocio.entidadesJPA.Tienda;
import negocio.tienda.ServicioAplicacionTienda;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ServicioAplicacionTiendaImp implements ServicioAplicacionTienda {
	public int altaTienda(TransferTienda t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		TypedQuery<Tienda> findByName = eM.createNamedQuery("negocio.entidadesJPA.Tienda.findBynombre", Tienda.class);
		findByName.setParameter("nombre", t.getNombre());
		findByName.setLockMode(LockModeType.OPTIMISTIC);
		
		if (findByName.getResultList().size() == 0)	{
			Tienda aux = new Tienda(t.getNombre(), t.getDireccion(), true);
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
			Tienda aux = findByName.getSingleResult();
			
			if(!aux.getActivo()) {
				aux.setActivo(true);
				try {
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

	public int bajaTienda(int id) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		Tienda aux = eM.find(Tienda.class, id, LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if (aux.getActivo()) {
				TypedQuery<Presupuesto> findBySeccionAsignado = eM.createNamedQuery("negocio.entidadesJPA.Presupuesto.findBytiendaAsignado", Presupuesto.class);
				findBySeccionAsignado.setParameter("tienda", aux);
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

	public TransferTienda detalleTienda(int id) {
		TransferTienda result = null;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		Tienda aux = eM.find(Tienda.class, id);
		eM.getTransaction().commit();
		eM.close();
		
		if (aux != null) 
			result = new TransferTienda(aux.getId(), aux.getNombre(), aux.getDescripcion(), aux.getActivo());
		return result;
	}

	public ArrayList<TransferTienda> listaTienda() {
		ArrayList<TransferTienda> lista = new ArrayList<TransferTienda> ();
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		
		List<Tienda> l = eM.createQuery("SELECT obj FROM Tienda obj", Tienda.class).getResultList();
		Tienda aux;
		
		for(int k = 0; k < l.size(); k++) {
			aux = l.get(k);
			lista.add(new TransferTienda(aux.getId(), aux.getNombre(), aux.getDescripcion(), aux.getActivo()));
		}

		eM.getTransaction().commit();
		eM.close();
		return lista;
	}
	
	public int modificarTienda(TransferTienda t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		Tienda aux = eM.find(Tienda.class, t.getId(), LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if (aux.getActivo()) {
				TypedQuery<Tienda> findByName = eM.createNamedQuery("negocio.entidadesJPA.Tienda.findBynombre", Tienda.class);
				findByName.setParameter("nombre", t.getNombre());
				findByName.setLockMode(LockModeType.OPTIMISTIC);
				
				if (findByName.getResultList().size() == 0 || (aux.getId() == findByName.getSingleResult().getId())) {
					aux.setNombre(t.getNombre());
					aux.setDescripcion(t.getDireccion());
					try	{
						eM.getTransaction().commit();
						result = t.getId();
					}
					catch(Exception e)	{
						eM.getTransaction().rollback();
						result = -10;
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

	public int asignarSeccion(TransferPresupuesto t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		
		Seccion auxSeccion = eM.find(Seccion.class, t.getSeccion(), LockModeType.OPTIMISTIC);
		
		if(auxSeccion != null && auxSeccion.getActivo()) {
			Tienda auxTienda = eM.find(Tienda.class, t.getTienda(), LockModeType.OPTIMISTIC);
			if(auxTienda != null && auxTienda.getActivo()) {
				PresupuestoId auxid = new PresupuestoId(t.getSeccion(), t.getTienda());
				Presupuesto auxPresupuesto = eM.find(Presupuesto.class, auxid, LockModeType.OPTIMISTIC);
				
				if(auxPresupuesto == null) {
					Presupuesto aux = new Presupuesto(auxSeccion, auxTienda, 0, true);
					eM.persist(aux);
					try {
						eM.getTransaction().commit();
						result = t.getTienda();
					}
					catch(Exception e) {
						eM.getTransaction().rollback();
						result = -10;
					}
				}
				else {
					if(!auxPresupuesto.getActivo())	{
						auxPresupuesto.setCantidad(0);
						auxPresupuesto.setActivo(true);
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

	public int desasignarSeccion(TransferPresupuesto t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		
		Seccion auxSeccion = eM.find(Seccion.class, t.getSeccion(), LockModeType.OPTIMISTIC);
		
		if(auxSeccion != null && auxSeccion.getActivo()) {
			Tienda auxTienda = eM.find(Tienda.class, t.getTienda());
			if(auxTienda != null && auxTienda.getActivo()) {
				PresupuestoId auxid = new PresupuestoId(t.getSeccion(), t.getTienda());
				Presupuesto auxPresupuesto = eM.find(Presupuesto.class, auxid, LockModeType.OPTIMISTIC);
				
				if(auxPresupuesto != null) {
					if(auxPresupuesto.getActivo()) {
						auxPresupuesto.setCantidad(0);
						auxPresupuesto.setActivo(false);
						try {
							eM.getTransaction().commit();
							result = -5;
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
	
	public int asignarPresupuesto(TransferPresupuesto t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		
		Seccion auxSeccion = eM.find(Seccion.class, t.getSeccion(), LockModeType.OPTIMISTIC);
		
		if(auxSeccion != null) {
			Tienda auxTienda = eM.find(Tienda.class, t.getTienda());
			if(auxTienda != null) {
				PresupuestoId auxid = new PresupuestoId(t.getSeccion(), t.getTienda());
				Presupuesto auxPresupuesto = eM.find(Presupuesto.class, auxid, LockModeType.OPTIMISTIC);
				
				if(auxPresupuesto != null) {
					if(auxPresupuesto.getActivo()) {
						auxPresupuesto.setCantidad(t.getCantidad());
						try	{
							eM.getTransaction().commit();
							result = -5;
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

	@Override
	public TransferPresupuesto detallePresupuesto(TransferPresupuesto t) {
		TransferPresupuesto result = null;
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		
		Seccion auxSeccion = eM.find(Seccion.class, t.getSeccion());
		
		if(auxSeccion != null)	{
			Tienda auxTienda = eM.find(Tienda.class, t.getTienda());
			if(auxTienda != null) {
				PresupuestoId auxid = new PresupuestoId(t.getSeccion(), t.getTienda());
				Presupuesto auxPresupuesto = eM.find(Presupuesto.class, auxid, LockModeType.OPTIMISTIC);
				
				if (auxPresupuesto != null) 
					result = new TransferPresupuesto(t.getSeccion(), t.getTienda(), auxPresupuesto.getCantidad(), auxPresupuesto.getActivo());
			}
		}
		
		eM.getTransaction().commit();
		eM.close();
		return result;
	}

	@Override
	public ArrayList<TransferPresupuesto> listaPresupuesto() {
		ArrayList<TransferPresupuesto> lista = new ArrayList<TransferPresupuesto> ();
		EntityManager eM = Persistence.createEntityManagerFactory("JuegoStoreCod").createEntityManager();
		eM.getTransaction().begin();
		
		List<Presupuesto> l = eM.createQuery("SELECT obj FROM Presupuesto obj", Presupuesto.class).getResultList();
		Presupuesto aux;
		
		for(int k = 0; k < l.size(); k++) {
			aux = l.get(k);
			lista.add(new TransferPresupuesto(aux.getSeccion().getId(), aux.getTienda().getId(), aux.getCantidad(), aux.getActivo()));
		}

		eM.getTransaction().commit();
		eM.close();
		return lista;
	}
}