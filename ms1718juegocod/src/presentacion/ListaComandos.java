package presentacion;

/**
 * Esta clase permite la agrupacion de los enumerados que permiten gestionar los eventos de la capa presentacion, dandoles un nombre descriptivo.
 */
public class ListaComandos {
	// Vista Principal
	
    public static final int VENTANA_PRINCIPAL		 				= 101;
    
    // Vista Videojuego
    
    public static final int VENTANA_ALTA_VIDEOJUEGO_PC 				= 201;
    public static final int VENTANA_ALTA_VIDEOJUEGO_CONSOLA 		= 202;
    public static final int VENTANA_BAJA_VIDEOJUEGO					= 203;
    public static final int VENTANA_PRINCIPAL_VIDEOJUEGO 			= 204;
    public static final int VENTANA_DETALLE_VIDEOJUEGO				= 205;
    public static final int VENTANA_LISTA_VIDEOJUEGO 				= 206;
    public static final int VENTANA_MODIFICAR_VIDEOJUEGO_PC 		= 207;
    public static final int VENTANA_MODIFICAR_VIDEOJUEGO_CONSOLA	= 208;
    
    // Vista Cliente
    
    public static final int VENTANA_ALTA_CLIENTE		 			= 301;
    public static final int VENTANA_BAJA_CLIENTE					= 302;
    public static final int VENTANA_PRINCIPAL_CLIENTE	 			= 303;
    public static final int VENTANA_DETALLE_CLIENTE 				= 304;
    public static final int VENTANA_LISTA_CLIENTE	 				= 305;
    public static final int VENTANA_MODIFICAR_CLIENTE				= 306;
    
    // Vista Compra
    
    public static final int VENTANA_AGREGAR_ARTICULO_COMPRA 		= 401;
    public static final int VENTANA_PRINCIPAL_COMPRA				= 402;
    public static final int VENTANA_DETALLE_COMPRA 					= 403;
    public static final int VENTANA_DEVOLUCION_COMPRA 				= 404;
    public static final int VENTANA_ELIMINAR_ARTICULO_COMPRA		= 405;
    public static final int VENTANA_GESTION_CARRITO_COMPRA			= 406;
    public static final int VENTANA_INICIAR_COMPRA 					= 407;
    public static final int VENTANA_LISTA_COMPRA 					= 408;

    // Negocio Videojuego
    
    public static final int NEGOCIO_ALTA_VIDEOJUEGO	 				= 211;
    public static final int NEGOCIO_BAJA_VIDEOJUEGO					= 212;
    public static final int NEGOCIO_DETALLE_VIDEOJUEGO 				= 213;
    public static final int NEGOCIO_LISTA_VIDEOJUEGO 				= 214;
    public static final int NEGOCIO_MODIFICAR_VIDEOJUEGO			= 215;
   
    // Negocio Cliente
    
    public static final int NEGOCIO_ALTA_CLIENTE 					= 311;
    public static final int NEGOCIO_BAJA_CLIENTE 					= 312;
    public static final int NEGOCIO_DETALLE_CLIENTE					= 313;
    public static final int NEGOCIO_LISTA_CLIENTE 					= 314;
    public static final int NEGOCIO_MODIFICAR_CLIENTE				= 315;
   
    // Negocio Compra
    
    public static final int NEGOCIO_AGREGAR_ARTICULO_COMPRA 		= 411;
    public static final int NEGOCIO_DETALLE_COMPRA 					= 412;
    public static final int NEGOCIO_DEVOLUCION_COMPRA 				= 413;
    public static final int NEGOCIO_ELIMINAR_ARTICULO_COMPRA		= 414;
    public static final int NEGOCIO_GESTION_CARRITO_COMPRA			= 415;
    public static final int NEGOCIO_LISTA_COMPRA 					= 416;
    public static final int NEGOCIO_FINALIZAR_COMPRA				= 417;

    // Mostrar Videojuego
    
    public static final int MOSTRAR_ALTA_VIDEOJUEGO		 			= 221;
    public static final int MOSTRAR_BAJA_VIDEOJUEGO					= 222;
    public static final int MOSTRAR_DETALLE_VIDEOJUEGO				= 223;
    public static final int MOSTRAR_LISTA_VIDEOJUEGO 				= 224;
    public static final int MOSTRAR_MODIFICAR_VIDEOJUEGO	 		= 225;
    
    // Mostrar Cliente
    
    public static final int MOSTRAR_ALTA_CLIENTE		 			= 321;
    public static final int MOSTRAR_BAJA_CLIENTE					= 322;
    public static final int MOSTRAR_DETALLE_CLIENTE 				= 323;
    public static final int MOSTRAR_LISTA_CLIENTE 					= 324;
    public static final int MOSTRAR_MODIFICAR_CLIENTE				= 325;
    
    // Mostrar Compra
    public static final int MOSTRAR_GESTION_CARRITO_COMPRA			= 431;
    public static final int MOSTRAR_AGREGAR_ARTICULO_COMPRA			= 432;
    public static final int MOSTRAR_ELIMINAR_ARTICULO_COMPRA		= 433;
    public static final int MOSTRAR_DEVOLUCION_ARTICULO_COMPRA		= 434;
    public static final int MOSTRAR_BAJA_COMPRA						= 435;
    public static final int MOSTRAR_DETALLE_COMPRA					= 436;
    public static final int MOSTRAR_LISTA_COMPRA 					= 437;
    public static final int MOSTRAR_FINALIZAR_COMPRA				= 438;
    
    
    // Vista Query
    
    public static final int VENTANA_NUMERO_CLIENTES_QUERY			= 501;
    public static final int VENTANA_CANTIDAD_VIDEOJUEGOS_QUERY		= 502;
    
    // Negocio query
    
    public static final int NEGOCIO_NUMERO_CLIENTES_QUERY			= 511;
    public static final int NEGOCIO_CANTIDAD_VIDEOJUEGOS_QUERY		= 512;
    
    // Mostrar Query
    
    public static final int MOSTRAR_NUMERO_CLIENTES_QUERY			= 531;
    public static final int MOSTRAR_CANTIDAD_VIDEOJUEGOS_QUERY		= 532;
    
// Modulo JPA
    
    // Vista Seccion
    
    public static final int VENTANA_ALTA_SECCION		 			= 601;
    public static final int VENTANA_BAJA_SECCION					= 602;
    public static final int VENTANA_PRINCIPAL_SECCION	 			= 603;
    public static final int VENTANA_DETALLE_SECCION 				= 604;
    public static final int VENTANA_LISTA_SECCION					= 605;
    public static final int VENTANA_MODIFICAR_SECCION		 		= 606;
    public static final int VENTANA_CALCULAR_NOMINA_SECCION	 		= 607;
    
    // Vista Empleado
    
    public static final int VENTANA_ALTA_EMPLEADO			 		= 701;
    public static final int VENTANA_BAJA_EMPLEADO					= 703;
    public static final int VENTANA_PRINCIPAL_EMPLEADO 				= 704;
    public static final int VENTANA_DETALLE_EMPLEADO 				= 705;
    public static final int VENTANA_LISTA_EMPLEADO					= 706;
    public static final int VENTANA_MODIFICAR_EMPLEADO		 		= 707;
    
    // Vista Tienda
    
    public static final int VENTANA_ALTA_TIENDA 					= 801;
    public static final int VENTANA_BAJA_TIENDA						= 802;
    public static final int VENTANA_PRINCIPAL_TIENDA 				= 803;
    public static final int VENTANA_DETALLE_TIENDA					= 804;
    public static final int VENTANA_LISTA_TIENDA					= 805;
    public static final int VENTANA_MODIFICAR_TIENDA				= 806;
    public static final int VENTANA_ASIGNAR_TIENDA 					= 807;
    public static final int VENTANA_DESASIGNAR_TIENDA				= 808;
    public static final int VENTANA_ASIGNAR_SECCION_TIENDA			= 809;
    public static final int VENTANA_DESASIGNAR_SECCION_TIENDA		= 810;
    public static final int VENTANA_ASIGNAR_PRESUPUESTO_TIENDA		= 811;
    public static final int VENTANA_DETALLE_PRESUPUESTO_TIENDA		= 812;
    public static final int VENTANA_LISTA_PRESUPUESTO_TIENDA		= 813;
    
    // Negocio Seccion
    
    public static final int NEGOCIO_ALTA_SECCION		 			= 611;
    public static final int NEGOCIO_BAJA_SECCION					= 612;
    public static final int NEGOCIO_DETALLE_SECCION 				= 613;
    public static final int NEGOCIO_LISTA_SECCION					= 614;
    public static final int NEGOCIO_MODIFICAR_SECCION				= 615;
    public static final int NEGOCIO_CALCULAR_NOMINA_SECCION			= 616;
    
    // Negocio Empleado
    
    public static final int NEGOCIO_ALTA_EMPLEADO		 			= 711;
    public static final int NEGOCIO_BAJA_EMPLEADO					= 712;
    public static final int NEGOCIO_DETALLE_EMPLEADO 				= 713;
    public static final int NEGOCIO_LISTA_EMPLEADO					= 714;
    public static final int NEGOCIO_MODIFICAR_EMPLEADO				= 715;
    
    // Negocio Tienda
    
    public static final int NEGOCIO_ALTA_TIENDA 					= 821;
    public static final int NEGOCIO_BAJA_TIENDA						= 822;
    public static final int NEGOCIO_DETALLE_TIENDA					= 823;
    public static final int NEGOCIO_LISTA_TIENDA					= 824;
    public static final int NEGOCIO_MODIFICAR_TIENDA				= 825;
    public static final int NEGOCIO_ASIGNAR_SECCION_TIENDA			= 826;
    public static final int NEGOCIO_DESASIGNAR_SECCION_TIENDA		= 827;
    public static final int NEGOCIO_ASIGNAR_PRESUPUESTO_TIENDA		= 828;
    public static final int NEGOCIO_DETALLE_PRESUPUESTO_TIENDA		= 829;
    public static final int NEGOCIO_LISTA_PRESUPUESTO_TIENDA		= 830;
    
    // Mostrar Seccion
    
    public static final int MOSTRAR_ALTA_SECCION		 			= 621;
    public static final int MOSTRAR_BAJA_SECCION					= 622;
    public static final int MOSTRAR_DETALLE_SECCION 				= 623;
    public static final int MOSTRAR_LISTA_SECCION 					= 624;
    public static final int MOSTRAR_MODIFICAR_SECCION		 		= 625;
    public static final int MOSTRAR_CALCULAR_NOMINA_SECCION	 		= 626;
    
    // Mostrar Empleado
    
    public static final int MOSTRAR_ALTA_EMPLEADO		 			= 721;
    public static final int MOSTRAR_BAJA_EMPLEADO					= 722;
    public static final int MOSTRAR_DETALLE_EMPLEADO 				= 723;
    public static final int MOSTRAR_LISTA_EMPLEADO 					= 724;
    public static final int MOSTRAR_MODIFICAR_EMPLEADO		 		= 725;
    public static final int MOSTRAR_CALCULAR_NOMINA_EMPLEADO	 	= 726;
    
    // Mostrar Tienda
    
    public static final int MOSTRAR_ALTA_TIENDA 					= 841;
    public static final int MOSTRAR_BAJA_TIENDA						= 842;
    public static final int MOSTRAR_DETALLE_TIENDA					= 843;
    public static final int MOSTRAR_LISTA_TIENDA					= 844;
    public static final int MOSTRAR_MODIFICAR_TIENDA				= 845;
    public static final int MOSTRAR_ASIGNAR_TIENDA 					= 846;
    public static final int MOSTRAR_DESASIGNAR_TIENDA				= 847;
    public static final int MOSTRAR_ASIGNAR_SECCION_TIENDA			= 848;
    public static final int MOSTRAR_DESASIGNAR_SECCION_TIENDA		= 849;
    public static final int MOSTRAR_ASIGNAR_PRESUPUESTO_TIENDA		= 850;   
    public static final int MOSTRAR_DETALLE_PRESUPUESTO_TIENDA		= 851;
    public static final int MOSTRAR_LISTA_PRESUPUESTO_TIENDA		= 852;
}
