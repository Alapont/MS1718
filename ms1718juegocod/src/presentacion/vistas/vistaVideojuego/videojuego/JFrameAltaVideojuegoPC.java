package presentacion.vistas.vistaVideojuego.videojuego;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import negocio.videojuego.imp.TransferVideojuegoPC;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentacion que implementa la ventana de alta de videojuego de ordenador
 */
public class JFrameAltaVideojuegoPC extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField desarrollador;
	private JTextField precio;
	private JTextField sistema;
	private JButton enviar;
	private JButton volver;
	
	public JFrameAltaVideojuegoPC(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Alta videojuego PC");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(6, 1));


		nombre = new JTextField("Nombre videojuego");
		desarrollador = new JTextField("Desarrollador");
		precio = new JTextField("Precio videojuego");
		sistema = new JTextField("Sistema videojuego");
		enviar = new JButton("Enviar");
		volver = new JButton("Volver");
		
		sistema.setPreferredSize(new Dimension(320, 35));
		
		enviar.addActionListener(new ActionListenerAltaVideojuegoConsola());

		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});

		buttonPanel.add(nombre);
		buttonPanel.add(desarrollador);
		buttonPanel.add(precio);
		buttonPanel.add(sistema);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public class ActionListenerAltaVideojuegoConsola implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			try {
				Controlador.getInstance().accion(ListaComandos.NEGOCIO_ALTA_VIDEOJUEGO, new TransferVideojuegoPC(nombre.getText(), desarrollador.getText(), Double.parseDouble(precio.getText()), sistema.getText(), true));
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Formato videojuego no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void cerrar(){
		sistema.setText("Nombre videojuego");
		desarrollador.setText("Desarrollador");
		precio.setText("Precio videojuego");
		sistema.setText("sistema videojuego");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_VIDEOJUEGO, null);
	}
}