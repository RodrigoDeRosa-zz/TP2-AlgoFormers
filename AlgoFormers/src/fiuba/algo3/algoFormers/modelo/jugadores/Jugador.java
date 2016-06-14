package fiuba.algo3.algoFormers.modelo.jugadores;

import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;


public abstract class Jugador {
	
	protected AlgoFormerFactory fabrica;
	protected Equipo equipo;
	
	public Jugador(){
		this.fabrica = new AlgoFormerFactory();
		this.equipo = new Equipo();
	}
	
	/**
	 * Define como personaje actual al recibido.
	 */
	public abstract void setPersonajeActual(AutoBot personaje);
	public abstract void setPersonajeActual(Decepticon personaje);
	
	/**
	 * Combina a sus personajes en un MegaBot
	 */
//	public void combinar(){
//		this.equipo.combinar();
//	}
	
	/**
	 * Finaliza el turno de todos los personajes de un jugador.
	 */
	public void finalizarTurno(){
		this.equipo.finalizarTurno();
	}
	
	/**
	 * Devuelve el personaje que está actualmente seleccionado
	 */
	public AlgoFormer getPersonajeActual(){
		return this.equipo.personajeActual();
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
	 * @param nombre :Nombre del algoformer que se quiere obtener. Debe ser alguno
	 * de los prefijados en la Fabrica de personajes
	 * @return Algoformer de nombre coincidente con el recibido.
	 */
	public abstract AlgoFormer getAlgoformer(String nombre);
	
}
