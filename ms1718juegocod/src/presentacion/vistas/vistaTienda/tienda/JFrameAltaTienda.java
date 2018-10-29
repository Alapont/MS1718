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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import negocio.tienda.imp.TransferTienda;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameAltaTienda extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField direccion;
	private JButton enviar;
	private JButton salir;
	
	public JFrameAltaTienda() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Alta tienda");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				cerrar();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(4, 1));

		nombre = new JTextField("Nombre");
		direccion = new JTextField("Direccion");
		enviar = new JButton("Enviar");
		salir = new JButton("Volver");

		nombre.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerAltaCliente());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});

		buttonPanel.add(nombre);
		buttonPanel.add(direccion);
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
			Controlador.getInstance().accion(ListaComandos.NEGOCIO_ALTA_TIENDA, new TransferTienda(nombre.getText(), direccion.getText(), true));
		}
	}

	public void cerrar() {
		nombre.setText("Nombre");
		direccion.setText("Direccion");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_TIENDA, null);
	}	
}