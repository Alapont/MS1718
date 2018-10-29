package negocio.empleado;

import java.util.ArrayList;

import negocio.empleado.imp.TransferEmpleado;

public interface ServicioAplicacionEmpleado {
	public int altaEmpleado(TransferEmpleado t);
	public int bajaEmpleado(int id);
	public TransferEmpleado detalleEmpleado(int id);
	public ArrayList<TransferEmpleado> listaEmpleado();
	public int modificarEmpleado(TransferEmpleado t);
}