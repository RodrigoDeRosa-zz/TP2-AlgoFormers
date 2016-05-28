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
	
	
	public Ubicable getUbicable(Posicion posicion) {
		return this.mapa.getUbicable(posicion);
	}

	public Juego() {
		
		this.mapa = new Mapa();
		
		this.optimus = autobots.getOptimusPrime();
		this.bumblebee = autobots.getBumblebee();
		this.ratchet = autobots.getRatchet();
		
		this.megatron = decepticons.getMegatron();
		this.bonecrusher = decepticons.getBonecrusher();
		this.frenzy = decepticons.getFrenzy();
		
		
	}
	

}
