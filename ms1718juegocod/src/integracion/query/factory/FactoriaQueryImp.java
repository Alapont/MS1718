package integracion.query.factory;

import integracion.query.Query;
import integracion.query.imp.CantidadVideojuegosQuery;
import integracion.query.imp.NumeroClientesQuery;
import presentacion.ListaComandos;

public class FactoriaQueryImp extends FactoriaQuery{

	@Override
	public Query getQuery(int event) 
	{
		Query query = null;
		
		switch(event)
		{
		case ListaComandos.NEGOCIO_NUMERO_CLIENTES_QUERY:
			query = new NumeroClientesQuery();
			break;
		case ListaComandos.NEGOCIO_CANTIDAD_VIDEOJUEGOS_QUERY:
			query = new CantidadVideojuegosQuery();
			break;
		}
		
		return query;
	}
}