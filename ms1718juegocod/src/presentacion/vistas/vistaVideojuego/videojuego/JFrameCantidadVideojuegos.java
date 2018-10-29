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
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;
import presentacion.controlador.PareadoQuery;


/**
 * Clase de la capa presentacion que implementa la ventana de cantidad de videojuego
 */
public class JFrameCantidadVideojuegos extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField idCliente;
	private JTextField idVideojuego;
	private JButton enviar;
	private JButton volver;
	
	public JFrameCantidadVideojuegos(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Cantidad de videojuegos");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(4, 1));

		idCliente = new JTextField("Id cliente");
		idVideojuego = new JTextField("Id videojuego");
		enviar = new JButton("Enviar");
		volver = new JButton("Volver");
		
		idCliente.setPreferredSize(new Dimension(320, 35));
		
		enviar.addActionListener(new ActionListenerCantidadVideojuegosCompra());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});
		
		buttonPanel.add(idCliente);
		buttonPanel.add(idVideojuego);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public class ActionListenerCantidadVideojuegosCompra implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			try{
				Controlador.getInstance().accion(ListaComandos.NEGOCIO_CANTIDAD_VIDEOJUEGOS_QUERY, new PareadoQuery(Integer.parseInt(idCliente.getText()), Integer.parseInt(idVideojuego.getText())));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Formato incorrecto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void cerrar(){
		idCliente.setText("Id cliente");
		idVideojuego.setText("Id videojuego");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_VIDEOJUEGO, null);
	}	
}