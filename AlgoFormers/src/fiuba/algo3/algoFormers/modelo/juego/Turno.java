package fiuba.algo3.algoFormers.modelo.juego;

import fiuba.algo3.algoFormers.modelo.interfaces.Accion;
import fiuba.algo3.algoFormers.modelo.personajes.Algoformer;

public class Turno {
	
	private Jugador jugadorActual;
	private Algoformer algoformerActual;
	private Accion accionActual;
	
	public Turno(Jugador jugador) {
		
		jugadorActual = jugador;
		
	}
		
	public void setAlgoformerActual(Algoformer algoformer) {
		
		algoformerActual = algoformer;
	}
	
	public Jugador getJugadorActual() {
		
		return jugadorActual;
	}
	
	public Algoformer getAlgoformerActual() {
		
		return algoformerActual;
	}
	
	public void setAccion(Accion unaAccion) {
		
		accionActual = unaAccion;
		
	}
	
	public void realizarAccion() {
		
		accionActual.ejecutar();
	}
	
}
