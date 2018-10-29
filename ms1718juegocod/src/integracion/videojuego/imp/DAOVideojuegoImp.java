package integracion.videojuego.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import integracion.videojuego.DAOVideojuego;
import integracion.transactionManager.TransactionManager;
import negocio.videojuego.imp.TransferVideojuego;
import negocio.videojuego.imp.TransferVideojuegoConsola;
import negocio.videojuego.imp.TransferVideojuegoPC;

public class DAOVideojuegoImp implements DAOVideojuego{
	@Override
	public int add(TransferVideojuego tv) {
		/**
		 * Método de la capa integración que permite añadir un nuevo videojuego, a traves de la conexión y haciendo un insert de SQL
		 */
		Statement statement = null;
		int resource = 0;
		
		try {
			statement = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();
			String query="INSERT INTO videojuegos( desarrollador, nombre, precio, activo) VALUES ('" + tv.getDesarrollador() + "', '" + tv.getNombre() + "', " + tv.getPrecio() + ", " + tv.getActivo() + ");";
			resource = statement.executeUpdate(query);
			
		    if (tv instanceof TransferVideojuegoPC){
		    	query="INSERT INTO juegoPC(ID,Sistema)VALUES(LAST_INSERT_ID(), '" + ((TransferVideojuegoPC) tv).getSistema() + "');";
		    	resource = statement.executeUpdate(query); 
		    }
		    else if(tv instanceof TransferVideojuegoConsola){
		    	query="INSERT INTO juegoConsola(id, marca) VALUES(LAST_INSERT_ID(), '" + ((TransferVideojuegoConsola) tv).getMarcaConsola() + "');";
		    	resource = statement.executeUpdate(query); 
		    }
		    if(resource > 0) {
		    	ResultSet rsultima = statement.executeQuery("SELECT LAST_INSERT_ID()");
		    	rsultima.next();
		    	resource = rsultima.getInt(1);
		    }
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
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
	public int update(TransferVideojuego tv) {
		/**
		 * Método de la capa integración que permite actualizar un videojuego, a traves de la conexión y haciendo un update de SQL
		 */
		Statement statement = null;
		int resource = 0;
		
		try {
			statement = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement(); 
			resource = statement.executeUpdate("UPDATE videojuegos SET desarrollador = '" + tv.getDesarrollador() + "', nombre = '" + tv.getNombre() + "', precio = '" + tv.getPrecio() + "', activo = '" + (tv.getActivo() ? 1 : 0) + "'  WHERE id = '" + tv.getId() + "'"); 

		    if(resource != 0){
			    if (tv instanceof TransferVideojuegoPC)
			    	resource = statement.executeUpdate("UPDATE juegoPC SET sistema = '" + ((TransferVideojuegoPC) tv).getSistema() + "' WHERE id = '" + tv.getId()+ "';"); 
			    else if(tv instanceof TransferVideojuegoConsola)
			    	resource = statement.executeUpdate("UPDATE juegoConsola SET marca = '" + ((TransferVideojuegoConsola) tv).getMarcaConsola() + "' WHERE id = " + tv.getId()); 		    
			    
		    	resource = tv.getId();
		    }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		    try {
				statement.close();
			} 
		    catch (SQLException e) {}
		}
		
		return resource;
	}
	
	@Override
	public TransferVideojuego search(TransferVideojuego tv) {
		/**
		 * Método de la capa integración que permite buscar un videojuego, a traves de la conexión y haciendo un select de SQL
		 */
		Statement statement = null;
		ResultSet resource = null;
		TransferVideojuego enviar = null;
		
		try {
			statement = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();               
		    resource = statement.executeQuery("SELECT * FROM videojuegos WHERE nombre like '" + tv.getNombre() + "' FOR UPDATE"); 
		    
		    if (resource.next())
		    	enviar = new TransferVideojuego(resource.getInt(1), resource.getString(3), resource.getString(2), resource.getDouble(4), resource.getBoolean(5));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		    try {
				resource.close();
			    statement.close();
			} 
		    catch (SQLException e) {
		    	e.printStackTrace();
		    }
		}
		
		return enviar;
	}
	
	@Override
	public TransferVideojuego searchId(int id) {
		/**
		 * Método de la capa integración que permite buscar un videojuego por id, a traves de la conexión y haciendo un select de SQL
		 */
		Statement statement = null;
		ResultSet resource = null;
		TransferVideojuego tv = null;
		
		try {
			statement = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();               
		    resource = statement.executeQuery("SELECT * FROM videojuegos INNER JOIN juegoPC USING(id) WHERE id = " + id + " FOR UPDATE"); 
		    
		    if (resource.next())
		    	tv = new TransferVideojuegoPC(resource.getInt(1), resource.getString(3), resource.getString(2), resource.getDouble(4), resource.getString(6), resource.getBoolean(5));	
		    else {
		    	resource = statement.executeQuery("SELECT * FROM videojuegos INNER JOIN juegoConsola USING(id) WHERE id = " + id + " FOR UPDATE"); 
		    	
		    	if(resource.next())
		    		tv = new TransferVideojuegoConsola(resource.getInt(1), resource.getString(3), resource.getString(2), resource.getDouble(4), resource.getString(6), resource.getBoolean(5));	
		    }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		    try {
                            
                            resource.close();
			    statement.close();
			} 
		    catch (SQLException e) {}
		}
		
		return tv;
	}
	
	@Override
	public ArrayList<TransferVideojuego> list() {
		/**
		 * Método de la capa integración que permite listar un videojuego, a traves de la conexión y haciendo un select de SQL
		 */
		Statement statement = null;
		ResultSet resource = null;
		ArrayList<TransferVideojuego> tList = new ArrayList<TransferVideojuego>();
		
		try {
			statement = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();               
		    resource = statement.executeQuery("SELECT * FROM videojuegos INNER JOIN juegoPC USING(id) FOR UPDATE");
		    
		    while (resource.next())
		    	tList.add(new TransferVideojuegoPC(resource.getInt(1), resource.getString(2), resource.getString(3), resource.getDouble(4), resource.getString(6), resource.getBoolean(5)));
		    
		    resource = statement.executeQuery("SELECT * FROM videojuegos INNER JOIN juegoConsola USING(id) FOR UPDATE"); 
		    
		    while (resource.next())
		    	tList.add(new TransferVideojuegoConsola(resource.getInt(1), resource.getString(2), resource.getString(3), resource.getDouble(4), resource.getString(6), resource.getBoolean(5)));
		}
		catch (SQLException e) {}
		finally {
		    try {
				resource.close();
			    statement.close();
			} 
		    catch (SQLException e) {}
		}		
		return tList;
	}
}