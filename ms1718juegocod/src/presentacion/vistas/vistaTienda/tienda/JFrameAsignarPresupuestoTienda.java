package presentacion.vistas.vistaTienda.tienda;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.tienda.imp.TransferPresupuesto;

import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameAsignarPresupuestoTienda extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField seccion;
	private JTextField tienda;
	private JTextField cantidad;
	private JButton enviar;
	private JButton salir;
	
	public JFrameAsignarPresupuestoTienda() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Asignar presupuesto tienda");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				cerrar();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(5, 1));

		seccion = new JTextField("Id seccion");
		tienda = new JTextField("Id tienda");
		cantidad = new JTextField("Cantidad");
		enviar = new JButton("Enviar");
		salir = new JButton("Volver");

		seccion.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerAltaCliente());

		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});

		buttonPanel.add(seccion);
		buttonPanel.add(tienda);
		buttonPanel.add(cantidad);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public class ActionListenerAltaCliente implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				Controlador.getInstance().accion(ListaComandos.NEGOCIO_ASIGNAR_PRESUPUESTO_TIENDA, new TransferPresupuesto(Integer.parseInt(seccion.getText()), Integer.parseInt(tienda.getText()), Double.parseDouble(cantidad.getText()), true));
			} 
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,	"Formato no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cerrar() {
		tienda.setText("Id tienda");
		seccion.setText("Id seccion");
		cantidad.setText("Cantidad");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_TIENDA, null);
	}	
}
