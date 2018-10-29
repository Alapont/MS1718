package negocio.cliente;

import java.util.ArrayList;

import presentacion.controlador.PareadoQuery;
import negocio.cliente.imp.TransferCliente;

/**
 * Interfaz de la capa Negociio que define el Servicio de Aplicación de Cliente
 */
public interface ServicioAplicacionCliente {
	public int altaCliente(TransferCliente t);
	public int bajaCliente(int idEntrada);
	public int modificarCliente(TransferCliente t);
	public TransferCliente detalleCliente(int id);
	public ArrayList<TransferCliente> listaCliente();
	public ArrayList<TransferCliente> numeroClientes(PareadoQuery pQuery);
}
