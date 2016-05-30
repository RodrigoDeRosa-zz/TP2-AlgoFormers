package fiuba.algo3.algoFormers.modelo.juego;

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
	
	private static int 
	filaOptimus = 1, columnaOptimus = 1, 
	filaBumblebee = 1, columnaBumblebee = 2,
	filaRatchet = 1, columnaRatchet = 3,
	filaMegatron = 2, columnaMegatron = 1, 
	filaBonecrusher = 2, columnaBonecrusher = 2,
	filaFrenzy = 2, columnaFrenzy = 3;	
	
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
		
		
	}
	
	public void ubicar(Ubicable ubicable, int fila, int columna) {
		
		Posicion pos = new Posicion(fila, columna);
		this.mapa.ubicar(ubicable, pos);
	}
	

	//Metodos para las pruebas
	public Ubicable getUbicable(Posicion posicion) {
		return this.mapa.getUbicable(posicion);
	}
	
	public Posicion getPosicionChispa(){
		return this.mapa.getPosicionChispa();
	}

}
