package presentacion.vistas.vistaVideojuego;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import negocio.videojuego.imp.TransferVideojuego;
import presentacion.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaVideojuego.videojuego.JFrameAltaVideojuegoPC;
import presentacion.vistas.vistaVideojuego.videojuego.JFrameAltaVideojuegoConsola;
import presentacion.vistas.vistaVideojuego.videojuego.JFrameBajaVideojuego;
import presentacion.vistas.vistaVideojuego.videojuego.JFramePrincipalVideojuego;
import presentacion.vistas.vistaVideojuego.videojuego.JFrameCantidadVideojuegos;
import presentacion.vistas.vistaVideojuego.videojuego.JFrameDetalleVideojuego;
import presentacion.vistas.vistaVideojuego.videojuego.JFrameListaVideojuego;
import presentacion.vistas.vistaVideojuego.videojuego.JFrameModificarVideojuegoPC;
import presentacion.vistas.vistaVideojuego.videojuego.JFrameModificarVideojuegoConsola;

/**
 * Clase de la capa presentacion que implementa la vista del videojuego 
 */
public class VistaVideojuegoImp extends VistaVideojuego {
	private JFrameAltaVideojuegoPC altaVideojuegoPC;
	private JFrameAltaVideojuegoConsola altaVideojuegoConsola;
	private JFrameBajaVideojuego bajaVideojuego;
	private JFramePrincipalVideojuego principalVideojuego;
	private JFrameDetalleVideojuego detalleVideojuego;
	private JFrameListaVideojuego listaVideojuego;
	private JFrameModificarVideojuegoPC modificarVideojuegoPC;
	private JFrameModificarVideojuegoConsola modificarVideojuegoConsola;
	private JFrameCantidadVideojuegos cantidadVideojuegos;
	
	
	public VistaVideojuegoImp()	{
		createJFrameAltaVideojuegoPC();
		createJFrameAltaVideojuegoConsola();
		createJFrameBajaVideojuego();
		createJFramePrincipalVideojuego();
		createJFrameDetalleVideojuego();
		createJFrameListaVideojuego();
		createJFrameModiciarVideojuegoPC();
		createJFrameModificarVideojuegoPC();
		createJFrameCantidadVideojuegos();
	}
	
	public void createJFrameAltaVideojuegoPC(){
		if (altaVideojuegoPC == null) 
			altaVideojuegoPC = new JFrameAltaVideojuegoPC();
	}

	public void createJFrameAltaVideojuegoConsola(){
		if (altaVideojuegoConsola == null)
			altaVideojuegoConsola = new JFrameAltaVideojuegoConsola();
	}

	public void createJFrameBajaVideojuego(){
		if (bajaVideojuego == null)
			bajaVideojuego = new JFrameBajaVideojuego();
	}

	public void createJFramePrincipalVideojuego(){
		if (principalVideojuego == null)
			principalVideojuego = new JFramePrincipalVideojuego();
	}

	public void createJFrameDetalleVideojuego(){
		if (detalleVideojuego == null)
			detalleVideojuego = new JFrameDetalleVideojuego();
	}

	public void createJFrameListaVideojuego(){
		if (listaVideojuego == null)
			listaVideojuego = new JFrameListaVideojuego();
	}

	public void createJFrameModiciarVideojuegoPC(){
		if (modificarVideojuegoPC == null)
			modificarVideojuegoPC = new JFrameModificarVideojuegoPC();
	}

	public void createJFrameModificarVideojuegoPC(){
		if (modificarVideojuegoConsola == null)
			modificarVideojuegoConsola = new JFrameModificarVideojuegoConsola();
	}
	
	public void createJFrameCantidadVideojuegos(){
		if (cantidadVideojuegos == null)
			cantidadVideojuegos = new JFrameCantidadVideojuegos();
	}	

	@SuppressWarnings("unchecked")
	@Override
	public void update(Contexto contexto){
		switch (contexto.getEvento()){
			// Ventana
		
			case ListaComandos.VENTANA_ALTA_VIDEOJUEGO_PC:
				altaVideojuegoPC.setVisible(true);
				break;
			case ListaComandos.VENTANA_ALTA_VIDEOJUEGO_CONSOLA:
				altaVideojuegoConsola.setVisible(true);
				break;
			case ListaComandos.VENTANA_BAJA_VIDEOJUEGO:
				bajaVideojuego.setVisible(true);
				break;
			case ListaComandos.VENTANA_PRINCIPAL_VIDEOJUEGO:
				principalVideojuego.setVisible(true);
				break;
			case ListaComandos.VENTANA_DETALLE_VIDEOJUEGO:
				detalleVideojuego.setVisible(true);
				break;
			case ListaComandos.VENTANA_LISTA_VIDEOJUEGO:
				listaVideojuego.setVisible(true);
				break;
			case ListaComandos.VENTANA_MODIFICAR_VIDEOJUEGO_PC:
				modificarVideojuegoPC.setVisible(true);
				break;
			case ListaComandos.VENTANA_MODIFICAR_VIDEOJUEGO_CONSOLA:
				modificarVideojuegoConsola.setVisible(true);
				break;
			case ListaComandos.VENTANA_CANTIDAD_VIDEOJUEGOS_QUERY:
				cantidadVideojuegos.setVisible(true);
				break;
				
			// Mostrar
				
			case ListaComandos.MOSTRAR_ALTA_VIDEOJUEGO:
				String msgAlta = "";
				switch((int)contexto.getDatos()){				
					case -2:
						msgAlta = "Videojuego no activo, se ha vuelto a activar";
						break;
					case -1:
						msgAlta = "Videojuego no guardado, debido a que ya existe un videojuego con ese nombre";
						break;
					case 0:
						msgAlta = "Videojuego no guardado, debido a un error con la Base de Datos";
						break;
					default:
						msgAlta = "Operacion realizada con exito, videojuego dado de alta con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, msgAlta, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case ListaComandos.MOSTRAR_BAJA_VIDEOJUEGO:
				String msgBaja = "";
				switch((int)contexto.getDatos()){			
					case -2:
						msgBaja = "El videojuego ya está dado de baja";
						break;
					case -1:
						msgBaja = "El videojuego introducido no existe";
						break;
					case 0:
						msgBaja = "Videojuego no eliminado, debido a un error con la Base de Datos";
						break;
					default:
						msgBaja = "Operacion realizada con exito, videojuego dado de baja con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, msgBaja, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case ListaComandos.MOSTRAR_MODIFICAR_VIDEOJUEGO:
				String msgModificar = "";
				switch((int)contexto.getDatos()){
					case -4:
						msgModificar = "Videojuego no modificado, debido a que no es el tipo correcto";
						break;
					case -3:
						msgModificar = "Videojuego no modificado, debido a que el nombre introducido ya existe en la base de datos";
						break;
					case -2:
						msgModificar = "Videojuego no modificado porque está desactivado";
						break;
					case -1:
						msgModificar = "No existe el videojuego introducido, por lo que no se puede modificar";
						break;
					case 0:
						msgModificar = "Videojuego no modificado, debido a un error con la BD";
						break;
					default:
						msgModificar = "Operacion realizada con exito, videojuego modificado con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, msgModificar, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case ListaComandos.MOSTRAR_DETALLE_VIDEOJUEGO:
				if(contexto.getDatos() != null)
					detalleVideojuego.setAreaDetalle((TransferVideojuego) contexto.getDatos());
				else
					JOptionPane.showMessageDialog(null, "No existe el videojuego introducido", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case ListaComandos.MOSTRAR_LISTA_VIDEOJUEGO:
				if(((ArrayList<TransferVideojuego>) contexto.getDatos()).size() > 0)
					listaVideojuego.setAreaDetalle((ArrayList<TransferVideojuego>) contexto.getDatos());
				else
					JOptionPane.showMessageDialog(null, "No hay ningun videojuego", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_CANTIDAD_VIDEOJUEGOS_QUERY:
				String msgCantidadVideojuegos = "";
				switch((int)contexto.getDatos()){
					case -1:
						msgCantidadVideojuegos = "El cliente no existe";
						break;
					case 0:
						msgCantidadVideojuegos = "El cliente no ha comprado ningun videojuego de ese modelo";
						break;
						
					default:
						msgCantidadVideojuegos = "El cliente ha comprado " + contexto.getDatos() + " videojuego(s) de ese modelo";
				}
				
				JOptionPane.showMessageDialog(null, msgCantidadVideojuegos, "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}