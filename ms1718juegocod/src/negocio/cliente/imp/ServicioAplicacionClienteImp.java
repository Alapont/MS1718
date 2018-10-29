package negocio.cliente.imp;

import java.util.ArrayList;
import presentacion.ListaComandos;
import presentacion.controlador.PareadoQuery;
import integracion.factoriaDao.FactoriaDAO;
import integracion.query.factory.FactoriaQuery;
import integracion.transactionManager.TransactionManager;
import negocio.cliente.ServicioAplicacionCliente;

/**
 * Clase de la capa Negocio que imlemennta el SA Cliente
 */
public class ServicioAplicacionClienteImp implements ServicioAplicacionCliente{
	
	/**
	 * Metodo que se encarga de dar de alta a un cliente
	 */
	public int altaCliente(TransferCliente t){
		int id;
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCliente tc = FactoriaDAO.getInstance().createDAOCliente().search(t);
		
		if (tc == null){
			id = FactoriaDAO.getInstance().createDAOCliente().add(t);
			if (id == 0)
				TransactionManager.getInstance().getTransaccion().rollback();
			else
				TransactionManager.getInstance().getTransaccion().commit();
		}
		else {
			if(!tc.getActivo()){
				tc.setActivo(true);
				id = FactoriaDAO.getInstance().createDAOCliente().update(tc);
				
				if (id == 0)
					TransactionManager.getInstance().getTransaccion().rollback();
				else {
					TransactionManager.getInstance().getTransaccion().commit();
					id = -2;
				}
			}
			else 
				id = -1;
		}
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 *Metodo que se encarga de dar de baja a un cliente 
	 */
	public int bajaCliente(int idEntrada){
		int id;
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCliente tc = FactoriaDAO.getInstance().createDAOCliente().searchId(idEntrada);
		
		if (tc != null) {
		    if (tc.getActivo()){
			    tc.setActivo(false);
			    id = FactoriaDAO.getInstance().createDAOCliente().update(tc);
				if (id == 0)
					TransactionManager.getInstance().getTransaccion().rollback();
				else
					TransactionManager.getInstance().getTransaccion().commit();
			}
			else
				id = -2;
		}
		else
			id = -1;
		
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 *Metodo que se encarga de modificar a un cliente existente
	 */
	public int modificarCliente(TransferCliente t){
		int id;
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCliente tExist = FactoriaDAO.getInstance().createDAOCliente().searchId(t.getId());
		//start
		
		if (tExist != null) {
			if(tExist.getActivo()){
				TransferCliente tExistTarjeta = FactoriaDAO.getInstance().createDAOCliente().search(t);
				
			    if (tExistTarjeta == null || tExistTarjeta.getId() == tExist.getId()) {
				    id = FactoriaDAO.getInstance().createDAOCliente().update(t);
					if (id == 0)
						TransactionManager.getInstance().getTransaccion().rollback();
					else
						TransactionManager.getInstance().getTransaccion().commit();
				}
				else
					id = -3;		
			}
			else
				id = -2;
		}
		else
			id = -1;

		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 *Metodo que se encarga de mostrar un cliente especifico
	 *id: id cliente
	 */
	public TransferCliente detalleCliente(int id){
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCliente t = FactoriaDAO.getInstance().createDAOCliente().searchId(id);
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return t;
	}

	/**
	 * Metodo que se encarga de listar todos los clientes 
	 */
	public ArrayList<TransferCliente> listaCliente(){
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		ArrayList<TransferCliente> lista = FactoriaDAO.getInstance().createDAOCliente().list();	
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return lista;
	}
	
	/**
	 * Metodo que se encarga de ejecutar la query numero de clientes
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<TransferCliente> numeroClientes(PareadoQuery pQuery){
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		ArrayList<TransferCliente> lista = (ArrayList<TransferCliente>) FactoriaQuery.getInstance().getQuery(ListaComandos.NEGOCIO_NUMERO_CLIENTES_QUERY).execute(pQuery);
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return lista;
	}
}