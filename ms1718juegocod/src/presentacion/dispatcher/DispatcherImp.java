package presentacion.dispatcher;

import presentacion.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaVideojuego.VistaVideojuego;
import presentacion.vistas.vistaCliente.VistaCliente;
import presentacion.vistas.vistaCompra.VistaCompra;
import presentacion.vistas.vistaEmpleado.VistaEmpleado;
import presentacion.vistas.vistaSeccion.VistaSeccion;
import presentacion.vistas.vistaTienda.VistaTienda;
import presentacion.vistas.vistaPrincipal.VistaPrincipal;

/**
 * Clase de la capa presentacion que implementa al Dispatcher
 */
public class DispatcherImp extends Dispatcher{
	
	/**
	 * Metodo que realiza la accion necesaria en funcion del evento que le facilite el contexto
	 */
	@Override
	public void accion(Contexto contexto){
		switch(contexto.getEvento()){
		
			// Vista Principal
		
			case ListaComandos.VENTANA_PRINCIPAL:
				VistaPrincipal.getInstance().update(contexto);
				break;

			// Vista Cliente
			
			case ListaComandos.VENTANA_ALTA_CLIENTE:
			case ListaComandos.VENTANA_BAJA_CLIENTE:
			case ListaComandos.VENTANA_PRINCIPAL_CLIENTE:
			case ListaComandos.VENTANA_DETALLE_CLIENTE:
			case ListaComandos.VENTANA_LISTA_CLIENTE:
			case ListaComandos.VENTANA_MODIFICAR_CLIENTE:
			case ListaComandos.VENTANA_NUMERO_CLIENTES_QUERY:
			case ListaComandos.MOSTRAR_ALTA_CLIENTE:	
			case ListaComandos.MOSTRAR_BAJA_CLIENTE:	
			case ListaComandos.MOSTRAR_DETALLE_CLIENTE:	
			case ListaComandos.MOSTRAR_LISTA_CLIENTE:	
			case ListaComandos.MOSTRAR_MODIFICAR_CLIENTE:	
			case ListaComandos.MOSTRAR_NUMERO_CLIENTES_QUERY:
				VistaCliente.getInstance().update(contexto);
				break;
				
			// Vista Compra
			
			case ListaComandos.VENTANA_AGREGAR_ARTICULO_COMPRA:
			case ListaComandos.VENTANA_PRINCIPAL_COMPRA:
			case ListaComandos.VENTANA_DETALLE_COMPRA:
			case ListaComandos.VENTANA_DEVOLUCION_COMPRA:
			case ListaComandos.VENTANA_ELIMINAR_ARTICULO_COMPRA:
			case ListaComandos.VENTANA_GESTION_CARRITO_COMPRA:
			case ListaComandos.VENTANA_INICIAR_COMPRA:
			case ListaComandos.VENTANA_LISTA_COMPRA:	
			case ListaComandos.MOSTRAR_GESTION_CARRITO_COMPRA:
			case ListaComandos.MOSTRAR_AGREGAR_ARTICULO_COMPRA:
			case ListaComandos.MOSTRAR_ELIMINAR_ARTICULO_COMPRA:
			case ListaComandos.MOSTRAR_DEVOLUCION_ARTICULO_COMPRA:
			case ListaComandos.MOSTRAR_DETALLE_COMPRA:
			case ListaComandos.MOSTRAR_LISTA_COMPRA:
			case ListaComandos.MOSTRAR_FINALIZAR_COMPRA:
				VistaCompra.getInstance().update(contexto);
				break;				
		
			// Vista Videojuego
		
			case ListaComandos.VENTANA_ALTA_VIDEOJUEGO_PC:
			case ListaComandos.VENTANA_ALTA_VIDEOJUEGO_CONSOLA:
			case ListaComandos.VENTANA_BAJA_VIDEOJUEGO:
			case ListaComandos.VENTANA_PRINCIPAL_VIDEOJUEGO:
			case ListaComandos.VENTANA_DETALLE_VIDEOJUEGO:
			case ListaComandos.VENTANA_LISTA_VIDEOJUEGO:
			case ListaComandos.VENTANA_MODIFICAR_VIDEOJUEGO_PC:
			case ListaComandos.VENTANA_MODIFICAR_VIDEOJUEGO_CONSOLA:
			case ListaComandos.VENTANA_CANTIDAD_VIDEOJUEGOS_QUERY:
			case ListaComandos.MOSTRAR_ALTA_VIDEOJUEGO:	
			case ListaComandos.MOSTRAR_BAJA_VIDEOJUEGO:	
			case ListaComandos.MOSTRAR_DETALLE_VIDEOJUEGO:	
			case ListaComandos.MOSTRAR_LISTA_VIDEOJUEGO:	
			case ListaComandos.MOSTRAR_MODIFICAR_VIDEOJUEGO:	
			case ListaComandos.MOSTRAR_CANTIDAD_VIDEOJUEGOS_QUERY:
				VistaVideojuego.getInstance().update(contexto);
				break;
				
			// Vista Seccion
				
			case ListaComandos.VENTANA_ALTA_SECCION:
			case ListaComandos.VENTANA_BAJA_SECCION:
			case ListaComandos.VENTANA_PRINCIPAL_SECCION:
			case ListaComandos.VENTANA_DETALLE_SECCION:
			case ListaComandos.VENTANA_LISTA_SECCION:
			case ListaComandos.VENTANA_MODIFICAR_SECCION:
			case ListaComandos.VENTANA_CALCULAR_NOMINA_SECCION:
			case ListaComandos.MOSTRAR_ALTA_SECCION:
			case ListaComandos.MOSTRAR_BAJA_SECCION:
			case ListaComandos.MOSTRAR_DETALLE_SECCION:
			case ListaComandos.MOSTRAR_LISTA_SECCION:
			case ListaComandos.MOSTRAR_MODIFICAR_SECCION:
			case ListaComandos.MOSTRAR_CALCULAR_NOMINA_SECCION:
				VistaSeccion.getInstance().update(contexto);
				break;
				
			// Vista Empleado
			
			case ListaComandos.VENTANA_ALTA_EMPLEADO:
			case ListaComandos.VENTANA_BAJA_EMPLEADO:
			case ListaComandos.VENTANA_PRINCIPAL_EMPLEADO:
			case ListaComandos.VENTANA_DETALLE_EMPLEADO:
			case ListaComandos.VENTANA_LISTA_EMPLEADO:
			case ListaComandos.VENTANA_MODIFICAR_EMPLEADO:
			case ListaComandos.MOSTRAR_ALTA_EMPLEADO:
			case ListaComandos.MOSTRAR_BAJA_EMPLEADO:
			case ListaComandos.MOSTRAR_DETALLE_EMPLEADO:
			case ListaComandos.MOSTRAR_LISTA_EMPLEADO:
			case ListaComandos.MOSTRAR_MODIFICAR_EMPLEADO:
				VistaEmpleado.getInstance().update(contexto);
				break;
				
			// Vista Tienda
			
			case ListaComandos.VENTANA_ALTA_TIENDA:
			case ListaComandos.VENTANA_BAJA_TIENDA:
			case ListaComandos.VENTANA_PRINCIPAL_TIENDA:
			case ListaComandos.VENTANA_DETALLE_TIENDA:
			case ListaComandos.VENTANA_LISTA_TIENDA:
			case ListaComandos.VENTANA_MODIFICAR_TIENDA:
			case ListaComandos.VENTANA_ASIGNAR_SECCION_TIENDA:
			case ListaComandos.VENTANA_DESASIGNAR_SECCION_TIENDA:
			case ListaComandos.VENTANA_ASIGNAR_PRESUPUESTO_TIENDA:
			case ListaComandos.VENTANA_DETALLE_PRESUPUESTO_TIENDA:
			case ListaComandos.VENTANA_LISTA_PRESUPUESTO_TIENDA:
			case ListaComandos.MOSTRAR_ALTA_TIENDA:
			case ListaComandos.MOSTRAR_BAJA_TIENDA:
			case ListaComandos.MOSTRAR_DETALLE_TIENDA:
			case ListaComandos.MOSTRAR_LISTA_TIENDA:
			case ListaComandos.MOSTRAR_MODIFICAR_TIENDA:
			case ListaComandos.MOSTRAR_ASIGNAR_TIENDA:
			case ListaComandos.MOSTRAR_DESASIGNAR_TIENDA:
			case ListaComandos.MOSTRAR_ASIGNAR_SECCION_TIENDA:
			case ListaComandos.MOSTRAR_DESASIGNAR_SECCION_TIENDA:
			case ListaComandos.MOSTRAR_ASIGNAR_PRESUPUESTO_TIENDA:
			case ListaComandos.MOSTRAR_DETALLE_PRESUPUESTO_TIENDA:
			case ListaComandos.MOSTRAR_LISTA_PRESUPUESTO_TIENDA:
				VistaTienda.getInstance().update(contexto);
				break; 
		}
	}
}