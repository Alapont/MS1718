package negocio.compra.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import presentacion.controlador.Contexto;
import integracion.factoriaDao.FactoriaDAO;
import integracion.transactionManager.TransactionManager;
import negocio.videojuego.imp.TransferVideojuego;
import negocio.cliente.imp.TransferCliente;
import negocio.compra.ServicioAplicacionCompra;

/**
 * Clase de la capa negocio que implementa el SA Compra
 */
public class ServicioAplicacionCompraImp implements ServicioAplicacionCompra {

	/**
	 * Metodo que se encarga de iniciar la compra
	 */
	public TransferCompra iniciarCompra(int id){
		
		//Creamos una nueva transacción y la iniciamos.
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		//Montamos los Transfer
		TransferCompra tCompra = null;
		TransferCliente tCliente = FactoriaDAO.getInstance().createDAOCliente().searchId(id);
		
		//Si existe el cliente y esta activo
		if(tCliente != null && tCliente.getActivo())
			tCompra = new TransferCompra((int)tCliente.getId(), 0, true);
		
		//Finalmente cerramos la transación
		TransactionManager.getInstance().eliminaTransaccion();
		
		return tCompra;
	}
	
	/**
	 * Metodo que se encarga de agregar articulos
	 */
	public Contexto agregarArticulo(Contexto articulo){
		
		//Creamos una nueva transacción y la iniciamos.
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		//Montamos el Transfer
		TransferVideojuego tVideojuego = FactoriaDAO.getInstance().createDAOVideojuego().searchId(articulo.getEvento());
		
		//Si el juego no existe y no esta activo
		if(tVideojuego == null || !tVideojuego.getActivo()){
                    articulo = null;
                    TransactionManager.getInstance().getTransaccion().rollback();
                }
                else{
                TransactionManager.getInstance().getTransaccion().commit();
                }
		
		//Finalmente cerramos la transaccion
		TransactionManager.getInstance().eliminaTransaccion();
		
		return articulo;
                
      
	}
	
	/**
	 * Metodo que se encarga de realizar la devolucion de un articulo en una 
	 * linea de compra
	 */
	public int devolverArticulo(TransferLineaDeCompra tLineaCompra){
		int id;
		
		//Creamos la Transaccion
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		//Montamos el Transfer
		TransferLineaDeCompra lineaCompraAlmacenada = FactoriaDAO.getInstance().createDAOCompra().searchLineaCompra(tLineaCompra);
		
		//Si la Linea De Compra existe y esta activa
		if (lineaCompraAlmacenada != null && lineaCompraAlmacenada.getActivo()){
			
			//Montamos Transfer y los datos necesarios para las operaciones(la cantidad a devolver del articulo)
			TransferCompra tCompraId = FactoriaDAO.getInstance().createDAOCompra().searchId(tLineaCompra.getIdCompra());
			
                        /*miramos cuantas unidades quedan*/
                        int cantidadDevolucion = lineaCompraAlmacenada.getCantidad() - tLineaCompra.getCantidad();
			
			//Operaciones y Comprobaciones  
                        /*si no quedan todo a o*/
                        
			if(cantidadDevolucion <= 0){
				tCompraId.setCosteTotal(0);
				tLineaCompra.setCantidad(0);
				tLineaCompra.setActivo(false);
				id = -3;
			}
			else{
                            /**/
				tCompraId.setCosteTotal(tCompraId.getCosteTotal()- (tLineaCompra.getCantidad() * lineaCompraAlmacenada.getPrecio()) );
				tLineaCompra.setCantidad(cantidadDevolucion);
				id = -2;
			}
			
			int auxResultado = FactoriaDAO.getInstance().createDAOCompra().devolucionArticulo(tCompraId, tLineaCompra);
			
			if (auxResultado == 0){
				TransactionManager.getInstance().getTransaccion().rollback();
				id = 0;
			}
			else
				TransactionManager.getInstance().getTransaccion().commit();
		}
		else 
			id = -1; // 
		
		//Finalmente Cerramos la Transaccion
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 * Metodo que se encarga de realizar la compra
	 */
	@Override
	public TransferCompra finalizarCompra(TransferCompra tCompra){
		
		//Creamos la Transaccion y los datos necesarios(lista de articulos a quitar y el iterador para recorrerla)
		ArrayList<Integer> articulosQuitar = new ArrayList<Integer>();
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		Iterator<Entry<Integer, Integer>> it = tCompra.getLineaCompra().entrySet().iterator();
		
		//Bucle mientras haya articulos
		while (it.hasNext()){
			Map.Entry<Integer, Integer> t = (Map.Entry<Integer, Integer>) it.next();
			TransferVideojuego tb = FactoriaDAO.getInstance().createDAOVideojuego().searchId(t.getKey());
			
			if(tb == null || !tb.getActivo()){
				tCompra.setLog("Articulo: " + t.getKey() + " no ha podido ser agregado");
				articulosQuitar.add(t.getKey());
			}
			else {
				tCompra.setLog("Articulo: " + t.getKey() + " ha podido ser agregado");
				tCompra.setCosteTotal(tCompra.getCosteTotal() + tb.getPrecio() * t.getValue());
			}
		}
		
		//Borramos los articulos
		for(int i = 0; i < articulosQuitar.size(); ++i)
			tCompra.removeLineaCompra(articulosQuitar.get(i));
		
		//Introducimos rl resultado 
		int resultado = FactoriaDAO.getInstance().createDAOCompra().add(tCompra);
		//hacemos commit
		if(resultado == 0)
                {
                    TransactionManager.getInstance().getTransaccion().rollback();
                    tCompra = null;
                }
                else{
                    TransactionManager.getInstance().getTransaccion().commit();
                }
		//Finalmente cerramos la Transaccion
		TransactionManager.getInstance().eliminaTransaccion();
		return tCompra;
	}

	/**
	 * Metodo que muestra una compra especifica
	 */
	@Override
	public TransferCompra detalleCompra(int id) {
		
		//Creamos la Transaccion
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		//Hacemos Commit 
		TransferCompra t = FactoriaDAO.getInstance().createDAOCompra().searchId(id);
		TransactionManager.getInstance().getTransaccion().commit();
		
		//Finalmente cerramos la Transaccion
		TransactionManager.getInstance().eliminaTransaccion();
		return t;
	}

	/**
	 * Metodo que se encarga de listar las compras realizadas
	 */
	@Override
	public ArrayList<TransferCompra> listaCompra() {
		
		//Creamos la Transaccion
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		ArrayList<TransferCompra> lista = FactoriaDAO.getInstance().createDAOCompra().list();
		
		//Hacemos Commit
		TransactionManager.getInstance().getTransaccion().commit();
		
		//Finalmnete cerramos la Transaccion
		TransactionManager.getInstance().eliminaTransaccion();
		return lista;
	}
}
