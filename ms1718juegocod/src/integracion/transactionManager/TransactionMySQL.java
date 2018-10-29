package integracion.transactionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionMySQL extends Transaction {
	private Connection connection;

	public TransactionMySQL() {
		try {			
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/juegoStore","root","");
		} 
		catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Connection could not be made");
		}
	}
	
	@Override
	public void start() {
		try {
			connection.setAutoCommit(false);
		} 
		catch (SQLException e) {}
	}

	@Override
	public void commit() {
		try {
			connection.commit();
			connection.close();
		} 
		catch (SQLException e) {}
	}

	@Override
	public void rollback() {
		try {
			connection.rollback();
			connection.close();
		} 
		catch (SQLException e) {}
	}

	@Override
	public Object getResource() {
		return connection;
	}
}