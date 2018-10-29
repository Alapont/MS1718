package negocio.videojuego;

import java.util.ArrayList;

import negocio.videojuego.imp.TransferVideojuego;

import presentacion.controlador.PareadoQuery;

/**
 * Interfaz de la capa Negocio que define el SA de videojuego
 */
public interface ServicioAplicacionVideojuego {
	public int altaVideojuego(TransferVideojuego t);
	public int bajaVideojuego(int id);
	public int modificarVideojuego(TransferVideojuego t);
	public TransferVideojuego detalleVideojuego(int id);
	public ArrayList<TransferVideojuego> listaVideojuego();
	public int numeroVideojuegos(PareadoQuery pQuery);
}
