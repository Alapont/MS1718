package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.tienda.imp.TransferPresupuesto;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioDetallePresupuestoTiendaComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		TransferPresupuesto t = FactoriaServicioAplicacion.getInstance().createSATienda().detallePresupuesto((TransferPresupuesto)datos);
		return new Contexto(ListaComandos.MOSTRAR_DETALLE_PRESUPUESTO_TIENDA, t);
	}

}
