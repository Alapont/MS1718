package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.tienda.imp.TransferPresupuesto;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioDesasignarSeccionTiendaComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSATienda().desasignarSeccion((TransferPresupuesto)datos);
		return new Contexto(ListaComandos.MOSTRAR_DESASIGNAR_SECCION_TIENDA, id);
	}

}
