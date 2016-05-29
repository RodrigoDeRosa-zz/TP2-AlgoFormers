package fiuba.algo3.algoFormers.modelo.juego;

import fiuba.algo3.algoFormers.modelo.mapas.Mapa;

public class Juego {

	private Mapa mapa;
	private Jugador jugadorAutobots;
	private Jugador jugadorDecepticons;
	private Turno turnoActual;
	
	public Juego() {
		
		mapa = new Mapa();
		
		jugadorAutobots = new JugadorAutobots();
		jugadorAutobots.inicializarEquipo();
		jugadorAutobots.ubicarPersonajes(mapa);
		
		jugadorDecepticons = new JugadorDecepticons();
		jugadorDecepticons.inicializarEquipo();
		jugadorDecepticons.ubicarPersonajes(mapa);
				
	}
	
	public void Jugar() {
		
		while (true) {
			
			turnoActual = new Turno(jugadorAutobots);
			turnoActual.realizarAccion(accion);
		}		
		
	}	
	
	public Jugador getJugadorActual() {
		
		return jugadorAutobots;
	}
	
	public Mapa getMapa() {
	
		return mapa;
	}	
	
}
