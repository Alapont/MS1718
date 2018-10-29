package presentacion.comandos.imp;

import java.util.ArrayList;

import negocio.empleado.imp.TransferEmpleado;
import negocio.factoriaSA.FactoriaServicioAplicacion;

import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioListaEmpleadoComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferEmpleado> lista = FactoriaServicioAplicacion.getInstance().createSAEmpleado().listaEmpleado();		
		return new Contexto(ListaComandos.MOSTRAR_LISTA_EMPLEADO, lista);
	}

}
