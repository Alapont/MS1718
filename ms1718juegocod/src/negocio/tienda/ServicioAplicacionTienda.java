package negocio.tienda;

import negocio.tienda.imp.TransferPresupuesto;
import negocio.tienda.imp.TransferTienda;
import java.util.ArrayList;

public interface ServicioAplicacionTienda {
	public int altaTienda(TransferTienda t);
	public int bajaTienda(int id);
	public int modificarTienda(TransferTienda t);
	public TransferTienda detalleTienda(int id);
	public ArrayList<TransferTienda> listaTienda();
	public int asignarSeccion(TransferPresupuesto t);
	public int desasignarSeccion(TransferPresupuesto t);
	public int asignarPresupuesto(TransferPresupuesto t);
	public TransferPresupuesto detallePresupuesto(TransferPresupuesto t);
	public ArrayList<TransferPresupuesto> listaPresupuesto();
}