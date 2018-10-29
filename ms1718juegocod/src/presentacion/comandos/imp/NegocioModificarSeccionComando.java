package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.seccion.imp.TransferSeccion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioModificarSeccionComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSASeccion().modificarSeccion((TransferSeccion)datos);		
		return new Contexto(ListaComandos.MOSTRAR_MODIFICAR_SECCION, id);
	}

}
