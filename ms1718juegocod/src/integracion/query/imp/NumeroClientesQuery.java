package integracion.query.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import presentacion.controlador.PareadoQuery;

import negocio.cliente.imp.TransferCliente;

//import presentacion.controlador.PareadoQuery;
import integracion.query.Query;
import integracion.transactionManager.TransactionManager;

public class NumeroClientesQuery implements Query
{
	@Override
	public Object execute(Object datos) 
	{
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<TransferCliente> tList = new ArrayList<TransferCliente>();
		
		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();               
		    rs = st.executeQuery("SELECT * FROM cliente WHERE ID IN (SELECT ClientID FROM compra WHERE CosteTotal > " + ((PareadoQuery)datos).getSegundoObjeto() + " GROUP BY ClientID HAVING COUNT(ClientID) > '" + ((PareadoQuery)datos).getPrimeroObjeto() + "') FOR UPDATE"); 

		    while (rs.next())
		    	tList.add(new TransferCliente(rs.getInt(1), rs.getString(2), rs.getString(3),  rs.getString(4), rs.getBoolean(5)));
		}
		catch (SQLException e) {}
		finally
		{
		    try 
		    {
				rs.close();
			    st.close();
			} 
		    catch (SQLException e) {}
		}
		
		return tList;		
	}
}
