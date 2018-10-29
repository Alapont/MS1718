package presentacion.vistas.vistaSeccion.seccion;

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

public class JFramePrincipalSeccion extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton altaSeccion;
	private JButton bajaSeccion;
	private JButton detalleSeccion;
	private JButton listaSeccion;
	private JButton modificarSeccion;
	private JButton calcularNominaSeccion;
	private JButton salir;
	
	public JFramePrincipalSeccion() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Principal seccion");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				cerrarBotonera();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(7, 1));

		altaSeccion = new JButton("Alta seccion");
		bajaSeccion = new JButton("Baja seccion");
		detalleSeccion = new JButton("Detalle seccion");
		listaSeccion = new JButton("Lista seccion");
		modificarSeccion = new JButton("Modificar seccion");
		calcularNominaSeccion = new JButton("Calcular nomina seccion");
		salir = new JButton("Volver");

		altaSeccion.setPreferredSize(new Dimension(320, 35));

		altaSeccion.addActionListener(new ActionListenerBotoneraCliente(0));
		bajaSeccion.addActionListener(new ActionListenerBotoneraCliente(1));
		detalleSeccion.addActionListener(new ActionListenerBotoneraCliente(2));
		listaSeccion.addActionListener(new ActionListenerBotoneraCliente(3));
		modificarSeccion.addActionListener(new ActionListenerBotoneraCliente(4));
		calcularNominaSeccion.addActionListener(new ActionListenerBotoneraCliente(5));

		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cerrarBotonera();
			}
		});

		buttonPanel.add(altaSeccion);
		buttonPanel.add(bajaSeccion);
		buttonPanel.add(detalleSeccion);
		buttonPanel.add(listaSeccion);
		buttonPanel.add(modificarSeccion);
		buttonPanel.add(calcularNominaSeccion);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public class ActionListenerBotoneraCliente implements ActionListener {
		private int event;

		public ActionListenerBotoneraCliente(int event) {
			this.event = event;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int comando = 0;

			switch (event) {
				case 0:
					comando = ListaComandos.VENTANA_ALTA_SECCION;
					break;
				case 1:
					comando = ListaComandos.VENTANA_BAJA_SECCION;
					break;
				case 2:
					comando = ListaComandos.VENTANA_DETALLE_SECCION;
					break;
				case 3:
					comando = ListaComandos.VENTANA_LISTA_SECCION;
					break;
				case 4:
					comando = ListaComandos.VENTANA_MODIFICAR_SECCION;
					break;
				case 5:
					comando = ListaComandos.VENTANA_CALCULAR_NOMINA_SECCION;
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