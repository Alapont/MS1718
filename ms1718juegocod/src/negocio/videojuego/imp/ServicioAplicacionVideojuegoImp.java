package negocio.videojuego.imp;

import integracion.factoriaDao.FactoriaDAO;
import integracion.query.factory.FactoriaQuery;
import integracion.transactionManager.TransactionManager;

import java.util.ArrayList;

import presentacion.ListaComandos;
import presentacion.controlador.PareadoQuery;
import negocio.cliente.imp.TransferCliente;
import negocio.videojuego.ServicioAplicacionVideojuego;

/**
 * Clase de la capa Negocio que implementa el SA de videojuego
 */
public class ServicioAplicacionVideojuegoImp implements ServicioAplicacionVideojuego{
	
	/**
	 * Metodo que se encarga de dar de alta un videojuego
	 */
	@Override
	public int altaVideojuego(TransferVideojuego t) {
		int id;
		
		//Creamos una nueva transacción y la iniciamos.
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		TransferVideojuego tVideojuego = FactoriaDAO.getInstance().createDAOVideojuego().search(t);
		
		//Si no existe el videojuego
		if(tVideojuego == null){
			id = FactoriaDAO.getInstance().createDAOVideojuego().add(t);
			if(id == 0){
				TransactionManager.getInstance().getTransaccion().rollback();
			}
			else{
				TransactionManager.getInstance().getTransaccion().commit();
			}
		}
		else{
			if(tVideojuego.getActivo() == false){
				tVideojuego.setActivo(true);
				
				id = FactoriaDAO.getInstance().createDAOVideojuego().update(tVideojuego);
				if(id == 0){
					TransactionManager.getInstance().getTransaccion().rollback();
				}
				else{
					TransactionManager.getInstance().getTransaccion().commit();
				}
			}
			else{
				id = -1; //Videojuego ya existe y esta activo
			}
		}
		
		//Finalmente cerramos la transación
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 * Metodo que se encarga de dar de baja un videojuego
	 */
	@Override
	public int bajaVideojuego(int idAux) {
		int id;
		
		//Creamos una nueva transacción y la iniciamos.
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();

		TransferVideojuego tb = FactoriaDAO.getInstance().createDAOVideojuego().searchId(idAux);
		
		if (tb != null){
		    if (tb.getActivo() == true) {
			    tb.setActivo(false);
			    id = FactoriaDAO.getInstance().createDAOVideojuego().update(tb);
				if (id == 0){
					TransactionManager.getInstance().getTransaccion().rollback();
				}
				else{
					TransactionManager.getInstance().getTransaccion().commit();
				}
			}
			else{
				id = -2; //Videojuego no activo
			}
		}
		else{
			id = -1; //Videojuego no existe
		}
		
		//Cerramos la transacción
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 * Metodo que se encarga de modificar un videojuego existente
	 */
	@Override
	public int modificarVideojuego(TransferVideojuego transferPropuesto) {
		/**
		 *Método para modificar los datos de un videjuego por el ID dado en el transfer si coincide la categoría del 
		 *Transfer y de la base de datos para ajustarlo a los datos del transfer.
		 */
		int id;
		
		//Creamos e iniciamos la transacción
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		//Obtenemos el transfer del videojuego por el id
		TransferVideojuego transferActual = FactoriaDAO.getInstance().createDAOVideojuego().searchId(transferPropuesto.getId());
		
		if (transferActual != null) {
			if(transferActual.getActivo()) {
		    	if((transferPropuesto instanceof TransferVideojuegoPC && transferActual instanceof TransferVideojuegoPC) || (transferPropuesto instanceof TransferVideojuegoConsola && transferActual instanceof TransferVideojuegoConsola)) {	
		    		id = FactoriaDAO.getInstance().createDAOVideojuego().update(transferPropuesto);
					if (id == 0){
						TransactionManager.getInstance().getTransaccion().rollback();
					}
					else {
						TransactionManager.getInstance().getTransaccion().commit();
					}
		    	}
		    	else {
		    		id = -4;
		    	}
			}
			else{
				id = -2; //Videojuego no activo
			}
		}
		else{
			id = -1; //Videojuego no existe
		}
		
		//Cerramos la transacción
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 * Metodo que se encarga de mostrar un videojuego especifico
	 */
	@Override
	public TransferVideojuego detalleVideojuego(int id) {
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		TransferVideojuego tVideojuego = FactoriaDAO.getInstance().createDAOVideojuego().searchId(id);
		TransactionManager.getInstance().getTransaccion().commit();
		
		TransactionManager.getInstance().eliminaTransaccion();
		return tVideojuego;
	}
	
	/**
	 * Metodo que se encarga de listar todos los videojuego
	 */
	@Override
	public ArrayList<TransferVideojuego> listaVideojuego() {
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		ArrayList<TransferVideojuego> listaVideojuegos = FactoriaDAO.getInstance().createDAOVideojuego().list();	
		TransactionManager.getInstance().getTransaccion().commit();
		
		TransactionManager.getInstance().eliminaTransaccion();
		return listaVideojuegos;
	}
	
	/**
	 * Metodo que se encarga de ejecutar la query numero de videojuegos 
	 */
	@Override
	public int numeroVideojuegos(PareadoQuery pQuery) {
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		TransferCliente tExist = FactoriaDAO.getInstance().createDAOCliente().searchId((int)pQuery.getPrimeroObjeto());
		int id = 0;
		
		if (tExist != null) 
			id = (int) FactoriaQuery.getInstance().getQuery(ListaComandos.NEGOCIO_CANTIDAD_VIDEOJUEGOS_QUERY).execute(pQuery);
		else
			id = -1;
		
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}

}
