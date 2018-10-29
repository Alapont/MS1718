package presentacion.vistas.vistaEmpleado;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import negocio.empleado.imp.TransferEmpleado;
import presentacion.ListaComandos;
import presentacion.vistas.vistaEmpleado.empleado.JFrameAltaEmpleado;
import presentacion.vistas.vistaEmpleado.empleado.JFrameBajaEmpleado;
import presentacion.vistas.vistaEmpleado.empleado.JFrameBotoneraEmpleado;
import presentacion.vistas.vistaEmpleado.empleado.JFrameDetalleEmpleado;
import presentacion.vistas.vistaEmpleado.empleado.JFrameListaEmpleado;
import presentacion.vistas.vistaEmpleado.empleado.JFrameModificarEmpleado;
import presentacion.controlador.Contexto;

public class VistaEmpleadoImp extends VistaEmpleado
{
	private JFrameAltaEmpleado altaEmpleado;
	private JFrameBajaEmpleado bajaEmpleado;
	private JFrameBotoneraEmpleado botoneraEmpleado;
	private JFrameDetalleEmpleado detalleEmpleado;
	private JFrameListaEmpleado listaEmpleado;
	private JFrameModificarEmpleado modificarEmpleado;
	
	public VistaEmpleadoImp() {
		createJFramealtaEmpleado();
		createJFrameBajaEmpleado();
		createJFrameBotoneraEmpleado();
		createJFrameDetalleEmpleado();
		createJFrameListaEmpleado();
		createJFramemodificarEmpleado();
	}
	
	public void createJFramealtaEmpleado() {
		if (altaEmpleado == null)
			altaEmpleado = new JFrameAltaEmpleado();
	}

	public void createJFrameBajaEmpleado() {
		if (bajaEmpleado == null)
			bajaEmpleado = new JFrameBajaEmpleado();
	}

	public void createJFrameBotoneraEmpleado() {
		if (botoneraEmpleado == null)
			botoneraEmpleado = new JFrameBotoneraEmpleado();
	}

	public void createJFrameDetalleEmpleado() {
		if (detalleEmpleado == null)
			detalleEmpleado = new JFrameDetalleEmpleado();
	}

	public void createJFrameListaEmpleado() {
		if (listaEmpleado == null)
			listaEmpleado = new JFrameListaEmpleado();
	}

	public void createJFramemodificarEmpleado()	{
		if (modificarEmpleado == null)
			modificarEmpleado = new JFrameModificarEmpleado();
	}

	public void update(Contexto contexto) {
		switch(contexto.getEvento()) {
			case ListaComandos.VENTANA_ALTA_EMPLEADO:
				altaEmpleado.setVisible(true);
				break;
			case ListaComandos.VENTANA_BAJA_EMPLEADO:
				bajaEmpleado.setVisible(true);
				break;
			case ListaComandos.VENTANA_PRINCIPAL_EMPLEADO:
				botoneraEmpleado.setVisible(true);
				break;
			case ListaComandos.VENTANA_DETALLE_EMPLEADO:
				detalleEmpleado.setVisible(true);
				break;
			case ListaComandos.VENTANA_LISTA_EMPLEADO:
				listaEmpleado.setVisible(true);
				break;
			case ListaComandos.VENTANA_MODIFICAR_EMPLEADO:
				modificarEmpleado.setVisible(true);
				break;
			case ListaComandos.MOSTRAR_ALTA_EMPLEADO:
				String mostrarAltaEmpleado = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarAltaEmpleado = "Error transaccion";
						break;				
					case -4:
						mostrarAltaEmpleado = "Empleado desactivado, lo hemos activado de nuevo";
						break;
					case -3:
						mostrarAltaEmpleado = "Existe un empleado con el mismo dni y esta activo";
						break;
					case -2:
						mostrarAltaEmpleado = "El seccion no esta activo";
						break;
					case -1:
						mostrarAltaEmpleado = "El seccion no existe";
						break;
					default:
						mostrarAltaEmpleado = "Se ha insertado con exito el empleado con id: " + contexto.getDatos();
				}
				JOptionPane.showMessageDialog(null, mostrarAltaEmpleado, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_BAJA_EMPLEADO:
				String mostrarBajaEmpleado = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarBajaEmpleado = "Error transaccion";
						break;
					case -2:
						mostrarBajaEmpleado = "El empleado esta desactivado";
						break;
					case -1:
						mostrarBajaEmpleado = "El empleado no existe";
						break;
					default:
						mostrarBajaEmpleado = "Empleado dado de baja con exito con id: " + contexto.getDatos();
				}
				JOptionPane.showMessageDialog(null, mostrarBajaEmpleado, "Informacion", JOptionPane.INFORMATION_MESSAGE);	
				break;
			case ListaComandos.MOSTRAR_MODIFICAR_EMPLEADO:
				String mostrarModificarEmpleado = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarModificarEmpleado = "Error transaccion";
						break;
					case -6:
						mostrarModificarEmpleado = "El empleado introducido no es del tipo correcto";
						break;
					case -5:
						mostrarModificarEmpleado = "Ya existe un empleado con ese dni";
						break;
					case -4:
						mostrarModificarEmpleado = "El seccion no esta activo";
						break;
					case -3:
						mostrarModificarEmpleado = "El seccion no existe";
						break;
					case -2:
						mostrarModificarEmpleado = "El empleado esta dado de baja por lo que no se puede modificar";
						break;
					case -1:
						mostrarModificarEmpleado = "El empleado no existe";
						break;
					default:
						mostrarModificarEmpleado = "Empleado modificado con exito con id: " + contexto.getDatos();
				}
				JOptionPane.showMessageDialog(null, mostrarModificarEmpleado, "Informacion", JOptionPane.INFORMATION_MESSAGE);	
				break;
			case ListaComandos.MOSTRAR_DETALLE_EMPLEADO:
				String mostrarDetalleEmpleado = "";
				
				if (contexto.getDatos() == null)
					mostrarDetalleEmpleado = "No existe el empleado buscado";
				else
					mostrarDetalleEmpleado = contexto.getDatos().toString();
				
				detalleEmpleado.setAreaDetalle(mostrarDetalleEmpleado);
				break;
			case ListaComandos.MOSTRAR_LISTA_EMPLEADO:
				String mostrarListaEmpleado = "";
				@SuppressWarnings("unchecked")
				ArrayList<TransferEmpleado> lista = (ArrayList<TransferEmpleado>) contexto.getDatos();
				
				if (lista.size() > 0) {
					for (int k = 0; k < lista.size(); ++k)
						mostrarListaEmpleado += lista.get(k).toString() + "\n";
				}
				else
					mostrarListaEmpleado = "No hay ningun empleado";
				
				listaEmpleado.setAreaDetalle(mostrarListaEmpleado);
				break;
		}
	}
}