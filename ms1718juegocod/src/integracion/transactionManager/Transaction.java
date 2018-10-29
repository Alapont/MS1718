package integracion.transactionManager;

public abstract class Transaction 
{
	public abstract void start();
	public abstract void commit();
	public abstract void rollback();
	public abstract Object getResource();
}