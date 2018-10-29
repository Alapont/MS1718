package integracion.videojuego;

import java.util.ArrayList;
import negocio.videojuego.imp.TransferVideojuego;

public interface DAOVideojuego {
	public int add(TransferVideojuego tv);
	public int update(TransferVideojuego tv);
	public TransferVideojuego search(TransferVideojuego tv);
	public TransferVideojuego searchId(int id);
	public ArrayList<TransferVideojuego> list();
}
