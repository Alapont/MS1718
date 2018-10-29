package presentacion.comandos.imp;

import negocio.empleado.imp.TransferEmpleado;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioModificarEmpleadoComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSAEmpleado().modificarEmpleado((TransferEmpleado)datos);		
		return new Contexto(ListaComandos.MOSTRAR_MODIFICAR_EMPLEADO, id);
	}
}
