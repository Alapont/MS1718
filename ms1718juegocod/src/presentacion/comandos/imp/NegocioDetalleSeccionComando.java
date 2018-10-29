package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.seccion.imp.TransferSeccion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioDetalleSeccionComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		TransferSeccion t = FactoriaServicioAplicacion.getInstance().createSASeccion().detalleSeccion((int) datos);		
		return new Contexto(ListaComandos.MOSTRAR_DETALLE_SECCION, t);
	}

}
