package fiuba.algo3.algoFormers.modelo.excepciones;

public class SuperficieInaccesibleException extends RuntimeException {
	
	private static final long serialVersionUID = -7874518060245944812L;
	private static String mensaje = "El personaje no puede acceder a esa superficie";
	
	public SuperficieInaccesibleException(){
		super(mensaje);
	}
}
