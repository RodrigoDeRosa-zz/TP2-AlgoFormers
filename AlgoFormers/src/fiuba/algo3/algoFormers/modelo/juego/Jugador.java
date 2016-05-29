package fiuba.algo3.algoFormers.modelo.juego;

import java.util.List;

import fiuba.algo3.algoFormers.modelo.fabricas.AlgoformerFactory;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class Jugador {
	
	protected AlgoformerFactory fabrica;
	protected List<AlgoFormer> personajes;
	
	public Jugador(){
		
		fabrica = new AlgoformerFactory();
	}
	
	public abstract void inicializarEquipo();
	
	public abstract void ubicarPersonajes(Mapa mapa);
		
	
}
