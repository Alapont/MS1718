package presentacion.controlador;

public class PareadoQuery {
	private int primerObjeto;
	private int segundoObjeto;
	
	/**
	 * Constructor con parametros
	 * @param primerObjeto: 
	 * @param segundoObjeto: 
	 */
	public PareadoQuery(int primerObjeto, int segundoObjeto) {
		this.primerObjeto = primerObjeto;
		this.segundoObjeto = segundoObjeto;
	}
	
	/**
	 * Getters y Setters
	 */
	public int getPrimeroObjeto() {
		return primerObjeto;
	}
	
	public int getSegundoObjeto() {
		return segundoObjeto;
	}
	
	public void setPrimerObjeto(int primerObjeto) {
		this.primerObjeto = primerObjeto;
	}
	
	public void setSegundoObjeto(int segundoObjeto) {
		this.segundoObjeto = segundoObjeto;
	}	
}
