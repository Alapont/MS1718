package presentacion.comandos.imp;

import java.util.ArrayList;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.tienda.imp.TransferTienda;

import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioListaTiendaComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferTienda> lista = FactoriaServicioAplicacion.getInstance().createSATienda().listaTienda();		
		return new Contexto(ListaComandos.MOSTRAR_LISTA_TIENDA, lista);
	}
}
