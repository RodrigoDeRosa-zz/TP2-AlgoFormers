package fiuba.algo3.algoFormers.modelo.jugadores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import fiuba.algo3.algoFormers.modelo.excepciones.EquipoNoCompletoException;
import fiuba.algo3.algoFormers.modelo.excepciones.FueraDeRangoParaCombinarException;
import fiuba.algo3.algoFormers.modelo.excepciones.SeleccionPersonajeEnemigoException;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class Equipo {

	protected HashMap<String, AlgoFormer> equipo;
	protected AlgoFormer personajeActual;
	protected AlgoFormer anteriorACombinar;
	protected int turnosCombinacion = 0;
	
	public Equipo(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres){
		this.setEquipo(uno, dos, tres);
	}
	
	private void setEquipo(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres){
		this.equipo = new HashMap<String, AlgoFormer>();
		this.agregarIntegrante(uno);
		this.agregarIntegrante(dos);
		this.agregarIntegrante(tres);
	}
	
	public void agregarIntegrante(AlgoFormer personaje){
		this.equipo.put(personaje.getNombre(), personaje);
		this.setPersonajeActual(personaje);
		this.anteriorACombinar = personaje;
	}
	
	public void finalizarTurno(){
		this.equipo.forEach( (nombre, personaje) -> personaje.finalizarTurno() );
	}
	
	public void setPersonajeActual(AlgoFormer personaje){
		AlgoFormer almacenado = this.equipo.get(personaje.getNombre());
		if (almacenado == null) throw new SeleccionPersonajeEnemigoException();
		this.personajeActual = almacenado;
	}
	
	public AlgoFormer personajeActual(){
		return this.personajeActual;
	}
	
	public void combinar(Mapa mapa){
		this.verificarCondicionesCombinacion(mapa);
		int vidaMegaBot = this.calcularVidaMegaBot();
		this.anteriorACombinar = this.personajeActual;
		this.definirMegaBotComoActual(vidaMegaBot);
		this.turnosCombinacion = 2;
	}
	
	protected abstract void definirMegaBotComoActual(int vida);
	
	private void verificarCondicionesCombinacion(Mapa mapa){
		this.verificarCantidadDePersonajes();
		this.verificarDistanciaCombinacion(mapa);
	}
	
	private void verificarCantidadDePersonajes(){
		if (this.equipo.size() < 3) throw new EquipoNoCompletoException();
	}
	
	private void verificarDistanciaCombinacion(Mapa mapa){
		Set<String> nombres = this.equipo.keySet();
		Iterator<String> iter1 = nombres.iterator();
		for (int i = 0; i < 2; i++){
			String nombre = iter1.next();
			AlgoFormer algoformer = this.equipo.get(nombre);
			Iterator<String> iter2 = nombres.iterator();
			while (iter2.hasNext()) {
				String nombreComparar = iter2.next();
				AlgoFormer algoformerComparar = this.equipo.get(nombreComparar);
				this.verificarDistanciaCombinacionEntre(algoformer, algoformerComparar, mapa);
			}
		}
	}
	
	private void verificarDistanciaCombinacionEntre(AlgoFormer uno, AlgoFormer otro, Mapa mapa){
		Posicion posicionUno = mapa.obtenerPosicion(uno);
		Posicion posicionOtro = mapa.obtenerPosicion(otro);
		int distancia = mapa.obtenerDistancia(posicionUno, posicionOtro);
		if (distancia > 2) throw new FueraDeRangoParaCombinarException();
	}
	
	private void finalizarCombinacion(){
		this.reubicarPersonajes();
		this.turnosCombinacion = 0;
		this.personajeActual = this.anteriorACombinar;
	}
	
	private void reubicarPersonajes(){
		
	}
	
	protected int calcularVidaMegaBot(){
		int total = 0;
		this.equipo.forEach( (nombre, personaje) -> personaje.sumarVidaA(total));
		return total;
	}
	
	public void ubicarPersonajes(Mapa mapa, int filaInicio) {
		int columnaActual = ( mapa.getTamanio() / 2 ) - 2;
		Set<String> nombres = this.equipo.keySet();
		Iterator<String> iter = nombres.iterator();
		while (iter.hasNext()) {
			String nombre = iter.next();
			AlgoFormer algoformer = this.equipo.get(nombre);
			Posicion pos = new Posicion(filaInicio, columnaActual);
			mapa.ubicar(algoformer, pos);
            columnaActual++;
		}
	}
	
	public AlgoFormer getAlgoFormer(String nombre){
		Set<String> nombres = this.equipo.keySet();
		Iterator<String> iter = nombres.iterator();
		while (iter.hasNext()) {
			String nombreGuardado = iter.next();
			if (nombreGuardado == nombre) {				
				return this.equipo.get(nombreGuardado);
			}			
		}
		return null;
	}
}
