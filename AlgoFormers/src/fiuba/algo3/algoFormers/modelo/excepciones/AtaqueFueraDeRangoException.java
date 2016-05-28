package fiuba.algo3.algoFormers.modelo.excepciones;

public class AtaqueFueraDeRangoException extends RuntimeException {
	
	private static String MENSAJE = "No podes atacar tan lejos";
	public AtaqueFueraDeRangoException(){
		super(MENSAJE);
	}
}
