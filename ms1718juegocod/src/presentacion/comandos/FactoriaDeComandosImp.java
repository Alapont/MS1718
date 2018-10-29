package presentacion.comandos;

import presentacion.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.comandos.imp.NegocioAgregarArticuloCompraComando;
import presentacion.comandos.imp.NegocioAltaEmpleadoComando;
import presentacion.comandos.imp.NegocioAltaSeccionComando;
import presentacion.comandos.imp.NegocioAltaTiendaComando;
import presentacion.comandos.imp.NegocioAltaVideojuegoComando;
import presentacion.comandos.imp.NegocioAltaClienteComando;
import presentacion.comandos.imp.NegocioAsignarPresupuestoTiendaComando;
import presentacion.comandos.imp.NegocioAsignarSeccionTiendaComando;
import presentacion.comandos.imp.NegocioBajaEmpleadoComando;
import presentacion.comandos.imp.NegocioBajaSeccionComando;
import presentacion.comandos.imp.NegocioBajaTiendaComando;
import presentacion.comandos.imp.NegocioBajaVideojuegoComando;
import presentacion.comandos.imp.NegocioBajaClienteComando;
import presentacion.comandos.imp.NegocioCalcularNominaSeccionComando;
import presentacion.comandos.imp.NegocioCantidadVideojuegosComando;
import presentacion.comandos.imp.NegocioDesasignarSeccionTiendaComando;
import presentacion.comandos.imp.NegocioDetalleEmpleadoComando;
import presentacion.comandos.imp.NegocioDetallePresupuestoTiendaComando;
import presentacion.comandos.imp.NegocioDetalleSeccionComando;
import presentacion.comandos.imp.NegocioDetalleTiendaComando;
import presentacion.comandos.imp.NegocioDetalleVideojuegoComando;
import presentacion.comandos.imp.NegocioDetalleClienteComando;
import presentacion.comandos.imp.NegocioDetalleCompraComando;
import presentacion.comandos.imp.NegocioDevolucionCompraComando;
import presentacion.comandos.imp.NegocioEliminarArticuloCompraComando;
import presentacion.comandos.imp.NegocioFinalizarCompraComando;
import presentacion.comandos.imp.NegocioGestionCarritoCompraComando;
import presentacion.comandos.imp.NegocioListaEmpleadoComando;
import presentacion.comandos.imp.NegocioListaPresupuestoTiendaComando;
import presentacion.comandos.imp.NegocioListaSeccionComando;
import presentacion.comandos.imp.NegocioListaTiendaComando;
import presentacion.comandos.imp.NegocioListaVideojuegoComando;
import presentacion.comandos.imp.NegocioListaClienteComando;
import presentacion.comandos.imp.NegocioListaCompraComando;
import presentacion.comandos.imp.NegocioModificarEmpleadoComando;
import presentacion.comandos.imp.NegocioModificarSeccionComando;
import presentacion.comandos.imp.NegocioModificarTiendaComando;
import presentacion.comandos.imp.NegocioModificarVideojuegoComando;
import presentacion.comandos.imp.NegocioModificarClienteComando;
import presentacion.comandos.imp.NegocioNumeroClientesComando;
import presentacion.comandos.imp.VistaAgregarArticuloCompraComando;
import presentacion.comandos.imp.VistaAltaEmpleadoComando;
import presentacion.comandos.imp.VistaAltaSeccionComando;
import presentacion.comandos.imp.VistaAltaTiendaComando;
import presentacion.comandos.imp.VistaAltaVideojuegoPCComando;
import presentacion.comandos.imp.VistaAltaVideojuegoConsolaComando;
import presentacion.comandos.imp.VistaAltaClienteComando;
import presentacion.comandos.imp.VistaAsignarPresupuestoTiendaComando;
import presentacion.comandos.imp.VistaAsignarSeccionTiendaComando;
import presentacion.comandos.imp.VistaBajaEmpleadoComando;
import presentacion.comandos.imp.VistaBajaSeccionComando;
import presentacion.comandos.imp.VistaBajaTiendaComando;
import presentacion.comandos.imp.VistaBajaVideojuegoComando;
import presentacion.comandos.imp.VistaBajaClienteComando;
import presentacion.comandos.imp.VistaBotoneraEmpleadoComando;
import presentacion.comandos.imp.VistaBotoneraSeccionComando;
import presentacion.comandos.imp.VistaBotoneraTiendaComando;
import presentacion.comandos.imp.VistaCalcularNominaSeccionComando;
import presentacion.comandos.imp.VistaDesasignarSeccionTiendaComando;
import presentacion.comandos.imp.VistaDetalleEmpleadoComando;
import presentacion.comandos.imp.VistaDetallePresupuestoTiendaComando;
import presentacion.comandos.imp.VistaDetalleSeccionComando;
import presentacion.comandos.imp.VistaDetalleTiendaComando;
import presentacion.comandos.imp.VistaListaEmpleadoComando;
import presentacion.comandos.imp.VistaListaPresupuestoTiendaComando;
import presentacion.comandos.imp.VistaListaSeccionComando;
import presentacion.comandos.imp.VistaListaTiendaComando;
import presentacion.comandos.imp.VistaModificarEmpleadoComando;
import presentacion.comandos.imp.VistaModificarSeccionComando;
import presentacion.comandos.imp.VistaModificarTiendaComando;
import presentacion.comandos.imp.VistaPrincipalVideojuegoComando;
import presentacion.comandos.imp.VistaPrincipalClienteComando;
import presentacion.comandos.imp.VistaPrincipalCompraComando;
import presentacion.comandos.imp.VistaVentanaPrincipalComando;
import presentacion.comandos.imp.VistaCantidadVideojuegosQueryComando;
import presentacion.comandos.imp.VistaDetalleVideojuegoComando;
import presentacion.comandos.imp.VistaDetalleClienteComando;
import presentacion.comandos.imp.VistaDetalleCompraComando;
import presentacion.comandos.imp.VistaDevolucionCompraComando;
import presentacion.comandos.imp.VistaEliminarArticuloCompraComando;
import presentacion.comandos.imp.VistaGestionCarritoCompraComando;
import presentacion.comandos.imp.VistaIniciarCompraComando;
import presentacion.comandos.imp.VistaListaVideojuegoComando;
import presentacion.comandos.imp.VistaListaClienteComando;
import presentacion.comandos.imp.VistaListaCompraComando;
import presentacion.comandos.imp.VistaModificarVideojuegoPCComando;
import presentacion.comandos.imp.VistaModificarVideojuegoConsolaComando;
import presentacion.comandos.imp.VistaModificarClienteComando;
import presentacion.comandos.imp.VistaNumeroClientesQueryComando;

/**
 * Clase de la capa presentación que permite llamar a la vista correspondiente en funcion del evento recibido.
 */
public class FactoriaDeComandosImp extends FactoriaDeComandos{
	
	/**
	 * Metodo que elige la vista correcta en funcion del evento que le llega
	 */
	@Override
	public Comando getComando(int event){
		Comando comando = null;
		switch(event){
		
			// Principal
			case ListaComandos.VENTANA_PRINCIPAL:
				comando = new VistaVentanaPrincipalComando();
				break;

				
			// Vistas Cliente	
			
			case ListaComandos.VENTANA_ALTA_CLIENTE:
				comando = new VistaAltaClienteComando();
				break;
			case ListaComandos.VENTANA_BAJA_CLIENTE:
				comando = new VistaBajaClienteComando();
				break;
			case ListaComandos.VENTANA_PRINCIPAL_CLIENTE:
				comando = new VistaPrincipalClienteComando();
				break;
			case ListaComandos.VENTANA_DETALLE_CLIENTE:
				comando = new VistaDetalleClienteComando();
				break;
			case ListaComandos.VENTANA_LISTA_CLIENTE:
				comando = new VistaListaClienteComando();
				break;
			case ListaComandos.VENTANA_MODIFICAR_CLIENTE:
				comando = new VistaModificarClienteComando();
				break;
			case ListaComandos.VENTANA_NUMERO_CLIENTES_QUERY:
				comando = new VistaNumeroClientesQueryComando();
				break;				
				
			// Vistas Compra
				
			case ListaComandos.VENTANA_AGREGAR_ARTICULO_COMPRA:
				comando = new VistaAgregarArticuloCompraComando();
				break;
			case ListaComandos.VENTANA_PRINCIPAL_COMPRA:
				comando = new VistaPrincipalCompraComando();
				break;
			case ListaComandos.VENTANA_DETALLE_COMPRA:
				comando = new VistaDetalleCompraComando();
				break;
			case ListaComandos.VENTANA_DEVOLUCION_COMPRA:
				comando = new VistaDevolucionCompraComando();
				break;
			case ListaComandos.VENTANA_ELIMINAR_ARTICULO_COMPRA:
				comando = new VistaEliminarArticuloCompraComando();
				break;
			case ListaComandos.VENTANA_GESTION_CARRITO_COMPRA:
				comando = new VistaGestionCarritoCompraComando();
				break;
			case ListaComandos.VENTANA_INICIAR_COMPRA:
				comando = new VistaIniciarCompraComando();
				break;
			case ListaComandos.VENTANA_LISTA_COMPRA:
				comando = new VistaListaCompraComando();
				break;
				
			// Vistas Videojuego	
			
			case ListaComandos.VENTANA_ALTA_VIDEOJUEGO_PC:
				comando = new VistaAltaVideojuegoPCComando();
				break;
			case ListaComandos.VENTANA_ALTA_VIDEOJUEGO_CONSOLA:
				comando = new VistaAltaVideojuegoConsolaComando();
				break;
			case ListaComandos.VENTANA_BAJA_VIDEOJUEGO:
				comando = new VistaBajaVideojuegoComando();
				break;
			case ListaComandos.VENTANA_PRINCIPAL_VIDEOJUEGO:
				comando = new VistaPrincipalVideojuegoComando();
				break;
			case ListaComandos.VENTANA_DETALLE_VIDEOJUEGO:
				comando = new VistaDetalleVideojuegoComando();
				break;
			case ListaComandos.VENTANA_LISTA_VIDEOJUEGO:
				comando = new VistaListaVideojuegoComando();
				break;
			case ListaComandos.VENTANA_MODIFICAR_VIDEOJUEGO_PC:
				comando = new VistaModificarVideojuegoPCComando();
				break;
			case ListaComandos.VENTANA_MODIFICAR_VIDEOJUEGO_CONSOLA:
				comando = new VistaModificarVideojuegoConsolaComando();
				break;
			case ListaComandos.VENTANA_CANTIDAD_VIDEOJUEGOS_QUERY:
				comando = new VistaCantidadVideojuegosQueryComando();
				break;
				
			// Vistas Seccion
				
			case ListaComandos.VENTANA_ALTA_SECCION:
				comando = new VistaAltaSeccionComando();
				break;
			case ListaComandos.VENTANA_BAJA_SECCION:
				comando = new VistaBajaSeccionComando();
				break;
			case ListaComandos.VENTANA_PRINCIPAL_SECCION:
				comando = new VistaBotoneraSeccionComando();
				break;
			case ListaComandos.VENTANA_DETALLE_SECCION:
				comando = new VistaDetalleSeccionComando();
				break;
			case ListaComandos.VENTANA_LISTA_SECCION:
				comando = new VistaListaSeccionComando();
				break;
			case ListaComandos.VENTANA_MODIFICAR_SECCION:
				comando = new VistaModificarSeccionComando();
				break;
			case ListaComandos.VENTANA_CALCULAR_NOMINA_SECCION:
				comando = new VistaCalcularNominaSeccionComando();
				break;
	
			// Vistas Empleado
				
			case ListaComandos.VENTANA_ALTA_EMPLEADO:
				comando = new VistaAltaEmpleadoComando();
				break;
			case ListaComandos.VENTANA_BAJA_EMPLEADO:
				comando = new VistaBajaEmpleadoComando();
				break;
			case ListaComandos.VENTANA_PRINCIPAL_EMPLEADO:
				comando = new VistaBotoneraEmpleadoComando();
				break;
			case ListaComandos.VENTANA_DETALLE_EMPLEADO:
				comando = new VistaDetalleEmpleadoComando();
				break;
			case ListaComandos.VENTANA_LISTA_EMPLEADO:
				comando = new VistaListaEmpleadoComando();
				break;
			case ListaComandos.VENTANA_MODIFICAR_EMPLEADO:
				comando = new VistaModificarEmpleadoComando();
				break;
				
			// Vistas Tienda
	
			case ListaComandos.VENTANA_ALTA_TIENDA:
				comando = new VistaAltaTiendaComando();
				break;
			case ListaComandos.VENTANA_BAJA_TIENDA:
				comando = new VistaBajaTiendaComando();
				break;
			case ListaComandos.VENTANA_PRINCIPAL_TIENDA:
				comando = new VistaBotoneraTiendaComando();
				break;
			case ListaComandos.VENTANA_DETALLE_TIENDA:
				comando = new VistaDetalleTiendaComando();
				break;
			case ListaComandos.VENTANA_LISTA_TIENDA:
				comando = new VistaListaTiendaComando();
				break;
			case ListaComandos.VENTANA_MODIFICAR_TIENDA:
				comando = new VistaModificarTiendaComando();
				break;
			case ListaComandos.VENTANA_ASIGNAR_SECCION_TIENDA:
				comando = new VistaAsignarSeccionTiendaComando();
				break;
			case ListaComandos.VENTANA_DESASIGNAR_SECCION_TIENDA:
				comando = new VistaDesasignarSeccionTiendaComando();
				break;
			case ListaComandos.VENTANA_ASIGNAR_PRESUPUESTO_TIENDA:
				comando = new VistaAsignarPresupuestoTiendaComando();
				break;
			case ListaComandos.VENTANA_DETALLE_PRESUPUESTO_TIENDA:
				comando = new VistaDetallePresupuestoTiendaComando();
				break;
			case ListaComandos.VENTANA_LISTA_PRESUPUESTO_TIENDA:
				comando = new VistaListaPresupuestoTiendaComando();
				break;
					
			// Negocio	Cliente
				
			case ListaComandos.NEGOCIO_ALTA_CLIENTE:
				comando = new NegocioAltaClienteComando();
				break;
			case ListaComandos.NEGOCIO_BAJA_CLIENTE:
				comando = new NegocioBajaClienteComando();
				break;
			case ListaComandos.NEGOCIO_DETALLE_CLIENTE:
				comando = new NegocioDetalleClienteComando();
				break;
			case ListaComandos.NEGOCIO_LISTA_CLIENTE:
				comando = new NegocioListaClienteComando();
				break;
			case ListaComandos.NEGOCIO_MODIFICAR_CLIENTE:
				comando = new NegocioModificarClienteComando();
				break;	
			case ListaComandos.NEGOCIO_NUMERO_CLIENTES_QUERY:
				comando = new NegocioNumeroClientesComando();
				break;
				
			// Negocio	Compra
				
			case ListaComandos.NEGOCIO_GESTION_CARRITO_COMPRA:
				comando = new NegocioGestionCarritoCompraComando();
				break;
			case ListaComandos.NEGOCIO_AGREGAR_ARTICULO_COMPRA:
				comando = new NegocioAgregarArticuloCompraComando();
				break;
			case ListaComandos.NEGOCIO_ELIMINAR_ARTICULO_COMPRA:
				comando = new NegocioEliminarArticuloCompraComando();
				break;
			case ListaComandos.NEGOCIO_FINALIZAR_COMPRA:
				comando = new NegocioFinalizarCompraComando();
				break;
			case ListaComandos.NEGOCIO_DEVOLUCION_COMPRA:
				comando = new NegocioDevolucionCompraComando();
				break;
			case ListaComandos.NEGOCIO_DETALLE_COMPRA:
				comando = new NegocioDetalleCompraComando();
				break;
			case ListaComandos.NEGOCIO_LISTA_COMPRA:
				comando = new NegocioListaCompraComando();
				break;
				
			// Negocio	Videojuego
			
			case ListaComandos.NEGOCIO_ALTA_VIDEOJUEGO:
				comando = new NegocioAltaVideojuegoComando();
				break;
			case ListaComandos.NEGOCIO_BAJA_VIDEOJUEGO:
				comando = new NegocioBajaVideojuegoComando();
				break;
			case ListaComandos.NEGOCIO_DETALLE_VIDEOJUEGO:
				comando = new NegocioDetalleVideojuegoComando();
				break;
			case ListaComandos.NEGOCIO_LISTA_VIDEOJUEGO:
				comando = new NegocioListaVideojuegoComando();
				break;
			case ListaComandos.NEGOCIO_MODIFICAR_VIDEOJUEGO:
				comando = new NegocioModificarVideojuegoComando();
				break;
			case ListaComandos.NEGOCIO_CANTIDAD_VIDEOJUEGOS_QUERY:
				comando = new NegocioCantidadVideojuegosComando();
				break;
				
			// Negocio	Seccion
				
			case ListaComandos.NEGOCIO_ALTA_SECCION:
				comando = new NegocioAltaSeccionComando();
				break;
			case ListaComandos.NEGOCIO_BAJA_SECCION:
				comando = new NegocioBajaSeccionComando();
				break;
			case ListaComandos.NEGOCIO_DETALLE_SECCION:
				comando = new NegocioDetalleSeccionComando();
				break;
			case ListaComandos.NEGOCIO_LISTA_SECCION:
				comando = new NegocioListaSeccionComando();
				break;
			case ListaComandos.NEGOCIO_MODIFICAR_SECCION:
				comando = new NegocioModificarSeccionComando();
				break;
			case ListaComandos.NEGOCIO_CALCULAR_NOMINA_SECCION:
				comando = new NegocioCalcularNominaSeccionComando();
				break;
				
			// Negocio	Empleado
		
			case ListaComandos.NEGOCIO_ALTA_EMPLEADO:
				comando = new NegocioAltaEmpleadoComando();
				break;
			case ListaComandos.NEGOCIO_BAJA_EMPLEADO:
				comando = new NegocioBajaEmpleadoComando();
				break;
			case ListaComandos.NEGOCIO_DETALLE_EMPLEADO:
				comando = new NegocioDetalleEmpleadoComando();
				break;
			case ListaComandos.NEGOCIO_LISTA_EMPLEADO:
				comando = new NegocioListaEmpleadoComando();
				break;
			case ListaComandos.NEGOCIO_MODIFICAR_EMPLEADO:
				comando = new NegocioModificarEmpleadoComando();
				break;
				
			// Negocio	Tienda
			
			case ListaComandos.NEGOCIO_ALTA_TIENDA:
				comando = new NegocioAltaTiendaComando();
				break;
			case ListaComandos.NEGOCIO_BAJA_TIENDA:
				comando = new NegocioBajaTiendaComando();
				break;
			case ListaComandos.NEGOCIO_DETALLE_TIENDA:
				comando = new NegocioDetalleTiendaComando();
				break;
			case ListaComandos.NEGOCIO_LISTA_TIENDA:
				comando = new NegocioListaTiendaComando();
				break;
			case ListaComandos.NEGOCIO_MODIFICAR_TIENDA:
				comando = new NegocioModificarTiendaComando();
				break;
			case ListaComandos.NEGOCIO_ASIGNAR_SECCION_TIENDA:
				comando = new NegocioAsignarSeccionTiendaComando();
				break;
			case ListaComandos.NEGOCIO_DESASIGNAR_SECCION_TIENDA:
				comando = new NegocioDesasignarSeccionTiendaComando();
				break;
			case ListaComandos.NEGOCIO_ASIGNAR_PRESUPUESTO_TIENDA:
				comando = new NegocioAsignarPresupuestoTiendaComando();
				break;
			case ListaComandos.NEGOCIO_DETALLE_PRESUPUESTO_TIENDA:
				comando = new NegocioDetallePresupuestoTiendaComando();
				break;
			case ListaComandos.NEGOCIO_LISTA_PRESUPUESTO_TIENDA:
				comando = new NegocioListaPresupuestoTiendaComando();
				break;
		}
		
		return comando;
	}
}
