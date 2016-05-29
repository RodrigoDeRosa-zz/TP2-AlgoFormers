package fiuba.algo3.algoFormers.modelo.juego;



import fiuba.algo3.algoFormers.modelo.fabricas.AlgoformerFactory;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class Jugador {
	
	protected AlgoformerFactory fabrica;
	
	public Jugador(){
		
		fabrica = new AlgoformerFactory();
	}
	
	public abstract void inicializarEquipo();
	
	public abstract void ubicarPersonajes(Mapa mapa);

	public abstract AlgoFormer getAlgoformer(String nombre);
		
}
