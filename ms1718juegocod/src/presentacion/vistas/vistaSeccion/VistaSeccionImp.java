package presentacion.vistas.vistaSeccion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import negocio.seccion.imp.TransferSeccion;
import presentacion.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaSeccion.seccion.JFrameAltaSeccion;
import presentacion.vistas.vistaSeccion.seccion.JFrameBajaSeccion;
import presentacion.vistas.vistaSeccion.seccion.JFramePrincipalSeccion;
import presentacion.vistas.vistaSeccion.seccion.JFrameCalcularNominaSeccion;
import presentacion.vistas.vistaSeccion.seccion.JFrameDetalleSeccion;
import presentacion.vistas.vistaSeccion.seccion.JFrameListaSeccion;
import presentacion.vistas.vistaSeccion.seccion.JFrameModificarSeccion;

public class VistaSeccionImp extends VistaSeccion {
	private JFrameAltaSeccion altaSeccion;
	private JFrameBajaSeccion bajaSeccion;
	private JFramePrincipalSeccion botoneraSeccion;
	private JFrameDetalleSeccion detalleSeccion;
	private JFrameListaSeccion listaSeccion;
	private JFrameModificarSeccion modificarSeccion;
	private JFrameCalcularNominaSeccion calcularNominaSeccion;
	
	public VistaSeccionImp() {
		createJFrameAltaSeccion();
		createJFrameBajaSeccion();
		createJFrameBotoneraSeccion();
		createJFrameDetalleSeccion();
		createJFrameListaSeccion();
		createJFrameModificarSeccion();
		createJFrameCalcularNominaSeccion();
	}	
	
	public void createJFrameAltaSeccion() {
		if(altaSeccion == null)
			altaSeccion = new JFrameAltaSeccion();
	}

	public void createJFrameBajaSeccion() {
		if(bajaSeccion == null)
			bajaSeccion = new JFrameBajaSeccion();
	}

	public void createJFrameBotoneraSeccion() {
		if(botoneraSeccion == null)
			botoneraSeccion = new JFramePrincipalSeccion();
	}

	public void createJFrameDetalleSeccion() {
		if(detalleSeccion == null)
			detalleSeccion = new JFrameDetalleSeccion();
	}

	public void createJFrameListaSeccion() {
		if(listaSeccion == null)
			listaSeccion = new JFrameListaSeccion();
	}

	public void createJFrameModificarSeccion() {
		if(modificarSeccion == null)
			modificarSeccion = new JFrameModificarSeccion();
	}
	
	public void createJFrameCalcularNominaSeccion() {
		if(calcularNominaSeccion == null)
			calcularNominaSeccion = new JFrameCalcularNominaSeccion();
	}

	@Override
	public void update(Contexto contexto) {
		switch(contexto.getEvento()) {
			case ListaComandos.VENTANA_ALTA_SECCION:
				altaSeccion.setVisible(true);
				break;
			case ListaComandos.VENTANA_BAJA_SECCION:
				bajaSeccion.setVisible(true);
				break;
			case ListaComandos.VENTANA_PRINCIPAL_SECCION:
				botoneraSeccion.setVisible(true);
				break;
			case ListaComandos.VENTANA_DETALLE_SECCION:
				detalleSeccion.setVisible(true);
				break;
			case ListaComandos.VENTANA_LISTA_SECCION:
				listaSeccion.setVisible(true);
				break;
			case ListaComandos.VENTANA_MODIFICAR_SECCION:
				modificarSeccion.setVisible(true);
				break;
			case ListaComandos.VENTANA_CALCULAR_NOMINA_SECCION:
				calcularNominaSeccion.setVisible(true);
				break;	
			case ListaComandos.MOSTRAR_ALTA_SECCION:
				String mostrarAltaSeccion = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarAltaSeccion = "Error transaccion";
						break;
					case -2:
						mostrarAltaSeccion = "Seccion desactivado, lo hemos activado de nuevo";
						break;
					case -1:
						mostrarAltaSeccion = "Existe un seccion con el mismo nombre y esta activo";
						break;
					default:
						mostrarAltaSeccion = "Se ha insertado con exito el seccion con id: " + contexto.getDatos();
				}
				JOptionPane.showMessageDialog(null, mostrarAltaSeccion, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_BAJA_SECCION:
				String mostrarBajaSeccion = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarBajaSeccion = "Error transaccion";
						break;
					case -4:
						mostrarBajaSeccion = "No puede darse de baja el seccion ya que tiene una asignacion activa";
						break;
					case -3:
						mostrarBajaSeccion = "No puede darse de baja el seccion ya que tiene empleados activos";
						break;		
					case -2:
						mostrarBajaSeccion = "El seccion esta desactivado";
						break;
					case -1:
						mostrarBajaSeccion = "El seccion no existe";
						break;
					default:
						mostrarBajaSeccion = "Seccion dado de baja con exito con id: " + (int)contexto.getDatos();
				}
				JOptionPane.showMessageDialog(null, mostrarBajaSeccion, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_MODIFICAR_SECCION:
				String mostrarModificarSeccion = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarModificarSeccion = "Error transaccion";
						break;
					case -3:
						mostrarModificarSeccion = "Ya existe un seccion con ese nombre";
						break;
					case -2:
						mostrarModificarSeccion = "El seccion esta dado de baja por lo que no se puede modificar";
						break;
					case -1:
						mostrarModificarSeccion = "El seccion no existe";
						break;
					default:
						mostrarModificarSeccion = "Seccion modificado con exito con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, mostrarModificarSeccion, "Informacion", JOptionPane.INFORMATION_MESSAGE);	
				break;	
			case ListaComandos.MOSTRAR_CALCULAR_NOMINA_SECCION:
				String mostrarCalcularNomina = "";
				double salario = (double)contexto.getDatos();
				
				if(salario == -2)
					mostrarCalcularNomina = "Seccion no esta activo";
				else if(salario == -1)
					mostrarCalcularNomina = "Seccion no existe";
				else
					mostrarCalcularNomina = "La suma de los salarios de todos los empleados es: " + salario + "€";
				
				JOptionPane.showMessageDialog(null, mostrarCalcularNomina, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_DETALLE_SECCION:
				String mostrarDetalleSeccion = "";
				
				if (contexto.getDatos() == null)
					mostrarDetalleSeccion = "No existe el seccion buscado";
				else
					mostrarDetalleSeccion = contexto.getDatos().toString();				
				
				detalleSeccion.setAreaDetalle(mostrarDetalleSeccion);
				break;
			case ListaComandos.MOSTRAR_LISTA_SECCION:
				String mostrarListaSeccion = "";

				@SuppressWarnings("unchecked")
				ArrayList<TransferSeccion> lista = (ArrayList<TransferSeccion>) contexto.getDatos();
				
				if (lista.size() > 0) {
					for (int k = 0; k < lista.size(); ++k)
						mostrarListaSeccion += lista.get(k).toString() + "\n";
				}
				else
					mostrarListaSeccion = "No hay ningun seccion";				
				
				listaSeccion.setAreaDetalle(mostrarListaSeccion);
				break;
		}
	}
}