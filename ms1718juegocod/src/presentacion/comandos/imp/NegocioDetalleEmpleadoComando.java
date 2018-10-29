package presentacion.comandos.imp;

import negocio.empleado.imp.TransferEmpleado;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioDetalleEmpleadoComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		TransferEmpleado t = FactoriaServicioAplicacion.getInstance().createSAEmpleado().detalleEmpleado((int) datos);		
		return new Contexto(ListaComandos.MOSTRAR_DETALLE_EMPLEADO, t);
	}
}
