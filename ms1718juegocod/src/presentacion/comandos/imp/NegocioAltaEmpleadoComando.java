package presentacion.comandos.imp;

import negocio.empleado.imp.TransferEmpleado;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioAltaEmpleadoComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSAEmpleado().altaEmpleado((TransferEmpleado) datos);		
		return new Contexto(ListaComandos.MOSTRAR_ALTA_EMPLEADO, id);
	}

}
