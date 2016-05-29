package fiuba.algo3.algoFormers.modelo.juego;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class Turno {
	
	private Jugador jugadorActual;
	private AlgoFormer algoformerActual;
	private Accion accionActual;
	
	public Turno(Jugador jugador) {
		
		jugadorActual = jugador;
		
	}
		
	public void setAlgoformerActual(AlgoFormer algoformer) {
		
		algoformerActual = algoformer;
	}
	
	public Jugador getJugadorActual() {
		
		return jugadorActual;
	}
	
	public AlgoFormer getAlgoformerActual() {
		
		return algoformerActual;
	}
	
	public void setAccion(Accion unaAccion) {
		
		accionActual = unaAccion;
		
	}
	
	public void realizarAccion() {
		
		accionActual.ejecutar();
	}
	
}
