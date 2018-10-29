package presentacion.vistas.vistaPrincipal;

import presentacion.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaPrincipal.principal.JFramePrincipal;

/**
 * Clase de la capa presentacion que implementa la vista principal
 */
public class VistaPrincipalImp extends VistaPrincipal{
	private JFramePrincipal principal;
	
	public VistaPrincipalImp(){
		createJFramePrincipal();
	}
	
	public void createJFramePrincipal(){
		principal = new JFramePrincipal();
	}

	@Override
	public void update(Contexto contexto){
		switch(contexto.getEvento()){
			case ListaComandos.VENTANA_PRINCIPAL:
				principal.setVisible(true);
			break;
		}
	}
}