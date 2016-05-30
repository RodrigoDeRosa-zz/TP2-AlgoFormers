package fiuba.algo3.algoFormers.modelo.juego;

import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.Chispa;

public class Juego {

	private Mapa mapa;
	private Jugador jugadorAutobots;
	private Jugador jugadorDecepticons;
	private Turno turnoActual;
	private Chispa chispaSuprema;
	
	public Juego() {
		
		mapa = new Mapa();
		
		jugadorAutobots = new JugadorAutobots();
		jugadorAutobots.inicializarEquipo();
		jugadorAutobots.ubicarPersonajes(mapa);
		
		jugadorDecepticons = new JugadorDecepticons();
		jugadorDecepticons.inicializarEquipo();
		jugadorDecepticons.ubicarPersonajes(mapa);
		
		chispaSuprema = new Chispa("CHISPA SUPREMA");
		ubicarChispa();
				
	}	
	
	private void ubicarChispa() {
		mapa.ubicarChispa(chispaSuprema);
		
	}

	public void Jugar() {
		
		while (true) {
			
			turnoActual = new Turno(jugadorAutobots);
			//turnoActual.realizarAccion(accion);
		}		
		
	}	
	
	public Ubicable getUbicable(Posicion posicion) {
		
		return mapa.getUbicable(posicion);
	}
	
	public Jugador getJugadorActual() {
		
		return jugadorAutobots;
	}
	
	public Mapa getMapa() {
	
		return mapa;
	}	
	
	
	/* METODOS PARA TESTS */
	public Jugador getJugadorAutobots() {
		
		return jugadorAutobots;
	}
	
	public Jugador getJugadorDecepticons() {
		
		return jugadorDecepticons;
	}



	public Posicion getPosicionChispa() {
		
		return mapa.getPosicionChispa(chispaSuprema);
	}
		
}
