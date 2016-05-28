package fiuba.algo3.algoFormers.modelo.excepciones;

public class FuegoAmigoException extends RuntimeException {
	private static String MENSAJE = " FUEGO AMIGO";
	
	public FuegoAmigoException(){
		super(MENSAJE);
	}
}
