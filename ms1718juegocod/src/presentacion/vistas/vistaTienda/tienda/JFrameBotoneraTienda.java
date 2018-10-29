package presentacion.vistas.vistaTienda.tienda;

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

public class JFrameBotoneraTienda extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton altaTienda;
	private JButton bajaTienda;
	private JButton listaTienda;
	private JButton modificarTienda;
	private JButton detalleTienda;
	private JButton asignarSeccionTienda;
	private JButton desasignarSeccionTienda;
	private JButton asignarPresupuestoTienda;
	private JButton detallePresupuestoTienda;
	private JButton listaPresupuestoTienda;
	private JButton volver;
	
	public JFrameBotoneraTienda() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Botonera tienda");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				cerrarBotonera();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(11, 1));

		altaTienda = new JButton("Alta tienda");
		bajaTienda = new JButton("Baja tienda");
		detalleTienda = new JButton("Detalle tienda");
		listaTienda = new JButton("Lista tienda");
		modificarTienda = new JButton("Modificar tienda");
		asignarSeccionTienda = new JButton("Asignar seccion a tienda");
		desasignarSeccionTienda = new JButton("Desasignar seccion a tienda");
		asignarPresupuestoTienda = new JButton("Asignar presupuesto a tienda");
		detallePresupuestoTienda = new JButton("Detalle presupuesto tienda");
		listaPresupuestoTienda = new JButton("Lista presupuesto tienda");
		volver = new JButton("Volver");

		altaTienda.setPreferredSize(new Dimension(320, 35));

		altaTienda.addActionListener(new ActionListenerBotoneraCliente(0));
		bajaTienda.addActionListener(new ActionListenerBotoneraCliente(1));
		detalleTienda.addActionListener(new ActionListenerBotoneraCliente(2));
		listaTienda.addActionListener(new ActionListenerBotoneraCliente(3));
		modificarTienda.addActionListener(new ActionListenerBotoneraCliente(4));
		asignarSeccionTienda.addActionListener(new ActionListenerBotoneraCliente(5));
		desasignarSeccionTienda.addActionListener(new ActionListenerBotoneraCliente(6));
		asignarPresupuestoTienda.addActionListener(new ActionListenerBotoneraCliente(7));
		detallePresupuestoTienda.addActionListener(new ActionListenerBotoneraCliente(8));
		listaPresupuestoTienda.addActionListener(new ActionListenerBotoneraCliente(9));
		
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cerrarBotonera();
			}
		});

		buttonPanel.add(altaTienda);
		buttonPanel.add(bajaTienda);
		buttonPanel.add(detalleTienda);
		buttonPanel.add(listaTienda);
		buttonPanel.add(modificarTienda);
		buttonPanel.add(asignarSeccionTienda);
		buttonPanel.add(desasignarSeccionTienda);
		buttonPanel.add(asignarPresupuestoTienda);
		buttonPanel.add(detallePresupuestoTienda);
		buttonPanel.add(listaPresupuestoTienda);
		buttonPanel.add(volver);
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

			switch (event) 
			{
				case 0:
					comando = ListaComandos.VENTANA_ALTA_TIENDA;
					break;
				case 1:
					comando = ListaComandos.VENTANA_BAJA_TIENDA;
					break;
				case 2:
					comando = ListaComandos.VENTANA_DETALLE_TIENDA;
					break;
				case 3:
					comando = ListaComandos.VENTANA_LISTA_TIENDA;
					break;
				case 4:
					comando = ListaComandos.VENTANA_MODIFICAR_TIENDA;
					break;
				case 5:
					comando = ListaComandos.VENTANA_ASIGNAR_SECCION_TIENDA;
					break;
				case 6:
					comando = ListaComandos.VENTANA_DESASIGNAR_SECCION_TIENDA;
					break;
				case 7:
					comando = ListaComandos.VENTANA_ASIGNAR_PRESUPUESTO_TIENDA;
					break;
				case 8:
					comando = ListaComandos.VENTANA_DETALLE_PRESUPUESTO_TIENDA;
					break;
				case 9:
					comando = ListaComandos.VENTANA_LISTA_PRESUPUESTO_TIENDA;
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