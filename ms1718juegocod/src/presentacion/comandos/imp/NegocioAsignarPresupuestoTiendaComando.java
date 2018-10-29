package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.tienda.imp.TransferPresupuesto;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioAsignarPresupuestoTiendaComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSATienda().asignarPresupuesto((TransferPresupuesto)datos);		
		return new Contexto(ListaComandos.MOSTRAR_ASIGNAR_PRESUPUESTO_TIENDA, id);
	}

}
