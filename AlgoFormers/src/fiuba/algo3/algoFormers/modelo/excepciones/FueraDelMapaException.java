package fiuba.algo3.algoFormers.modelo.excepciones;

public class FueraDelMapaException extends RuntimeException{
	private static String MENSAJE ="Se termino el mapa";
	
	public FueraDelMapaException(){
		super(MENSAJE);
	}
}
