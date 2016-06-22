package fiuba.algo3.algoFormers.modelo.juego;

import java.util.ArrayList;
import java.util.Set;

import fiuba.algo3.algoFormers.modelo.capturables.Chispa;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.interfaces.Capturable;
import fiuba.algo3.algoFormers.modelo.jugadores.Jugador;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorAutobots;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorDecepticons;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class Juego {

	private Mapa mapa;
	private Chispa chispa;
	private ManejadorDeTurnos manejadorTurnos;
	private ManejadorDeAcciones manejadorAcciones;
	private JugadorAutobots jugadorA;
	private JugadorDecepticons jugadorD;
	
	public Juego() {
		this.mapa = new Mapa();
		this.mapa.rellenarMapa();
		this.jugadorA = new JugadorAutobots();
		this.jugadorD = new JugadorDecepticons();
		
		this.manejadorTurnos = new ManejadorDeTurnos(jugadorA, jugadorD);
		this.manejadorAcciones = new ManejadorDeAcciones(this.mapa);
		
		this.jugadorA.ubicarPersonajes(mapa);
		this.jugadorD.ubicarPersonajes(mapa);
		
		this.chispa = new Chispa();
		this.ubicarChispa(this.chispa);
	}
	
	public void borrarPersonaje(AlgoFormer algoformer){
		this.mapa.borrarPersonaje(algoformer);
	}
	
	public void ubicarChispa(Chispa chispa){
		this.mapa.ubicarChispa(chispa);
	}
	
	public void setPersonajeActual(AlgoFormer personaje){
		this.manejadorTurnos.setPersonajeActual(personaje);
	}
	
	public void finalizarTurno(){
		this.manejadorTurnos.finalizarTurno(this.mapa);
	}
	
	public void atacar(Posicion posicion){
		//try{
		this.manejadorAcciones.atacar(this.manejadorTurnos.jugadorActual(), posicion);
		//}(catch PersonajeMuertoException e)
		this.finalizarTurno();
	}
	
	public void transformar(){
		this.manejadorAcciones.transformar(this.manejadorTurnos.jugadorActual());
		this.finalizarTurno();
	}
	
	public void combinar(){
		this.manejadorAcciones.combinar(this.manejadorTurnos.jugadorActual(), mapa);
		this.finalizarTurno();
	}
	
	public void mover(Direccion direccion){
		this.manejadorAcciones.mover(this.manejadorTurnos.jugadorActual(), direccion);
	}
	
	public ArrayList<AlgoFormer> getAlgoformersActuales() {
		return this.manejadorTurnos.getAlgoformersActuales();
	
	}

	//Metodos para las pruebas
	public Atacable getAtacable(Posicion posicion) {
		return this.mapa.getAtacable(posicion);
	}
	
	public Posicion getPosicionChispa(){
		return this.mapa.getPosicionChispa(this.chispa);
	}
	
	public Mapa getMapa(){
		return this.mapa;
	}

	public SuperficieTerrestre getSuperficieTerrestre(Posicion posicion) {
		return this.mapa.getSuperficieTerrestre(posicion);
	}

	public SuperficieAerea getSuperficieAerea(Posicion posicion) {
		return this.mapa.getSuperficieAerea(posicion);
	}

	public void setNombres(String nombreAutobot, String nombreDecepticon) {
		this.jugadorA.guardarNombre(nombreAutobot);
		this.jugadorD.guardarNombre(nombreDecepticon);
		
	}

	public Capturable getCapturable(Posicion posicion) {
		return this.mapa.getCapturable(posicion);
		
	}

	public Jugador getJugadorActual() {
		return this.manejadorTurnos.jugadorActual();
	}

	public AlgoFormer getAlgoformer(String string) {
		return null;
	}
}
