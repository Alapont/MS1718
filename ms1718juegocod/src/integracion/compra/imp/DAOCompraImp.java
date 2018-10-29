package integracion.compra.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import negocio.compra.imp.TransferCompra;
import negocio.compra.imp.TransferLineaDeCompra;
import integracion.compra.DAOCompra;
import integracion.transactionManager.TransactionManager;

/**
 * implementacion del DAO compra
 */
public class DAOCompraImp implements DAOCompra{

	@Override
	public int add(TransferCompra tCompra) {
		int resource = 0;
		Connection cn = null;
		Statement statement = null;
		
		try {
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			statement = cn.createStatement();
			
			resource = statement.executeUpdate("INSERT INTO juegotron.compra (`CosteTotal`, `Fecha`, `Activo`, `ClientID`) VALUES (" + tCompra.getCosteTotal() + ", '" + tCompra.getFecha() + "', " + tCompra.getActivo() + ", "  + tCompra.getIdCliente() + ")");

		    if(resource != 0){
		    	ResultSet rsUltima = statement.executeQuery("SELECT LAST_INSERT_ID()");
		    	rsUltima.next();
		    	resource = rsUltima.getInt(1);
		    	
				Iterator<Entry<Integer, Integer>> it = tCompra.getLineaCompra().entrySet().iterator();

				while (it.hasNext()) {
					Map.Entry<Integer, Integer> t = (Map.Entry<Integer, Integer>) it.next();
					
                                        
                                        ResultSet rsPrecio = statement.executeQuery("SELECT precio FROM videojuegos WHERE id = '" + t.getKey() + "' FOR UPDATE"); 
					rsPrecio.next();
                                        
                                        
					statement.executeUpdate("INSERT INTO juegotron.contiene (`Compra`, `Videojuego`, `Cantidad`, `precio`, `Activo`) VALUES (" + resource + ", " + t.getKey() + ", " + t.getValue() + ", " + rsPrecio.getDouble(1) + ", true)");
				}
		    }
		} 
		catch (SQLException e) {
                e.printStackTrace();}
		finally{
		    try {
				statement.close();
			} 
		    catch (SQLException e) {
                        e.printStackTrace();
                    }
		}
		
		return resource;
	}

	@Override
	public TransferCompra searchId(int id) {
		TransferCompra t = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();               
		    rs = st.executeQuery("SELECT ID,ClientID, CosteTotal, fecha,activo FROM compra WHERE id = " + id + " FOR UPDATE"); 
		    
		    if (rs.next()){
		    	t = new TransferCompra(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getBoolean(5));
		    	rs = st.executeQuery("SELECT videojuego, cantidad FROM contiene WHERE compra = " + id + " FOR UPDATE"); 
		    
		    	while(rs.next())
		    		t.setLineaCompra(rs.getInt(1), rs.getInt(2));
		    }
		}
		catch (SQLException e) {}
		finally{
		    try {
         
                            rs.close();
			    st.close();
			} 
		    catch (SQLException e) {}
		}
		
		return t;
	}

	@Override
	public TransferLineaDeCompra searchLineaCompra(
			TransferLineaDeCompra tLineaCompra) {
		TransferLineaDeCompra lineaCompra = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();   
			
			rs = st.executeQuery("SELECT cantidad, activo, precio FROM contiene WHERE compra = " + tLineaCompra.getIdCompra() + " && videojuego = " + tLineaCompra.getIdArticulo() + " FOR UPDATE"); 
			    
		    if (rs.next())
		    	lineaCompra = new TransferLineaDeCompra(tLineaCompra.getIdCompra(), tLineaCompra.getIdArticulo(), rs.getInt(1), rs.getBoolean(2), rs.getDouble(3));
		}
		catch (SQLException e) {}
		finally {
		    try {
				rs.close();
			    st.close();
			} 
		    catch (SQLException e) {}
		}
		
		return lineaCompra;
	}

	@Override
	public int devolucionArticulo(TransferCompra tCompra,
			TransferLineaDeCompra tLineaCompra){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		int rsDevolucion = 0;
		
		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement(); 
			
			rsDevolucion = st.executeUpdate("UPDATE contiene SET cantidad = '" + tLineaCompra.getCantidad() + "', Activo = " + tLineaCompra.getActivo() + " WHERE Compra = '" + tLineaCompra.getIdCompra() + "' && Videojuego = '" + tLineaCompra.getIdArticulo() + "'"); 
			
			if(rsDevolucion != 0)
			{
				rs = st.executeQuery("SELECT count(*) FROM contiene WHERE Compra = " + tLineaCompra.getIdCompra() + " && Activo = true FOR UPDATE"); 
				
				if(rs.next())
					if(rs.getInt(1) == 0)
						tCompra.setActivo(false);
				
								
				
				rsDevolucion = st.executeUpdate("UPDATE compra SET CosteTotal = " + tCompra.getCosteTotal()  + ", Activo = " + tCompra.getActivo() + " WHERE ID = '" + tCompra.getId() + "'"); 
			}
		}
		catch (SQLException e) {
                    e.printStackTrace();
                }
		finally
		{
		    try 
		    {
				st.close();
			} 
		    catch (SQLException e) {}
		}
		
		return rsDevolucion;
	}

	@Override
	public ArrayList<TransferCompra> list() {
		ArrayList<TransferCompra> tList = new ArrayList<TransferCompra>();
		TransferCompra t = null;
		Connection cn = null;
		Statement stCompra = null;
		Statement stLinea = null;
		ResultSet rsCompra = null;
		ResultSet rsLinea = null;
		
		try {
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			stCompra = cn.createStatement();     
			stLinea = cn.createStatement(); 
			rsCompra = stCompra.executeQuery("SELECT * FROM compra FOR UPDATE");
		    
		    while (rsCompra.next()){
		    	t = new TransferCompra(rsCompra.getInt(1), rsCompra.getInt(2), rsCompra.getDouble(3), rsCompra.getDate(4), rsCompra.getBoolean(5));
		    	
		    	rsLinea = stLinea.executeQuery("SELECT idArticulo, cantidad FROM lineaDeCompra WHERE idCompra = " + t.getId() + " FOR UPDATE"); 
		    	
		    	while(rsLinea.next()){
		    		t.setLineaCompra(rsLinea.getInt(1), rsLinea.getInt(2));
		    		tList.add(t);
		    	}
		    }
		}
		catch (SQLException e) {}
		finally{
		    try {
		    	rsCompra.close();
		    	if(rsLinea != null)
		    		rsLinea.close();
		    	stCompra.close();
		    	stLinea.close();
			} 
		    catch (SQLException e) {}
		}
		
		return tList;
	}

}








