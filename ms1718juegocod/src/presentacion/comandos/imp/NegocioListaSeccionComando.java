package presentacion.comandos.imp;

import java.util.ArrayList;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.seccion.imp.TransferSeccion;

import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioListaSeccionComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferSeccion> lista = FactoriaServicioAplicacion.getInstance().createSASeccion().listaSeccion();		
		return new Contexto(ListaComandos.MOSTRAR_LISTA_SECCION, lista);
	}

}
