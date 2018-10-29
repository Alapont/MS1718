package integracion.compra;

import java.util.ArrayList;

import negocio.compra.imp.TransferCompra;
import negocio.compra.imp.TransferLineaDeCompra;

/**
 * 
 */
public interface DAOCompra {
	public int add(TransferCompra tCompra);
	public TransferCompra searchId(int id);
	public TransferLineaDeCompra searchLineaCompra(TransferLineaDeCompra tLineaCompra);
	public int devolucionArticulo(TransferCompra tCompra, TransferLineaDeCompra tLineaCompra);
	public ArrayList<TransferCompra> list();
}
