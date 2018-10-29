package presentacion.comandos.imp;

import java.util.ArrayList;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.tienda.imp.TransferPresupuesto;

import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioListaPresupuestoTiendaComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferPresupuesto> lista = FactoriaServicioAplicacion.getInstance().createSATienda().listaPresupuesto();		
		return new Contexto(ListaComandos.MOSTRAR_LISTA_PRESUPUESTO_TIENDA, lista);
	}

}
