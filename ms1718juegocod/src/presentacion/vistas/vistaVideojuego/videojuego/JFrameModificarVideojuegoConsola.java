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
import negocio.videojuego.imp.TransferVideojuegoConsola;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentacion que implementa la ventana de modificar de videojuego
 */
public class JFrameModificarVideojuegoConsola extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextField nombre;
	private JTextField desarrollador;
	private JTextField precio;
	private JTextField MarcaConsola;
	private JButton enviar;
	private JButton volver;
	
	public JFrameModificarVideojuegoConsola(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Modificar videojuego consola");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(7, 1));
		
		id = new JTextField("Id videojuego");
		nombre = new JTextField("Nombre videojuego");
		desarrollador = new JTextField("Desarrollador");
		precio = new JTextField("Precio videojuego");
		MarcaConsola = new JTextField("Marca videojuego");
		enviar = new JButton("Enviar");
		volver = new JButton("Volver");
		
		id.setPreferredSize(new Dimension(320, 35));
		
		enviar.addActionListener(new ActionListenerModificarvideojuegoMontana());	
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrar();
			}
		});	

		buttonPanel.add(id);
		buttonPanel.add(nombre);
		buttonPanel.add(desarrollador);
		buttonPanel.add(precio);
		buttonPanel.add(MarcaConsola);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public class ActionListenerModificarvideojuegoMontana implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			try	{
				Controlador.getInstance().accion(ListaComandos.NEGOCIO_MODIFICAR_VIDEOJUEGO, new TransferVideojuegoConsola(Integer.parseInt(id.getText()), nombre.getText(), desarrollador.getText(), Double.parseDouble(precio.getText()), MarcaConsola.getText(), true));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Formato videojuego no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void cerrar(){
		id.setText("Id videojuego");
		nombre.setText("Nombre videojuego");
		desarrollador.setText("Desarrollador");
		precio.setText("Precio videojuego");
		MarcaConsola.setText("Marca videojuego");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_VIDEOJUEGO, null);
	}
}