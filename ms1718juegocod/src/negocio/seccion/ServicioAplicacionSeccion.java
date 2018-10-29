package negocio.seccion;

import java.util.ArrayList;

import negocio.seccion.imp.TransferSeccion;

public interface ServicioAplicacionSeccion {
	public int altaSeccion(TransferSeccion t);
	public int bajaSeccion(int id);
	public int modificarSeccion(TransferSeccion t);
	public TransferSeccion detalleSeccion(int id);
	public ArrayList<TransferSeccion> listaSeccion();
	public double calcularNomina(int id);
}