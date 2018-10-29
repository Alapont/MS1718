package presentacion.comandos.imp;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioCalcularNominaSeccionComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		double salario = FactoriaServicioAplicacion.getInstance().createSASeccion().calcularNomina((int) datos);		
		return new Contexto(ListaComandos.MOSTRAR_CALCULAR_NOMINA_SECCION, salario);
	}

}
