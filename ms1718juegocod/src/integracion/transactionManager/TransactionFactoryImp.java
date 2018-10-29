package integracion.transactionManager;

public class TransactionFactoryImp extends TransactionFactory 
{
	@Override
	public Transaction crearTransaccion() 
	{
		return new TransactionMySQL();
	}
}