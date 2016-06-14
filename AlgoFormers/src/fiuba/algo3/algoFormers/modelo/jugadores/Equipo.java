package fiuba.algo3.algoFormers.modelo.jugadores;

import java.util.HashSet;

import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class Equipo {

	private HashSet<AlgoFormer> equipo;
//	private MegaBot megaBot;
	private AlgoFormer personajeActual;
//	private AlgoFormer anteriorACombinar;
//	private int turnosCombinacion = 0;
	
	public Equipo(){
		this.setEquipo();
	}
	
	private void setEquipo(){
		this.equipo = new HashSet<AlgoFormer>();
	}
	
	public void agregarIntegrante(AlgoFormer personaje){
		this.equipo.add(personaje);
		this.setPersonajeActual(personaje);
//		this.anteriorACombinar = personaje;
	}
	
//	public void setMegaBot(MegaBot megaBot){
//		this.megaBot = megaBot;
//	}
	
	public void finalizarTurno(){
		this.equipo.forEach( (personaje) -> personaje.finalizarTurno() );
	}
	
	public void setPersonajeActual(AlgoFormer personaje){
		this.personajeActual = personaje;
	}
	
	public AlgoFormer personajeActual(){
		return this.personajeActual;
	}
	
//	public void combinar(){
//		int vidaMegaBot = this.calcularVidaMegaBot();
//		this.anteriorACombinar = this.personajeActual;
//		this.personajeActual = megaBot.vida(vidaMegaBot);
//		this.turnosCombinacion = 2;
//	}
	
//	private void finalizarCombinacion(){
//		this.turnosCombinacion = 0;
//		this.personajeActual = this.anteriorACombinar;
//	}
	
//	private int calcularVidaMegaBot(){
//		int total;
//		this.equipo.forEach((personaje) -> personaje.sumarVidaA(total));
//		return total;
//	}
	
	public void ubicarPersonajes(Mapa mapa, int filaInicio) {
		int columnaActual = ( mapa.getTamanio() / 2 ) - 2;
		for (AlgoFormer algoformer : this.equipo) {   
			Posicion pos = new Posicion(filaInicio, columnaActual);
			mapa.ubicar(algoformer, pos);
            columnaActual++;
		}
	}
	
	public AlgoFormer getAlgoFormer(String nombre){
		for (AlgoFormer algoformer : this.equipo) {
			if (algoformer.getNombre() == nombre) {				
				return algoformer;
			}			
		}
		return null;
	}
}
