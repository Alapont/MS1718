package integracion.transactionManager;

public abstract class TransactionManager 
{
	private static TransactionManager instancia;

	public static TransactionManager getInstance() 
	{
		if (instancia == null)
			instancia = new TransactionManagerImp();
		return instancia;
	}

	public abstract boolean nuevaTransaccion();
	public abstract Transaction getTransaccion();
	public abstract boolean eliminaTransaccion();
}