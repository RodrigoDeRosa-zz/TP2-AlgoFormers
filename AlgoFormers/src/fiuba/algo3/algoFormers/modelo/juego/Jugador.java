package fiuba.algo3.algoFormers.modelo.juego;



import fiuba.algo3.algoFormers.modelo.fabricas.AlgoformerFactory;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class Jugador {
	
	protected AlgoformerFactory fabrica;
	
	public Jugador(){
		
		fabrica = new AlgoformerFactory();
	}
	
	/**
	 * Inicializa los algoformers del jugador segun el tipo del jugador del
	 * que se trate
	 */
	public abstract void inicializarEquipo();
	
	/**
	 * Ubica los personajes en las posiciones iniciales del mapa,
	 * enfrentados entre si.
	 * @param mapa :Mapa en estado valido
	 */
	public abstract void ubicarPersonajes(Mapa mapa);

	/**
	 * 
	 * @param nombre :Nombre del algoformer que se quiere obtener. Debe ser alguno
	 * de los prefijados en la Fabrica de personajes
	 * @return Algoformer de nombre coincidente con el recibido.
	 */
	public abstract AlgoFormer getAlgoformer(String nombre);
		
}
