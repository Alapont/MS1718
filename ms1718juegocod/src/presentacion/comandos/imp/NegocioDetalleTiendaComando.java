package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.tienda.imp.TransferTienda;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioDetalleTiendaComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		TransferTienda t = FactoriaServicioAplicacion.getInstance().createSATienda().detalleTienda((int) datos);
		return new Contexto(ListaComandos.MOSTRAR_DETALLE_TIENDA, t);
	}
}
