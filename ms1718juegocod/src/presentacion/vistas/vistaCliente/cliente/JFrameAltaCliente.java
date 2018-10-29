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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import negocio.cliente.imp.TransferCliente;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de alta de un cliente
 */
public class JFrameAltaCliente extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField tarjetaDePago;
	private JTextField dni;
	private JButton enviar;
	private JButton volver;
	
	public JFrameAltaCliente() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
				
		this.setTitle("Alta cliente");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(6, 1));

		nombre = new JTextField("Nombre cliente");
		dni = new JTextField("DNI cliente");
		tarjetaDePago = new JTextField("Tarjeta de Credito cliente");
		enviar = new JButton("Enviar");
		volver = new JButton("Volver");
		
		nombre.setPreferredSize(new Dimension(320, 35));
		
		enviar.addActionListener(new ActionListenerAltaCliente());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});
		
		buttonPanel.add(nombre);
		buttonPanel.add(dni);
		buttonPanel.add(tarjetaDePago);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public class ActionListenerAltaCliente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			try{
				Controlador.getInstance().accion(ListaComandos.NEGOCIO_ALTA_CLIENTE, new TransferCliente(nombre.getText(), dni.getText(), tarjetaDePago.getText(), true));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Formato cliente no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo que nos permite retornar a la ventana principal de la aplicacion.
	public void cerrar(){
		nombre.setText("Nombre cliente");
		dni.setText("DNI cliente");
		tarjetaDePago.setText("tarjeta de credito cliente");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_CLIENTE, null);
	}
}