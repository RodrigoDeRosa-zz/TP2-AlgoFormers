package fiuba.algo3.algoFormers.modelo.juego;

import fiuba.algo3.algoFormers.modelo.capturables.Chispa;
import fiuba.algo3.algoFormers.modelo.fabricas.*;
import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class Juego {

	private Mapa mapa;
	private static AutoBotFactory autobots = new AutoBotFactory();
	private static DecepticonFactory decepticons = new DecepticonFactory();;
	private AlgoFormer optimus, bumblebee, ratchet, megatron, bonecrusher, frenzy;
	private Chispa chispa;
	
	private static int 
	filaOptimus = 0, columnaOptimus = 18, 
	filaBumblebee = 0, columnaBumblebee = 19,
	filaRatchet = 0, columnaRatchet = 20,
	filaMegatron = 39, columnaMegatron = 18, 
	filaBonecrusher = 39, columnaBonecrusher = 19,
	filaFrenzy = 39, columnaFrenzy = 20;	
	
	public Juego() {
		
		this.mapa = new Mapa();
		
		this.optimus = autobots.getOptimusPrime();
		this.bumblebee = autobots.getBumblebee();
		this.ratchet = autobots.getRatchet();
		this.ubicar(optimus, filaOptimus, columnaOptimus);
		this.ubicar(bumblebee, filaBumblebee, columnaBumblebee);
		this.ubicar(ratchet, filaRatchet, columnaRatchet);
		
		this.megatron = decepticons.getMegatron();
		this.bonecrusher = decepticons.getBonecrusher();
		this.frenzy = decepticons.getFrenzy();
		this.ubicar(megatron, filaMegatron, columnaMegatron);
		this.ubicar(bonecrusher, filaBonecrusher, columnaBonecrusher);
		this.ubicar(frenzy, filaFrenzy, columnaFrenzy);
		
		this.chispa = new Chispa();
		this.ubicarChispa(this.chispa);
		
		}
	
	public void ubicar(Ubicable ubicable, int fila, int columna) {
		
		Posicion pos = new Posicion(fila, columna);
		this.mapa.ubicar(ubicable, pos);
	}
	
	public void ubicarChispa(Chispa chispa){
		this.mapa.ubicarChispa(chispa);
	}
	

	//Metodos para las pruebas
	public Ubicable getUbicable(Posicion posicion) {
		return this.mapa.getUbicable(posicion);
	}
	
	public Posicion getPosicionChispa(){
		return this.mapa.getPosicionChispa(this.chispa);
	}

}
