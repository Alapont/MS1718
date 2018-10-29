package negocio.compra.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Clase de la capa Negocio que implementa el Trasnfer de commpra
 */
public class TransferCompra {
	private int id;
	private int idCliente;
	private double costeTotal;
	private Date fecha;
	private HashMap<Integer, Integer> lineaCompra;
	private String log;
	private boolean activo;
	
	/**
	 * Constructor (se usa al crear una compra)
	 * @param idCliente: identificador del cliente
	 * @param costeTotal: representa el coste total de la compra
	 * @param activo: representa si la compra esta activa
	 */
	public TransferCompra(int idCliente, double costeTotal, boolean activo){
		this.idCliente = idCliente;
		this.costeTotal = costeTotal;
		this.fecha = new java.sql.Date(new java.util.Date().getTime());
		lineaCompra = new HashMap<Integer, Integer>();
		log = "";
		this.activo = activo;
	}
	
	/**
	 * Constructor con todos los parametros
	 * @param id: identificador de la compra
	 * @param idCliente: identificador del cliente
	 * @param costeTotal: representa el coste total de la compra
	 * @param fecha: representa la fecha de la compra
	 * @param activo: representa si la compra esta activa
	 */
	public TransferCompra(int id, int idCliente, double costeTotal, Date fecha, boolean activo){
		this.id = id;
		this.idCliente = idCliente;
		this.costeTotal = costeTotal;
		this.fecha = fecha;
		lineaCompra = new HashMap<Integer, Integer>();
		log = "";
		this.activo = activo;
	}
	
	//Getters y Setters
	public boolean getExisteArticulo(int parseInt) {
		boolean existe = false;
		
		if(lineaCompra.containsKey(parseInt))
			existe = true;
		return existe;
	}

	public void setLineaCompra(int parseInt, int i) {
		if(lineaCompra.containsKey(parseInt))
		{
			lineaCompra.put(parseInt, lineaCompra.get(parseInt) + i);
		
			if(lineaCompra.get(parseInt) <= 0)
				lineaCompra.remove(parseInt);
		}
		else
			lineaCompra.put(parseInt, i);
		
	}

	public HashMap<Integer, Integer> getLineaCompra(){
		return lineaCompra;
	}
	
	public boolean isVaciaLineaCompra() {
		return lineaCompra.isEmpty();
	}

	public void setCosteTotal(double d) {
		this.costeTotal = d;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public void setLineaCompra(HashMap<Integer, Integer> lineaCompra) {
		this.lineaCompra = lineaCompra;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getLog() {
		return log;
	}

	public double getCosteTotal() {
		return costeTotal;
	}
	
	/**
	 * Metodo que se encarga de borrar una compra especifica
	 * @param idCompra: identificador de la compra a borrar
	 */
	public void removeLineaCompra(Integer idCompra) {
		if(lineaCompra.containsKey(idCompra))
			lineaCompra.remove(idCompra);
	}

	public void setLog(String string) {
		this.log += string + "\n";
	}
	
	public String toString (){
		String s = "Id: " + id + " Cliente: " + idCliente + " Coste total: " + costeTotal + " Fecha: " + fecha + " Activo: " + activo + "\nEstas son las compras:\n";
		int contador = 1;
		Iterator<Entry<Integer, Integer>> it = this.lineaCompra.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry<Integer, Integer> t = (Map.Entry<Integer, Integer>) it.next();
			s += contador + ": Articulo: " + t.getKey() + "   Unidades: " + t.getValue() + "\n";
			contador++;
		}
		
		return s;
	}

}
