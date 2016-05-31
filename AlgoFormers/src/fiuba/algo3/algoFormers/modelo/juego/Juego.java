package fiuba.algo3.algoFormers.modelo.juego;

import fiuba.algo3.algoFormers.modelo.capturables.Chispa;
import fiuba.algo3.algoFormers.modelo.fabricas.*;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorAutobots;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorDecepticons;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class Juego {

	private Mapa mapa;
	private Chispa chispa;
	private JugadorAutobots jugadorA;
	private JugadorDecepticons jugadorD;
	
	public Juego() {
		
		this.mapa = new Mapa();
		jugadorA = new JugadorAutobots();
		jugadorD = new JugadorDecepticons();
		
		jugadorA.ubicarPersonajes(mapa);
		jugadorD.ubicarPersonajes(mapa);
		
		this.chispa = new Chispa();
		this.ubicarChispa(this.chispa);
		
		}
	
	
	public void ubicarChispa(Chispa chispa){
		this.mapa.ubicarChispa(chispa);
	}
	

	//Metodos para las pruebas
	public Atacable getAtacable(Posicion posicion) {
		return this.mapa.getAtacable(posicion);
	}
	
	public Posicion getPosicionChispa(){
		return this.mapa.getPosicionChispa(this.chispa);
	}

}
