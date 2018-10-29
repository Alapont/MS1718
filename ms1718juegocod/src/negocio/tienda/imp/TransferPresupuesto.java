package negocio.tienda.imp;

public class TransferPresupuesto {
	private int seccion;
	private int tienda;
	private double cantidad;
	private boolean activo;
	
	public TransferPresupuesto(int seccion, int tienda) {
		this.seccion = seccion;
		this.tienda = tienda;
	}	
	
	public TransferPresupuesto(int seccion, int tienda, boolean activo) {
		this.seccion = seccion;
		this.tienda = tienda;
		this.activo = activo;
	}
	
	public TransferPresupuesto(int seccion, int tienda, double cantidad, boolean activo) {
		this.seccion = seccion;
		this.tienda = tienda;
		this.cantidad = cantidad;
		this.activo = activo;
	}
	
	public int getSeccion() {
		return seccion;
	}
	
	public int getTienda() {
		return tienda;
	}
	
	public Double getCantidad() {
		return cantidad;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public void setSeccion(int seccion) {
		this.seccion = seccion;
	}
	
	public void setTienda(int tienda) {
		this.tienda = tienda;
	}
	
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}	
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String toString() {
		return "Seccion: " + seccion + " Tienda: " + tienda + " Cantidad: " + cantidad + " Activo: " + activo;
	}
}
