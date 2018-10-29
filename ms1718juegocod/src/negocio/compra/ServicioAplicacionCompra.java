package negocio.compra;

import java.util.ArrayList;

import negocio.compra.imp.TransferCompra;
import negocio.compra.imp.TransferLineaDeCompra;
import presentacion.controlador.Contexto;

/**
 * Interfaz de la capa Negocio que define el SA de Compra
 */
public interface ServicioAplicacionCompra {
	public TransferCompra iniciarCompra(int id);
	public Contexto agregarArticulo(Contexto articulo);
	public TransferCompra finalizarCompra(TransferCompra tCompra);
	public int devolverArticulo(TransferLineaDeCompra tLineaCompra);
	public TransferCompra detalleCompra(int id);
	public ArrayList<TransferCompra> listaCompra();
}
