package presentacion.vistas.vistaCliente.cliente;

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
 * Clase de la capa presentación que permite la implementación de la ventana principal del modulo cliente
 */
public class JFramePrincipalCliente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton altaCliente;
	private JButton bajaCliente;
	private JButton detalleCliente;
	private JButton listaCliente;
	private JButton modificarCliente;
	private JButton numeroClientes;
	private JButton volver;
	
	public JFramePrincipalCliente() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Principal Cliente");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrarBotonera();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(7, 1));
		
		altaCliente = new JButton("Crear Cliente");
		bajaCliente = new JButton("Eliminar Cliente");
		detalleCliente = new JButton("Detalle cliente");
		listaCliente = new JButton("Lista cliente");
		modificarCliente = new JButton("Modificar cliente");
		numeroClientes = new JButton("Numero clientes");
		volver = new JButton("Volver");
		
		altaCliente.setPreferredSize(new Dimension(320, 35));
		
		altaCliente.addActionListener(new ActionListenerBotoneraCliente(0));
		bajaCliente.addActionListener(new ActionListenerBotoneraCliente(1));
		detalleCliente.addActionListener(new ActionListenerBotoneraCliente(2));
		listaCliente.addActionListener(new ActionListenerBotoneraCliente(3));
		modificarCliente.addActionListener(new ActionListenerBotoneraCliente(4));
		numeroClientes.addActionListener(new ActionListenerBotoneraCliente(5));
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrarBotonera();
			}
		});
		
		buttonPanel.add(altaCliente);
		buttonPanel.add(bajaCliente);
		buttonPanel.add(detalleCliente);
		buttonPanel.add(listaCliente);
		buttonPanel.add(modificarCliente);
		buttonPanel.add(numeroClientes);
		buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	
	public class ActionListenerBotoneraCliente implements ActionListener{
		private int event;
		
		public ActionListenerBotoneraCliente(int event){
			this.event = event;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0){
			int comando = 0;
			
			switch(event){
				case 0:
					comando = ListaComandos.VENTANA_ALTA_CLIENTE; break;
				case 1:
					comando = ListaComandos.VENTANA_BAJA_CLIENTE; break;
				case 2:
					comando = ListaComandos.VENTANA_DETALLE_CLIENTE; break;
				case 3:
					comando = ListaComandos.VENTANA_LISTA_CLIENTE; break;
				case 4:
					comando = ListaComandos.VENTANA_MODIFICAR_CLIENTE; break;
				case 5:
					comando = ListaComandos.VENTANA_NUMERO_CLIENTES_QUERY;
			}
			
			cerrarParaVistaPropia();
			Controlador.getInstance().accion(comando, null);
		}
	}
	
	public void cerrarParaVistaPropia(){
		this.setVisible(false);
	}
	
	public void cerrarBotonera(){
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL, null);
	}
}