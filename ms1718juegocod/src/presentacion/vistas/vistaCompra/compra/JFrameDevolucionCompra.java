package presentacion.vistas.vistaCompra.compra;

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
import negocio.compra.imp.TransferLineaDeCompra;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de devolucion de compra
 */
public class JFrameDevolucionCompra extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField idCompra;
	private JTextField idArticulo;
	private JTextField cantidadArticulo;
	private JButton enviar;
	private JButton volver;
	
	public JFrameDevolucionCompra(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Devolucion articulo");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(5, 1));

		idCompra = new JTextField("Id compra");
		idArticulo = new JTextField("Id articulo");
		cantidadArticulo = new JTextField("Cantidad articulo");
		enviar = new JButton("Enviar");
		volver = new JButton("Volver");
		
		idCompra.setPreferredSize(new Dimension(320, 35));
		
		enviar.addActionListener(new ActionListenerDevolucionCompra());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});
		
		buttonPanel.add(idCompra);
		buttonPanel.add(idArticulo);
		buttonPanel.add(cantidadArticulo);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public class ActionListenerDevolucionCompra implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0){
			try{
				Controlador.getInstance().accion(ListaComandos.NEGOCIO_DEVOLUCION_COMPRA, new TransferLineaDeCompra(Integer.parseInt(idCompra.getText()), Integer.parseInt(idArticulo.getText()), Integer.parseInt(cantidadArticulo.getText()), 0));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Formato devolucion incorrecto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void cerrar(){
		idCompra.setText("Id compra");
		idArticulo.setText("Id articulo");
		cantidadArticulo.setText("Cantidad articulo");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPRA, null);
	}	
}