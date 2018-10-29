package presentacion.vistas.vistaPrincipal.principal;

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

/**
 * Clase de la capa presentacion que permite la vista de la ventana principal de la aplicación. Hereda de JFrame.
 */
public class JFramePrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton cliente;
	private JButton compra;
	private JButton videojuego;
	private JButton empleado;
	private JButton seccion;
	private JButton tienda;
	private JButton salir;
	
	/**
	 * Contructor de la clase. Inicia la ventana principal
	 */
	public JFramePrincipal(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("JuegoStore");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {ocultarVentana();}});
		
		//Creamos nuestro panel de botones, que contendra los botones que nos permitiran abrir el resto de apartados de la aplicacion
		JPanel buttonPanel = new JPanel(new GridLayout(7, 1));
		
		//Inicializamos los botones
		cliente = new JButton("Modulo Cliente");
		compra = new JButton("Modulo Compra");
		videojuego = new JButton("Modulo Videojuego");
		empleado = new JButton("Modulo Empleado");
		seccion = new JButton("Modulo Seccion");
		tienda = new JButton("Modulo Tienda");
		salir = new JButton("Salir");
		
		//Añadimos los actionListeners a los botones, que ejecutaran los metodos del controlador en funcion del evento
		cliente.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ocultarVentana();
				Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_CLIENTE, null);
			}
		});
		
		compra.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ocultarVentana();
				Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPRA, null);
			}
		});
		
		videojuego.setPreferredSize(new Dimension(300, 35));
		
		videojuego.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ocultarVentana();
				Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_VIDEOJUEGO, null);
			}
		});
		
		empleado.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ocultarVentana();
				Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_EMPLEADO, null);
			}
		});
		
		seccion.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ocultarVentana();
				Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_SECCION, null);
			}
		});
		
		tienda.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ocultarVentana();
				Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_TIENDA, null);
			}
		});
		
		salir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrarAplicacion();
			}
		});
		
		
		this.getContentPane().add(cliente);
		this.getContentPane().add(compra);
		this.getContentPane().add(videojuego);
		this.getContentPane().add(empleado);
		this.getContentPane().add(seccion);
		this.getContentPane().add(tienda);
		this.getContentPane().add(salir);
		
		//Añadimos a la ventana principal los botones
		buttonPanel.add(videojuego);
		buttonPanel.add(cliente);
		buttonPanel.add(compra);
		buttonPanel.add(empleado);
		buttonPanel.add(seccion);
		buttonPanel.add(tienda);
		buttonPanel.add(salir);
		
		//Añadimos al Contentpane nuestro panel de botones
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	
	/**
	 * Funcion que oculta la ventana sin finalizar la ejecución del programa.
	 */
	public void ocultarVentana(){
		this.setVisible(false);
	}
	
	/**
	 * Funcion que cierra la aplicacion finalizando la ejecución del programa.
	 */
	public void cerrarAplicacion(){
		this.dispose();
		System.exit(0);
	}	
}