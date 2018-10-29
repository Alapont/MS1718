package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.tienda.imp.TransferTienda;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioModificarTiendaComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSATienda().modificarTienda((TransferTienda)datos);		
		return new Contexto(ListaComandos.MOSTRAR_MODIFICAR_TIENDA, id);
	}

}
