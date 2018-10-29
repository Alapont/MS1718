package presentacion.vistas.vistaEmpleado.empleado;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameBotoneraEmpleado extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton altaEmpleado;
	private JButton bajaEmpleado;
	private JButton detalleEmpleado;
	private JButton listaEmpleado;
	private JButton modificarEmpleado;
	private JButton salir;
	
	public JFrameBotoneraEmpleado() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		this.setTitle("Botonera empleado");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				cerrarBotonera();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(6, 1));

		altaEmpleado = new JButton("Alta empleado");
		bajaEmpleado = new JButton("Baja empleado");
		detalleEmpleado = new JButton("Detalle empleado");
		listaEmpleado = new JButton("Lista empleado");
		modificarEmpleado = new JButton("Modificar empleado");
		salir = new JButton("Volver");

		altaEmpleado.setPreferredSize(new Dimension(320, 35));

		altaEmpleado.addActionListener(new ActionListenerBotoneraEmpleado(0));
		bajaEmpleado.addActionListener(new ActionListenerBotoneraEmpleado(1));
		detalleEmpleado.addActionListener(new ActionListenerBotoneraEmpleado(2));
		listaEmpleado.addActionListener(new ActionListenerBotoneraEmpleado(3));
		modificarEmpleado.addActionListener(new ActionListenerBotoneraEmpleado(4));

		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cerrarBotonera();
			}
		});

		buttonPanel.add(altaEmpleado);
		buttonPanel.add(bajaEmpleado);
		buttonPanel.add(detalleEmpleado);
		buttonPanel.add(listaEmpleado);
		buttonPanel.add(modificarEmpleado);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public class ActionListenerBotoneraEmpleado implements ActionListener {
		private int event;

		public ActionListenerBotoneraEmpleado(int event) {
			this.event = event;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int comando = 0;

			switch (event) {
				case 0:
					comando = ListaComandos.VENTANA_ALTA_EMPLEADO;
					break;
				case 1:
					comando = ListaComandos.VENTANA_BAJA_EMPLEADO;
					break;
				case 2:
					comando = ListaComandos.VENTANA_DETALLE_EMPLEADO;
					break;
				case 3:
					comando = ListaComandos.VENTANA_LISTA_EMPLEADO;
					break;
				case 4:
					comando = ListaComandos.VENTANA_MODIFICAR_EMPLEADO;
					break;
			}

			cerrarParaVistaPropia();
			Controlador.getInstance().accion(comando, null);
		}
	}

	public void cerrarParaVistaPropia() {
		this.setVisible(false);
	}

	public void cerrarBotonera() {
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL, null);
	}
}