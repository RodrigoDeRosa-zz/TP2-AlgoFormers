package fiuba.algo3.algoFormers.modelo.excepciones;

public class MovimientosAgotadosException extends RuntimeException {
	
	private static String MENSAJE = "Se alcanzaron los movimientos maximos en un turno";
	
	public MovimientosAgotadosException(){
		super(MENSAJE);
		
	}
}
