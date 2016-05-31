package fiuba.algo3.algoFormers.modelo.juego;

import fiuba.algo3.algoFormers.modelo.capturables.Chispa;
import fiuba.algo3.algoFormers.modelo.fabricas.*;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
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
		this.ubicarAtacable(optimus, filaOptimus, columnaOptimus);
		this.ubicarAtacable(bumblebee, filaBumblebee, columnaBumblebee);
		this.ubicarAtacable(ratchet, filaRatchet, columnaRatchet);
		
		this.megatron = decepticons.getMegatron();
		this.bonecrusher = decepticons.getBonecrusher();
		this.frenzy = decepticons.getFrenzy();
		this.ubicarAtacable(megatron, filaMegatron, columnaMegatron);
		this.ubicarAtacable(bonecrusher, filaBonecrusher, columnaBonecrusher);
		this.ubicarAtacable(frenzy, filaFrenzy, columnaFrenzy);
		
		this.chispa = new Chispa();
		this.ubicarChispa(this.chispa);
		
		}
	
	public void ubicarAtacable(Atacable atacable, int fila, int columna) {
		
		Posicion pos = new Posicion(fila, columna);
		this.mapa.ubicarAtacable(atacable, pos);
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
