package presentacion.vistas.vistaCompra.compra;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import negocio.compra.imp.TransferCompra;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextArea;
import presentacion.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de Gestion de carrito
 */
public class JFrameGestionCarrito extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextArea mostrar;
	private JButton agregarArticulo;
	private JButton eliminarArticulo;
	private JButton finalizarCompra;
	private TransferCompra tCompra;
	private JButton volver;

	public JFrameGestionCarrito(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Carrito de la compra");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		JPanel buttonPanel = new JPanel(new GridLayout(4, 1));	

		mostrar = new JTextArea("Carrito de la compra:");
		agregarArticulo = new JButton("Agregar articulo");
		eliminarArticulo = new JButton("Eliminar articulo");
		finalizarCompra = new JButton("Finalizar compra");
		volver = new JButton("Volver sin comprar");
		
		mostrar.setRows(4);
		mostrar.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(mostrar);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		finalizarCompra.setPreferredSize(new Dimension(800, 35));
		
		agregarArticulo.addActionListener(new ActionListenerGestionCarritoCompra(0));
		eliminarArticulo.addActionListener(new ActionListenerGestionCarritoCompra(1));
		finalizarCompra.addActionListener(new ActionListenerGestionCarritoCompra(2));
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});
		
		panelPrincipal.add(scrollPane);
		buttonPanel.add(agregarArticulo);
		buttonPanel.add(eliminarArticulo);
        buttonPanel.add(finalizarCompra);
        buttonPanel.add(volver);
		panelPrincipal.add(buttonPanel);
		this.getContentPane().add(panelPrincipal);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public class ActionListenerGestionCarritoCompra implements ActionListener {
		private int event;
		
		public ActionListenerGestionCarritoCompra(int event){
			this.event = event;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0){
			int comando = 0;
			
			switch(event){
				case 0:
					comando = ListaComandos.VENTANA_AGREGAR_ARTICULO_COMPRA;
					cerrarParaVistaPropia();
					Controlador.getInstance().accion(comando, null);
					break;
				case 1:
					comando = ListaComandos.VENTANA_ELIMINAR_ARTICULO_COMPRA;
					cerrarParaVistaPropia();
					Controlador.getInstance().accion(comando, tCompra);
					break;
				case 2:
					if(!tCompra.isVaciaLineaCompra()){
						comando = ListaComandos.NEGOCIO_FINALIZAR_COMPRA;
						Controlador.getInstance().accion(comando, tCompra);
					}
					else
						JOptionPane.showMessageDialog(null, "El carrito esta vacio", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					break;
			}
		}
	}
	
	public TransferCompra getTransferCompra(){
		return tCompra;
	}
	
	public void setTransferCompra(TransferCompra tCompra){
		this.tCompra = tCompra;
		mostrar.setText(tCompra.toString());
	}
	
	public void setLineaCompra(Contexto articulo){
		this.tCompra.setLineaCompra(articulo.getEvento(), (int) articulo.getDatos());
		
		mostrar.setText(tCompra.toString());
	}
	
	public void cerrarParaVistaPropia(){
		this.setVisible(false);
	}	
	
	public void cerrar(){
		mostrar.setText("Carrito de la compra");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPRA, null);
	}
}