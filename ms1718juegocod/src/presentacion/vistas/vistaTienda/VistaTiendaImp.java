package presentacion.vistas.vistaTienda;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import negocio.tienda.imp.TransferPresupuesto;
import negocio.tienda.imp.TransferTienda;
import presentacion.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaTienda.tienda.JFrameAltaTienda;
import presentacion.vistas.vistaTienda.tienda.JFrameAsignarSeccionTienda;
import presentacion.vistas.vistaTienda.tienda.JFrameAsignarPresupuestoTienda;
import presentacion.vistas.vistaTienda.tienda.JFrameBajaTienda;
import presentacion.vistas.vistaTienda.tienda.JFrameBotoneraTienda;
import presentacion.vistas.vistaTienda.tienda.JFrameDesasignarSeccionTienda;
import presentacion.vistas.vistaTienda.tienda.JFrameDetallePresupuestoTienda;
import presentacion.vistas.vistaTienda.tienda.JFrameDetalleTienda;
import presentacion.vistas.vistaTienda.tienda.JFrameListaPresupuestoTienda;
import presentacion.vistas.vistaTienda.tienda.JFrameListaTienda;
import presentacion.vistas.vistaTienda.tienda.JFrameModificarTienda;

public class VistaTiendaImp extends VistaTienda {
	private JFrameAltaTienda altaTienda;
	private JFrameBajaTienda bajaTienda;
	private JFrameBotoneraTienda botoneraTienda;
	private JFrameDetalleTienda detalleTienda;
	private JFrameListaTienda listaTienda;
	private JFrameModificarTienda modificarTienda;
	private JFrameAsignarSeccionTienda asignarSeccionTienda;
	private JFrameDesasignarSeccionTienda desasignarSeccionTienda;
	private JFrameAsignarPresupuestoTienda asignarPresupuestoTienda;
	private JFrameDetallePresupuestoTienda detallePresupuestoTienda;
	private JFrameListaPresupuestoTienda listaPresupuestoTienda;

	public VistaTiendaImp()	{
		createJFrameAltaTienda();
		createJFrameBajaTienda();
		createJFrameBotoneraTienda();
		createJFrameDetalleTienda();
		createJFrameListaTienda();
		createJFrameModificarTienda();
		createJFrameAsignarSeccionTienda();
		createJFrameDesasignarSeccionTienda();
		createJFrameAsignarPresupuestoTienda();
		createJFrameDetallePresupuestoTienda();
		createJFrameListaPresupuestoTienda();
	}
	
	public void createJFrameAltaTienda() {
		if (altaTienda == null)
			altaTienda = new JFrameAltaTienda();
	}

	public void createJFrameBajaTienda() {
		if (bajaTienda == null)
			bajaTienda = new JFrameBajaTienda();
	}
	
	public void createJFrameBotoneraTienda() {
		if (botoneraTienda == null)
			botoneraTienda = new JFrameBotoneraTienda();
	}
	
	public void createJFrameDetalleTienda() {
		if (detalleTienda == null)
			detalleTienda = new JFrameDetalleTienda();
	}

	public void createJFrameListaTienda() {
		if (listaTienda == null)
			listaTienda = new JFrameListaTienda();
	}

	public void createJFrameModificarTienda() {
		if (modificarTienda == null)
			modificarTienda = new JFrameModificarTienda();
	}

	public void createJFrameAsignarSeccionTienda() {
		if (asignarSeccionTienda == null)
			asignarSeccionTienda = new JFrameAsignarSeccionTienda();
	}	
	
	public void createJFrameDesasignarSeccionTienda() {
		if (desasignarSeccionTienda == null)
			desasignarSeccionTienda = new JFrameDesasignarSeccionTienda();
	}	
	
	public void createJFrameAsignarPresupuestoTienda() {
		if (asignarPresupuestoTienda == null)
			asignarPresupuestoTienda = new JFrameAsignarPresupuestoTienda();
	}
	
	public void createJFrameDetallePresupuestoTienda() {
		if (detallePresupuestoTienda == null)
			detallePresupuestoTienda = new JFrameDetallePresupuestoTienda();
	}	
	
	public void createJFrameListaPresupuestoTienda() {
		if (listaPresupuestoTienda == null)
			listaPresupuestoTienda = new JFrameListaPresupuestoTienda();
	}
	
	@Override
	public void update(Contexto contexto) {
		switch(contexto.getEvento())
		{
			case ListaComandos.VENTANA_ALTA_TIENDA:
				altaTienda.setVisible(true);
				break;
			case ListaComandos.VENTANA_BAJA_TIENDA:
				bajaTienda.setVisible(true);
				break;
			case ListaComandos.VENTANA_PRINCIPAL_TIENDA:
				botoneraTienda.setVisible(true);
				break;
			case ListaComandos.VENTANA_DETALLE_TIENDA:
				detalleTienda.setVisible(true);
				break;
			case ListaComandos.VENTANA_LISTA_TIENDA:
				listaTienda.setVisible(true);
				break;
			case ListaComandos.VENTANA_MODIFICAR_TIENDA:
				modificarTienda.setVisible(true);
				break;
			case ListaComandos.VENTANA_ASIGNAR_SECCION_TIENDA:
				asignarSeccionTienda.setVisible(true);
				break;
			case ListaComandos.VENTANA_DESASIGNAR_SECCION_TIENDA:
				desasignarSeccionTienda.setVisible(true);
				break;
			case ListaComandos.VENTANA_ASIGNAR_PRESUPUESTO_TIENDA:
				asignarPresupuestoTienda.setVisible(true);
				break;
			case ListaComandos.VENTANA_DETALLE_PRESUPUESTO_TIENDA:
				detallePresupuestoTienda.setVisible(true);
				break;
			case ListaComandos.VENTANA_LISTA_PRESUPUESTO_TIENDA:
				listaPresupuestoTienda.setVisible(true);
				break;
			case ListaComandos.MOSTRAR_ALTA_TIENDA:
				String mostrarAltaTienda = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarAltaTienda = "Error transaccion";
						break;				
					case -2:
						mostrarAltaTienda = "Tienda desactivada, la hemos activado de nuevo";
						break;
					case -1:
						mostrarAltaTienda = "Existe una tienda con el mismo nombre y esta activo";
						break;
					default:
						mostrarAltaTienda = "Se ha insertado con exito la tienda con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, mostrarAltaTienda, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_BAJA_TIENDA:
				String mostrarBajaTienda = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarBajaTienda = "Error transaccion";
						break;				
					case -3:
						mostrarBajaTienda = "La tienda no puede desactivarse porque tiene activa una asignacion";
						break;
					case -2:
						mostrarBajaTienda = "La tienda esta desactivada";
						break;
					case -1:
						mostrarBajaTienda = "La tienda no existe";
						break;
					default:
						mostrarBajaTienda = "Tienda dada de baja con exito con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, mostrarBajaTienda, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_MODIFICAR_TIENDA:
				String mostrarModificarTienda = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarModificarTienda = "Error transaccion";
						break;				
					case -3:
						mostrarModificarTienda = "Ya existe una tienda con ese nombre";
						break;
					case -2:
						mostrarModificarTienda = "La tienda esta dada de baja por lo que no se puede modificar";
						break;
					case -1:
						mostrarModificarTienda = "La tienda no existe";
						break;
					default:
						mostrarModificarTienda = "Tienda modificada con exito con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, mostrarModificarTienda, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_ASIGNAR_SECCION_TIENDA:
				String mostrarAsignarSeccionTienda = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarAsignarSeccionTienda = "Error transaccion";
						break;
					case -4:
						mostrarAsignarSeccionTienda = "Asignacion desactivada, la hemos activado de nuevo";
						break;
					case -3:
						mostrarAsignarSeccionTienda = "Esta asignacion ya esta activa o esta desactivada";
						break;
					case -2:
						mostrarAsignarSeccionTienda = "La tienda introducida no existe o esta desactivada";
						break;
					case -1:
						mostrarAsignarSeccionTienda = "El seccion introducido no existe o esta desactivado";
						break;
					default:
						mostrarAsignarSeccionTienda = "Presupuesto asignado con exito a tienda: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, mostrarAsignarSeccionTienda, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_DESASIGNAR_SECCION_TIENDA:
				String mostrarDesasignarSeccionTienda = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarDesasignarSeccionTienda = "Error transaccion";
						break;				
					case -5:
						mostrarDesasignarSeccionTienda = "Asignacion desactivada con exito";
						break;
					case -4:
						mostrarDesasignarSeccionTienda = "La asignacion ya esta desactivada";
						break;
					case -3:
						mostrarDesasignarSeccionTienda = "Esta asignacion no existe";
						break;
					case -2:
						mostrarDesasignarSeccionTienda = "La tienda introducida no existe o esta desactivada";
						break;
					case -1:
						mostrarDesasignarSeccionTienda = "El seccion introducido no existe o esta desactivado";
						break;
				}
				
				JOptionPane.showMessageDialog(null, mostrarDesasignarSeccionTienda, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_ASIGNAR_PRESUPUESTO_TIENDA:
				String mostrarAsignarPresupuesto = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarAsignarPresupuesto = "Error transaccion";
						break;				
					case -5:
						mostrarAsignarPresupuesto = "Presupuesto asignado con exito";
						break;
					case -4:
						mostrarAsignarPresupuesto = "El seccion no esta asociado a la tienda, no podemos asignar presupuesto";
						break;
					case -3:
						mostrarAsignarPresupuesto = "Esta asignacion no existe";
						break;
					case -2:
						mostrarAsignarPresupuesto = "La tienda introducida no existe";
						break;
					case -1:
						mostrarAsignarPresupuesto = "El seccion introducido no existe";
						break;
				}				
				
				JOptionPane.showMessageDialog(null, mostrarAsignarPresupuesto, "Informacion", JOptionPane.INFORMATION_MESSAGE);	
				break;
			case ListaComandos.MOSTRAR_DETALLE_TIENDA:
				String mostrarDetalleTienda = "";
				
				if (contexto.getDatos() == null)
					mostrarDetalleTienda = "No existe la tienda buscada";
				else
					mostrarDetalleTienda = contexto.getDatos().toString();
				
				detalleTienda.setAreaDetalle(mostrarDetalleTienda);
				break;
			case ListaComandos.MOSTRAR_LISTA_TIENDA:
				String mostrarListaTienda = "";
				@SuppressWarnings("unchecked")
				ArrayList<TransferTienda> lTienda = (ArrayList<TransferTienda>) contexto.getDatos();
				
				if (lTienda.size() > 0) {
					for (int k = 0; k < lTienda.size(); ++k)
						mostrarListaTienda += lTienda.get(k).toString() + "\n";
				}
				else
					mostrarListaTienda = "No hay ninguna tienda";	
				
				listaTienda.setAreaDetalle(mostrarListaTienda);
				break;
			case ListaComandos.MOSTRAR_DETALLE_PRESUPUESTO_TIENDA:
				String mostrarDetallePresupuesto = "";
				
				if (contexto.getDatos() == null)
					mostrarDetallePresupuesto = "No existe el presupuesto buscado";
				else
					mostrarDetallePresupuesto = contexto.getDatos().toString();
				
				detallePresupuestoTienda.setAreaDetalle(mostrarDetallePresupuesto);
				break;
			case ListaComandos.MOSTRAR_LISTA_PRESUPUESTO_TIENDA:
				String mostrarListaPresupuesto = "";
				@SuppressWarnings("unchecked")
				ArrayList<TransferPresupuesto> lPresupuesto = (ArrayList<TransferPresupuesto>) contexto.getDatos();
				
				if (lPresupuesto.size() > 0) {
					for (int k = 0; k < lPresupuesto.size(); ++k)
						mostrarListaPresupuesto += lPresupuesto.get(k).toString() + "\n";
				}
				else
					mostrarListaPresupuesto = "No hay ningun presupuesto";				
				
				listaPresupuestoTienda.setAreaDetalle(mostrarListaPresupuesto);
				break;
		}
	}
}