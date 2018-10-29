package negocio.compra.imp;

/**
 * Clase de la capa Negocio que implementa el Trasnfer de la Linea de Compra
 */
public class TransferLineaDeCompra {
	private int idCompra;
	private int idArticulo;
	private int cantidad;
	private int cantidadNueva;
        private double precio;
	private boolean activo;
	
	/**
	 * Constructor (se usa al crear una linea de compra)
	 * @param idCompra: identificador de la compra
	 * @param idArticulo: identificador del articulo
	 * @param cantidad: cantidad del articulo
         * @param precio: valor unitario
	 */
	public TransferLineaDeCompra(int idCompra, int idArticulo, int cantidad, double precio){
		this.idCompra = idCompra;
		this.idArticulo = idArticulo;
		this.cantidad = cantidad;
                this.precio = precio;
		activo = true;
	}
	
	/**
	 * Constructor con todos los parametros
	 * @param idCompra: identificador compra
	 * @param idArticulo: identificador del articulo
	 * @param cantidad: cantidad del articulo
	 * @param activo: representa si la compra esta activa
	 */
	public TransferLineaDeCompra(int idCompra, int idArticulo, int cantidad, boolean activo, double precio){
		this.idCompra = idCompra;
		this.idArticulo = idArticulo;
		this.cantidad = cantidad;
		this.activo = activo;
                this.precio = precio;
	}
	
	//Getters y Setters
	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

	public int getCantidadNueva() {
		return cantidadNueva;
	}

	public void setCantidadNueva(int cantidadNueva) {
		this.cantidadNueva = cantidadNueva;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public boolean getActivo() {
		return activo;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setCantidad(int cantidadDevolucion) {
		this.cantidad = cantidadDevolucion;
		
	}

	public void setActivo(boolean b) {
		this.activo = b;
		
	}

}
