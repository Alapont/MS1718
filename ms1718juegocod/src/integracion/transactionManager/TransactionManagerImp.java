package integracion.transactionManager;

import java.util.concurrent.ConcurrentHashMap;

public class TransactionManagerImp extends TransactionManager 
{
	private ConcurrentHashMap<Thread, Transaction> concurrentHashMap;
	
	public TransactionManagerImp () 
	{
		this.concurrentHashMap = new ConcurrentHashMap<Thread, Transaction>();
	}
	
	public boolean nuevaTransaccion() 
	{
		if (!concurrentHashMap.contains(Thread.currentThread())) 
		{
			this.concurrentHashMap.put(Thread.currentThread(), TransactionFactory.getInstance().crearTransaccion());
			return true;
		}
		return false;
	}
	
	public Transaction getTransaccion() 
	{
		return this.concurrentHashMap.get(Thread.currentThread());
	}
	
	public boolean eliminaTransaccion() 
	{
		if (concurrentHashMap.contains(Thread.currentThread())) 
		{
			this.concurrentHashMap.remove(Thread.currentThread());
			return true;
		}
		return false;
	}
}