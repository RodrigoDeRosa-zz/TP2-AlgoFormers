package fiuba.algo3.algoFormers.modelo.excepciones;

public class AtaqueEspacioVacioException extends RuntimeException{
	
	private static String MENSAJE = "En ese lugar no hay nada";
	public AtaqueEspacioVacioException(){
		super(MENSAJE);
	}
}	
