package integracion.factoriaDao;

import integracion.cliente.DAOCliente;
import integracion.compra.DAOCompra;
import integracion.factoriaDao.imp.FactoriaDAOImp;
import integracion.videojuego.DAOVideojuego;

public abstract class FactoriaDAO {
	
	private static FactoriaDAO factoriaDao;
	
	public static FactoriaDAO getInstance() {
		if (factoriaDao == null){
			factoriaDao = new FactoriaDAOImp();
		}
		return factoriaDao;
	}
	
	public abstract DAOVideojuego createDAOVideojuego();
	public abstract DAOCliente createDAOCliente();
	public abstract DAOCompra createDAOCompra();

}
