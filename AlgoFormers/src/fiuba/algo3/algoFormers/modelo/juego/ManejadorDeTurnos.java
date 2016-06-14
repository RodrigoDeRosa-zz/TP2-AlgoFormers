package fiuba.algo3.algoFormers.modelo.juego;

import fiuba.algo3.algoFormers.modelo.jugadores.Jugador;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public class ManejadorDeTurnos {

	private Jugador jugadorActual;
	private Jugador jugadorOpuesto;
	
	public ManejadorDeTurnos(Jugador jugadorActual, Jugador jugadorOpuesto){
		this.setJugadorActual(jugadorActual);
		this.setJugadorOpuesto(jugadorOpuesto);
	}
	
	private void setJugadorActual(Jugador jugadorActual){
		this.jugadorActual = jugadorActual;
	}
	
	private void setJugadorOpuesto(Jugador jugadorOpuesto){
		this.jugadorOpuesto = jugadorOpuesto;
	}
	
	public Jugador jugadorActual(){
		return this.jugadorActual;
	}
	
	public void finalizarTurno(){
		this.jugadorActual.finalizarTurno();
		this.cambiarJugadores();
	}
	
	private void cambiarJugadores(){
		Jugador jugadorAux = this.jugadorActual;
		this.jugadorActual = this.jugadorOpuesto;
		this.jugadorOpuesto = jugadorAux;
	}

	public void setPersonajeActual(AutoBot personaje) {
		this.jugadorActual.setPersonajeActual(personaje);
	}
	
	public void setPersonajeActual(Decepticon personaje) {
		this.jugadorActual.setPersonajeActual(personaje);
	}
	
}
