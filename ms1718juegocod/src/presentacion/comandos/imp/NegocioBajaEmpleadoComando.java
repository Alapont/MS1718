package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioBajaEmpleadoComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSAEmpleado().bajaEmpleado((int) datos);		
		return new Contexto(ListaComandos.MOSTRAR_BAJA_EMPLEADO, id);
	}

}
