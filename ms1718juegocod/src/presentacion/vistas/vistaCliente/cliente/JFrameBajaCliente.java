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
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de baja de un cliente
 */
public class JFrameBajaCliente extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JButton enviar;
	private JButton volver;
	
	public JFrameBajaCliente(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Baja Cliente");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
		
		id = new JTextField("Id Cliente");
		enviar = new JButton("Enviar");
		volver = new JButton("Volver");
		
		id.setPreferredSize(new Dimension(320, 35));
		
		enviar.addActionListener(new ActionListenerBajaCliente());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrar();
			}
		});

		buttonPanel.add(id);
		buttonPanel.add(enviar);
		buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public class ActionListenerBajaCliente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			try{
				Controlador.getInstance().accion(ListaComandos.NEGOCIO_BAJA_CLIENTE, Integer.parseInt(id.getText()));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Formato cliente no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void cerrar(){
		id.setText("Id Cliente");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_CLIENTE, null);
	}
}