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
import presentacion.controlador.PareadoQuery;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de Numero de clientes
 */
public class JFrameNumeroClientes extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField nFacturas;
	private JTextField nImporte;
	private JButton enviar;
	private JButton volver;
	
	public JFrameNumeroClientes(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Numero de clientes");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(4, 1));

		nFacturas = new JTextField("Numero de facturas");
		nImporte = new JTextField("Importe minimo");
		enviar = new JButton("Enviar");
		volver = new JButton("Volver");
		
		nFacturas.setPreferredSize(new Dimension(320, 35));
		
		enviar.addActionListener(new ActionListenerNumeroClientesCompra());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});
		
		buttonPanel.add(nFacturas);
		buttonPanel.add(nImporte);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public class ActionListenerNumeroClientesCompra implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			try{
				Controlador.getInstance().accion(ListaComandos.NEGOCIO_NUMERO_CLIENTES_QUERY,new PareadoQuery(Integer.parseInt(nFacturas.getText()), Integer.parseInt(nImporte.getText())));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Formato articulo incorrecto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void cerrar(){
		nFacturas.setText("Numero de facturas");
		nImporte.setText("Importe minimo");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_CLIENTE, null);
	}
}