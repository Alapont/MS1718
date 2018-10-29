package presentacion.vistas.vistaEmpleado.empleado;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import negocio.empleado.imp.TransferDependiente;
import negocio.empleado.imp.TransferEspecialista;
import negocio.empleado.imp.TransferEmpleado;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameModificarEmpleado extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextField nombre;
	private JTextField dni;
	private JTextField telefono;
	private JTextField sueldo;
	private JTextField seccion;
	private JComboBox<String> tipo;
	private JTextField especifico1;
	private JTextField especifico2;
	private JButton enviar;
	private JButton salir;
	
	public JFrameModificarEmpleado() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		this.setTitle("Modificar empleado");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				cerrar();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(11, 1));

		id = new JTextField("Id");
		nombre = new JTextField("Nombre");
		dni = new JTextField("Dni");
		telefono = new JTextField("Telefono");
		sueldo = new JTextField("Sueldo");
		seccion = new JTextField("Seccion");
		String[] tiposEmpleado = {"Dependiente", "Especialista"};
		tipo = new JComboBox<String>(tiposEmpleado);
		tipo.setSelectedIndex(0);
		especifico1 = new JTextField("Horas trabajadas");
		especifico2 = new JTextField("Productividad");
		enviar = new JButton("Enviar");
		salir = new JButton("Volver");

		id.setPreferredSize(new Dimension(320, 35));

		tipo.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		        if (tipo.getSelectedIndex() == 0) {
		    		especifico1.setText("Horas trabajadas");
		    		especifico2.setText("Productividad");
		        } 
		        else {
		    		especifico1.setText("Funcion");
		    		especifico2.setText("Sueldo base");
		        }
		    }
		});	
		
		enviar.addActionListener(new ActionListenerModificarEmpleado());

		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cerrar();
			}
		});

		buttonPanel.add(id);
		buttonPanel.add(nombre);
		buttonPanel.add(dni);
		buttonPanel.add(telefono);
		buttonPanel.add(sueldo);
		buttonPanel.add(seccion);
		buttonPanel.add(tipo);
		buttonPanel.add(especifico1);
		buttonPanel.add(especifico2);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public class ActionListenerModificarEmpleado implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				TransferEmpleado t = null;
		        if (tipo.getSelectedIndex() == 0) 
		        	t = new TransferDependiente(Integer.parseInt(id.getText()), nombre.getText(), dni.getText(), Integer.parseInt(telefono.getText()), Double.parseDouble(sueldo.getText()), Integer.parseInt(seccion.getText()), true, Integer.parseInt(especifico1.getText()), Integer.parseInt(especifico2.getText()));
		        else
		        	t = new TransferEspecialista(Integer.parseInt(id.getText()), nombre.getText(), dni.getText(), Integer.parseInt(telefono.getText()), Double.parseDouble(sueldo.getText()), Integer.parseInt(seccion.getText()), true, especifico1.getText(), Double.parseDouble(especifico2.getText()));			
		        
		        Controlador.getInstance().accion(ListaComandos.NEGOCIO_MODIFICAR_EMPLEADO, t);
			} 
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Formato empleado no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cerrar() {
		id.setText("Id");
		nombre.setText("Nombre");
		dni.setText("Dni");
		telefono.setText("Telefono");
		sueldo.setText("Sueldo");
		seccion.setText("Seccion");
		tipo.setSelectedIndex(0);
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_EMPLEADO, null);
	}
}