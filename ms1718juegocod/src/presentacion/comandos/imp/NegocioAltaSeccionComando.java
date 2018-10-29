package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.seccion.imp.TransferSeccion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioAltaSeccionComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSASeccion().altaSeccion((TransferSeccion) datos);
		return new Contexto(ListaComandos.MOSTRAR_ALTA_SECCION, id);
	}

}
